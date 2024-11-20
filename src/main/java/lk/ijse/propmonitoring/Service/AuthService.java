package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.impl.StaffDto;
import lk.ijse.propmonitoring.dto.impl.UserDto;
import lk.ijse.propmonitoring.secure.JWTAuthResponse;
import lk.ijse.propmonitoring.secure.SignIn;
import lk.ijse.propmonitoring.secure.SingUp;

public interface AuthService {
   JWTAuthResponse signIn(SignIn signIn);
//   JWTAuthResponse signUp(UserDto userDto);
   JWTAuthResponse signUp(StaffDto staffDto, UserDto userDto);
   JWTAuthResponse refreshToken(String accessToken);
}
