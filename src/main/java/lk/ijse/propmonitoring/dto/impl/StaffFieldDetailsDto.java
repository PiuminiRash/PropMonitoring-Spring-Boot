package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.StaffFieldDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffFieldDetailsDto implements StaffFieldDetailsStatus {
    private String StaffFieldId;
    private String StaffId;
    private String FieldCode;
}
