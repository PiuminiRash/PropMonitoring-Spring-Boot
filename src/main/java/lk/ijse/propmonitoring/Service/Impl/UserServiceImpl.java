package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Exception.UserNotFoundException;
import lk.ijse.propmonitoring.Service.UserService;
import lk.ijse.propmonitoring.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoring.dao.UserDao;
import lk.ijse.propmonitoring.dto.UserStatus;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import lk.ijse.propmonitoring.entity.impl.User;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void userSave(UserDto userDto) {
        User savedUser =
                userDao.save(mapping.toUserEntity(userDto));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }

    // New method to find user by email
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElse(null);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userDao.findAll();
        return mapping.asUserDtoList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDao.existsById(userId)){
            User selectedUser = userDao.getReferenceById(userId);
            return mapping.toUserDto(selectedUser);
        }else {
            return new SelectedErrorStatus(2, "User with id " + userId + " not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> existedUser = userDao.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDto userDto) {
        Optional<User> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()) {
            tmpUser.get().setEmail(userDto.getEmail());
            tmpUser.get().setPassword(userDto.getPassword());
            tmpUser.get().setRole(userDto.getRole());
        }
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDao.findByEmail(userName)
                        .orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }
}
