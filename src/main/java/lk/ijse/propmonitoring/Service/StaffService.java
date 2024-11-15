package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.StaffStatus;
import lk.ijse.propmonitoring.dto.impl.StaffDto;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);
    void updateStaff(String staffId,StaffDto staffDto);
    void deleteStaff(String staffId);
    StaffStatus getSelectedStaff(String staffId);
    List<StaffDto> getAllStaff();
}
