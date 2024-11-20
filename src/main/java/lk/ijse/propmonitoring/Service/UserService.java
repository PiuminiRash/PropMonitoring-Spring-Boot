package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.UserStatus;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void userSave(UserDto userDto);
    List<UserDto> getAllUsers();
    UserStatus getUser(String userId);
    void deleteUser(String userId);
    void updateUser(String userId, UserDto userDTO);
    UserDetailsService userDetailsService();
}
