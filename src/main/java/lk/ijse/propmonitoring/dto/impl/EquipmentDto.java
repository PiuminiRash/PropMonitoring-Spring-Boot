package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.EquipmentStatus;
import lk.ijse.propmonitoring.entity.Status;
import lk.ijse.propmonitoring.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements EquipmentStatus {
    private String equipmentId;
    private String equipmentName;
    private Type equipmentType;
    private Status status;
    private List<StaffDto> staff;
    private List<FieldDto> field;

}
