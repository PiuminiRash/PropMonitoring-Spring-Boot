package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.StaffEquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffEquipmentDto implements StaffEquipmentStatus {
    private String StaffEqId;
    private String StaffId;
    private String EqCode;
}
