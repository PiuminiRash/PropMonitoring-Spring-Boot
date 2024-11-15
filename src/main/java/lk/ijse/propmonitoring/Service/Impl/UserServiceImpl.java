package lk.ijse.propmonitoring.Service.Impl;

import lk.ijse.propmonitoring.Service.UserService;
import lk.ijse.propmonitoring.dao.UserDao;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void userSave(UserDto userDto) {

    }
}
