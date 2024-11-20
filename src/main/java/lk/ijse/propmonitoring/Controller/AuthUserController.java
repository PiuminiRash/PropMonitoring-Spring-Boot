package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.AuthService;
import lk.ijse.propmonitoring.Service.UserService;
import lk.ijse.propmonitoring.dto.impl.StaffDto;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import lk.ijse.propmonitoring.entity.Role;
import lk.ijse.propmonitoring.secure.JWTAuthResponse;
import lk.ijse.propmonitoring.secure.SignIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auth/")
@RestController
@RequiredArgsConstructor
public class AuthUserController {
    private final UserService userService;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping(value = "signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> saveUser(
            @RequestPart("email") String email,
            @RequestPart("username") String username,
            @RequestPart("password") String password,
            @RequestPart("role") String role
            //add role
    ) {
        try {
            //Build the Object
            UserDto buildUserDto = new UserDto();
            StaffDto buildStaffDto = new StaffDto();
            buildUserDto.setEmail(username);
            buildUserDto.setEmail(email);
            buildUserDto.setPassword(passwordEncoder.encode(password));
            buildUserDto.setRole(Role.valueOf(role));
            return ResponseEntity.ok(authService.signUp(buildStaffDto,buildUserDto));
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "signin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn){
       return ResponseEntity.ok(authService.signIn(signIn));
    }

    @PostMapping("refresh")
    public ResponseEntity<JWTAuthResponse> refreshToken(@RequestParam ("existingToken") String existingToken) {
        return ResponseEntity.ok(authService.refreshToken(existingToken));
    }
}

//package lk.ijse.propmonitoring.Controller;
//
//import lk.ijse.propmonitoring.Exception.DataPersistException;
//import lk.ijse.propmonitoring.Service.AuthService;
//import lk.ijse.propmonitoring.Service.StaffService;
//import lk.ijse.propmonitoring.Service.UserService;
//import lk.ijse.propmonitoring.dto.impl.UserDto;
//import lk.ijse.propmonitoring.entity.Role;
//import lk.ijse.propmonitoring.entity.User;
//import lk.ijse.propmonitoring.secure.JWTAuthResponse;
//import lk.ijse.propmonitoring.secure.SignIn;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RequestMapping("auth/")
//@RestController
//@RequiredArgsConstructor
//public class AuthUserController {
//    private final StaffService s;
//    private final UserService userService;
//    private final AuthService authService;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping(value = "signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> saveUser(
//            @RequestPart("email") String email,
//            @RequestPart("username") String username,
//            @RequestPart("password") String password
//    ) {
//        try {
//            // Retrieve the role for the given email from the staff table
//            Role role = userService.findRoleByEmail(email);
//            if (role == null) {
//                return new ResponseEntity<>("Email not found in staff table", HttpStatus.NOT_FOUND);
//            }
//
//            // Build the UserDto object
//            UserDto buildUserDto = new UserDto();
//            buildUserDto.setEmail(email);
//            buildUserDto.setPassword(passwordEncoder.encode(password));
//            buildUserDto.setRole(role);
//
//            // Sign up the user
//            JWTAuthResponse response = authService.signUp(buildUserDto);
//            return ResponseEntity.ok(response);
//        } catch (DataPersistException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Error saving user data", HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping(value = "signin", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn) {
//        return ResponseEntity.ok(authService.signIn(signIn));
//    }
//
//    @PostMapping("refresh")
//    public ResponseEntity<JWTAuthResponse> refreshToken(@RequestParam("existingToken") String existingToken) {
//        return ResponseEntity.ok(authService.refreshToken(existingToken));
//    }
//}
