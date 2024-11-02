package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.entity.Status;
import lk.ijse.propmonitoring.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
    private String equipmentId;
    private String equipmentName;
    private Type equipmentType;
    private Status status;
    private StaffDto staff;
    private FieldDto field;

}
