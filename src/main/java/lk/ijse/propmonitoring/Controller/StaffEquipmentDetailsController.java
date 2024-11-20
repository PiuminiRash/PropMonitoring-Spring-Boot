package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.StaffEquipmentDetailsService;
import lk.ijse.propmonitoring.dto.impl.StaffEquipmentDto;
import lk.ijse.propmonitoring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("StaffEq/")
public class StaffEquipmentDetailsController {
    @Autowired
    private StaffEquipmentDetailsService staffEquipmentDetailsService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> saveStaffEquipmentDetails(
            @RequestPart("staffEquipmentId") String staffEqId,
            @RequestPart ("StaffId") String StaffId,
            @RequestPart ("EquipmentId") String EquipmentId
    )

    {
        try {
            //OrderId generate
            String staffEquipmentCode = AppUtil.generateStaffEquipmentCode();

            //Build the Object
            StaffEquipmentDto buildStaffEquipmentDetailsDto = new StaffEquipmentDto();
            buildStaffEquipmentDetailsDto.setStaffEqId(staffEqId);
            buildStaffEquipmentDetailsDto.setStaffEqId(StaffId);
            buildStaffEquipmentDetailsDto.setEqCode(EquipmentId);
            staffEquipmentDetailsService.saveStaffEquipmentDetails(buildStaffEquipmentDetailsDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffEquipmentDto> getAllStaffEquipmentDetails(){
        return staffEquipmentDetailsService.getAllStaffEquipmentDetails();
    }
}
