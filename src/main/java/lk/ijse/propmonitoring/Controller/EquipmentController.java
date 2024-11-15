/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:27
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Exception.EquipmentNotFoundException;
import lk.ijse.propmonitoring.Service.EquipmentService;
import lk.ijse.propmonitoring.dto.EquipmentStatus;
import lk.ijse.propmonitoring.dto.impl.EquipmentDto;
import lk.ijse.propmonitoring.dto.impl.FieldDto;
import lk.ijse.propmonitoring.dto.impl.StaffDto;
import lk.ijse.propmonitoring.entity.Status;
import lk.ijse.propmonitoring.entity.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart("equipmentId") String equipmentId,
            @RequestPart("equipmentName") String equipmentName,
            @RequestPart("equipmentType") String equipmentType,
            @RequestPart("status") String status,
            @RequestPart("staff") List<StaffDto>staff,
            @RequestPart("field") List<FieldDto>field

    ) {
        try {
            var buildEquip = new EquipmentDto();
            buildEquip.setEquipmentId(equipmentId);
            buildEquip.setEquipmentName(equipmentName);
            buildEquip.setEquipmentType(Type.valueOf(equipmentType));
            buildEquip.setStatus(Status.valueOf(status));
            buildEquip.setStaff(staff);
            buildEquip.setField(field);

            equipmentService.saveEquipment(buildEquip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentStatus getSelectedEquip(@PathVariable("equipmentId") String equipmentId) {
        return equipmentService.getSelectedEquipment(equipmentId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDto> getAllEquipments() {
        return equipmentService.getAllEquipment();
    }
    @PutMapping(value = "{equipmentId}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEquipment(EquipmentDto equipmentDto,
                                @RequestPart("equipmentId") String equipmentId,
                                @RequestPart("equipmentName") String equipmentName,
                                @RequestPart("equipmentType") String equipmentType,
                                @RequestPart("status") String status,
                                @RequestPart("staff") List<StaffDto> staff,
                                @RequestPart("field") List<FieldDto>field
    ){
        try {
            var UpdateEquip = new EquipmentDto();
            UpdateEquip.setEquipmentId(equipmentId);
            UpdateEquip.setEquipmentName(equipmentName);
            UpdateEquip.setEquipmentType(Type.valueOf(equipmentType));
            UpdateEquip.setStatus(Status.valueOf(status));
            UpdateEquip.setStaff(staff);
            UpdateEquip.setField(field);
            equipmentService.updateEquipment(equipmentId,UpdateEquip);
        }catch (Exception e){
            throw new RuntimeException("Equipment didn't updated");
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{equipmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEquipment(@PathVariable("equipmentId") String equipmentId) {
        try {
            equipmentService.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EquipmentNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
