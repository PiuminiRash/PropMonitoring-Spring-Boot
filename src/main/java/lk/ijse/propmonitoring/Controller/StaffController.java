package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Exception.StaffNotFoundException;
import lk.ijse.propmonitoring.Service.StaffService;
import lk.ijse.propmonitoring.dto.StaffStatus;
import lk.ijse.propmonitoring.dto.impl.StaffDto;
import lk.ijse.propmonitoring.entity.Gender;
import lk.ijse.propmonitoring.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff/")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDto staffDto) {
        try {
            var buildStaff = new StaffDto();
            buildStaff.setStaffId(staffDto.getStaffId());
            buildStaff.setFirstName(staffDto.getFirstName());
            buildStaff.setLastName(staffDto.getLastName());
            buildStaff.setDesignation(staffDto.getDesignation());
            buildStaff.setGender(Gender.valueOf(String.valueOf(staffDto.getGender())));
            buildStaff.setJoinedDate(staffDto.getJoinedDate());
            buildStaff.setDob(staffDto.getDob());
            buildStaff.setAddressLine1(staffDto.getAddressLine1());
            buildStaff.setAddressLine2(staffDto.getAddressLine2());
            buildStaff.setAddressLine3(staffDto.getAddressLine3());
            buildStaff.setAddressLine4(staffDto.getAddressLine4());
            buildStaff.setAddressLine5(staffDto.getAddressLine5());
            buildStaff.setContactNo(staffDto.getContactNo());
            buildStaff.setEmail(staffDto.getEmail());
            buildStaff.setRole(Role.valueOf(String.valueOf(staffDto.getRole())));

            staffService.saveStaff(buildStaff);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffStatus getSelectedStaff(@PathVariable("staffId") String staffId) {
        return staffService.getSelectedStaff(staffId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDto> getStaffs() {
        return staffService.getAllStaff();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStaff(@PathVariable("staffId") String staffId) {
        try {
            staffService.deleteStaff(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{staffId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@PathVariable("staffId") String staffId, StaffDto staffDto) {
        try {
            var buildStaff = new StaffDto();
            buildStaff.setStaffId(staffDto.getStaffId());
            buildStaff.setFirstName(staffDto.getFirstName());
            buildStaff.setLastName(staffDto.getLastName());
            buildStaff.setDesignation(staffDto.getDesignation());
            buildStaff.setGender(Gender.valueOf(String.valueOf(staffDto.getGender())));
            buildStaff.setJoinedDate(staffDto.getJoinedDate());
            buildStaff.setDob(staffDto.getDob());
            buildStaff.setAddressLine1(staffDto.getAddressLine1());
            buildStaff.setAddressLine2(staffDto.getAddressLine2());
            buildStaff.setAddressLine3(staffDto.getAddressLine3());
            buildStaff.setAddressLine4(staffDto.getAddressLine4());
            buildStaff.setAddressLine5(staffDto.getAddressLine5());
            buildStaff.setContactNo(staffDto.getContactNo());
            buildStaff.setEmail(staffDto.getEmail());
            buildStaff.setRole(Role.valueOf(String.valueOf(staffDto.getRole())));

            staffService.updateStaff(staffId, buildStaff);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
