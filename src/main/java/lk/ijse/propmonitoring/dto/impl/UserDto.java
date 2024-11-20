package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.UserStatus;
import lk.ijse.propmonitoring.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserStatus {
    private String email;
    private String userName;
    private String password;
    private Role role;
}
