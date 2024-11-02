package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private Role role;
}
