package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.impl.FieldEquipmentDetailsDto;

import java.util.List;

public interface FieldEquipmentDetailsService {
    void saveFieldEquipmentDetails(FieldEquipmentDetailsDto fieldEquipmentDetailsDto);
    List<FieldEquipmentDetailsDto> getAllFieldEquipmentDetails();
}
