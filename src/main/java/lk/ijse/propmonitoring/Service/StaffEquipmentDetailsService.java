package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.impl.StaffEquipmentDto;

import java.util.List;

public interface StaffEquipmentDetailsService {
    void saveStaffEquipmentDetails(StaffEquipmentDto staffEquipmentDto);
    List<StaffEquipmentDto> getAllStaffEquipmentDetails();
}
