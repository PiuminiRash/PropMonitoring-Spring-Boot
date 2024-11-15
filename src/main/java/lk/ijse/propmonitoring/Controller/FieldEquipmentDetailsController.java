package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.FieldEquipmentDetailsService;
import lk.ijse.propmonitoring.dto.impl.FieldEquipmentDetailsDto;
import lk.ijse.propmonitoring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fieldEq")
public class FieldEquipmentDetailsController {
    @Autowired
    private FieldEquipmentDetailsService feildEquipmentDetailsService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> saveFieldEquipmentDetails(
            @RequestPart("fieldEquipmentId") String orderId,
            @RequestPart ("FeildId") String FieldCode,
            @RequestPart ("EquipmentId") String EquipmentId
    )

    {
        try {
            //OrderId generate
            String fieldEquipmentCode = AppUtil.generateFieldEquipmentCode();

            //Build the Object
            FieldEquipmentDetailsDto buildfieldEquipmentDetailsDto = new FieldEquipmentDetailsDto();
            buildfieldEquipmentDetailsDto.setFieldDetailsId(orderId);
            buildfieldEquipmentDetailsDto.setField(FieldCode);
            buildfieldEquipmentDetailsDto.setEquipment(EquipmentId);
            feildEquipmentDetailsService.saveFieldEquipmentDetails(buildfieldEquipmentDetailsDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldEquipmentDetailsDto> getAllOrderDetails(){
        return feildEquipmentDetailsService.getAllFieldEquipmentDetails();
    }
}
