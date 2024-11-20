package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Service.StaffService;
import lk.ijse.propmonitoring.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoring.dao.StaffDao;
import lk.ijse.propmonitoring.dto.StaffStatus;
import lk.ijse.propmonitoring.dto.impl.StaffDto;
import lk.ijse.propmonitoring.entity.Gender;
import lk.ijse.propmonitoring.entity.Role;
import lk.ijse.propmonitoring.entity.impl.Staff;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveStaff(StaffDto staffDto) {
        Staff savedStaff = staffDao.save(mapping.toStaffEntity(staffDto));
        if (savedStaff == null) {
            throw new RuntimeException("Failed to save staff");
        }
    }

    @Override
    public void updateStaff(String staffId, StaffDto staffDto) {
        Optional<Staff> tempStaff = staffDao.findById(staffId);
        if (tempStaff.isPresent()) {
            Staff staff = tempStaff.get();
            staff.setFirstName(staffDto.getFirstName());
            staff.setLastName(staffDto.getLastName());
            staff.setDesignation(staffDto.getDesignation());
            staff.setGender(Gender.valueOf(String.valueOf(staffDto.getGender())));
            staff.setJoinedDate(staffDto.getJoinedDate());
            staff.setDob(staffDto.getDob());
            staff.setAddressLine1(staffDto.getAddressLine1());
            staff.setAddressLine2(staffDto.getAddressLine2());
            staff.setAddressLine3(staffDto.getAddressLine3());
            staff.setAddressLine4(staffDto.getAddressLine4());
            staff.setAddressLine5(staffDto.getAddressLine5());
            staff.setContactNo(staffDto.getContactNo());
            staff.setEmail(staffDto.getEmail());
            staff.setRole(Role.valueOf(String.valueOf(staffDto.getRole())));
        }
    }

    @Override
    public void deleteStaff(String staffId) {
        Optional<Staff> existStaff = staffDao.findById(staffId);
        if (existStaff.isPresent()) {
            throw new RuntimeException("Failed to delete staff");
        } else {
            staffDao.deleteById(staffId);
        }
    }

    @Override
    public StaffStatus getSelectedStaff(String staffId) {
        if (staffDao.existsById(staffId)) {
            Staff staff = staffDao.getReferenceById(staffId);
            return mapping.toStaffDto(staff);
        } else {
            return new SelectedErrorStatus(2, "Staff with code " + staffId + " not found");
        }
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> allStaff = staffDao.findAll();
        return mapping.toStaffDtoList(allStaff);
    }
}

