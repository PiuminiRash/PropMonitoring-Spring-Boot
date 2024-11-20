package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.StaffFieldDetailsService;
import lk.ijse.propmonitoring.dto.impl.StaffFieldDetailsDto;
import lk.ijse.propmonitoring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("StaffField/")
public class StaffFieldDetailsController {
    @Autowired
    private StaffFieldDetailsService staffFieldDetailsService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> saveStaffFieldDetails(
            @RequestPart("staffEquipmentId") String staffFieldId,
            @RequestPart ("StaffId") String staffId,
            @RequestPart ("FieldId") String fieldId
    )

    {
        try {
            //StaffFieldId generate
            String staffFieldCode = AppUtil.generateStaffFieldCode();

            //Build the Object
            StaffFieldDetailsDto buildStaffFieldDetailsDto = new StaffFieldDetailsDto();
            buildStaffFieldDetailsDto.setStaffFieldId(staffFieldId);
            buildStaffFieldDetailsDto.setFieldCode(fieldId);
            buildStaffFieldDetailsDto.setStaffId(staffId);
            staffFieldDetailsService.saveStaffFieldDetails(buildStaffFieldDetailsDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffFieldDetailsDto> getAllStaffEquipmentDetails(){
        return staffFieldDetailsService.getAllStaffFieldDetails();
    }
}
