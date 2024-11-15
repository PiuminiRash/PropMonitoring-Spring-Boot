package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.EquipmentStatus;
import lk.ijse.propmonitoring.dto.impl.EquipmentDto;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDto equipmentDto);
    EquipmentStatus getSelectedEquipment(String equipmentId);
    List<EquipmentDto> getAllEquipment();
    void updateEquipment(String equipmentId, EquipmentDto equipmentDto);
    void deleteEquipment(String equipmentId);
}
