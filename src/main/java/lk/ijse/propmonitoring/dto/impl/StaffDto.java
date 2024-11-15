package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.StaffStatus;
import lk.ijse.propmonitoring.entity.Gender;
import lk.ijse.propmonitoring.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto implements StaffStatus {
    private String staffId;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private Date joinedDate;
    private Date Dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;
    private List<FieldDto> fields;
    private List<VehicleDto> vehicles;

}
