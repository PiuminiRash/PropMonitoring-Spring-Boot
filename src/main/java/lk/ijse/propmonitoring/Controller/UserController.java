package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Service.UserService;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import lk.ijse.propmonitoring.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("role") String role
    ) {
        try {
            var builduserDto = new UserDto();
            builduserDto.setEmail(email);
            builduserDto.setPassword(password);
            builduserDto.setRole(Role.valueOf(role));
            userService.userSave(builduserDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
