package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.FieldEquipmentDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldEquipmentDetailsDto implements FieldEquipmentDetailsStatus {
    private String fieldDetailsId;
    private String field;
    private String equipment;
}
