package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.impl.StaffFieldDetailsDto;

import java.util.List;

public interface StaffFieldDetailsService {
    void saveStaffFieldDetails(StaffFieldDetailsDto staffFieldDetailsDto);
    List<StaffFieldDetailsDto> getAllStaffFieldDetails();
}
