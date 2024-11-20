package lk.ijse.propmonitoring.Service.Impl;

import lk.ijse.propmonitoring.Service.AuthService;
import lk.ijse.propmonitoring.Service.JWTService;
import lk.ijse.propmonitoring.dao.StaffDao;
import lk.ijse.propmonitoring.dao.UserDao;
import lk.ijse.propmonitoring.dto.impl.StaffDto;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import lk.ijse.propmonitoring.entity.impl.User;
import lk.ijse.propmonitoring.secure.JWTAuthResponse;
import lk.ijse.propmonitoring.secure.SignIn;
import lk.ijse.propmonitoring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDao userDao;
    private final StaffDao staffDao;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        // Authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword())
        );

        // Retrieve user details from the database
        var user = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate JWT token
        var generatedToken = jwtService.generateToken(user);

        // Return JWT response
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(StaffDto staffDto, UserDto userDto) {
        // Verify staff existence
        var staffRole = staffDao.findByEmail(staffDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email not found in staff table"));

        // Map and save the user entity
        userDto.setRole(staffRole); // Set the role based on the staff table
        User savedUser = userDao.save(mapping.toUserEntity(userDto));

        // Generate JWT token for the user
        var generatedToken = jwtService.generateToken(savedUser);

        // Return JWT response
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        // Extract username from the provided token
        var userName = jwtService.extractUserName(accessToken);

        // Validate user existence in the database
        var findUser = userDao.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate a refreshed token
        var refreshToken = jwtService.refreshToken(findUser);

        // Return refreshed token
        return JWTAuthResponse.builder().token(refreshToken).build();
    }
}
