package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Exception.FieldNotFoundException;
import lk.ijse.propmonitoring.Service.FieldService;
import lk.ijse.propmonitoring.dto.FieldStatus;
import lk.ijse.propmonitoring.dto.impl.FieldDto;
import lk.ijse.propmonitoring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("fields/")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart("fieldName") String fieldName,
            @RequestPart("fieldLocation") Point fieldLocation,
            @RequestPart("extendSizeOfTheField") Double extendSizeOfTheField,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2
    ) {
        String b1 = "";
        String b2 = "";
        try {
            byte[] image1 = fieldImage1.getBytes();
            byte[] image2 = fieldImage2.getBytes();
            b1 = AppUtil.generateProfilePicToBase64(image1);
            b2 = AppUtil.generateProfilePicToBase64(image2);

            var buildField = new FieldDto();
            buildField.setFieldCode(fieldCode);
            buildField.setFieldName(fieldName);
            buildField.setFieldLocation(fieldLocation);
            buildField.setExtendSizeOfTheField(extendSizeOfTheField);
            buildField.setFieldImage1(b1);
            buildField.setFieldImage2(b2);

            fieldService.saveField(buildField);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{fieldCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable("fieldCode") String fieldCode) {
        return fieldService.getSelectedField(fieldCode);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDto> getAllFields() {
        return fieldService.getAllFields();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{filedCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteField(@PathVariable("filedCode") String fieldCode) {
        try {
            fieldService.deleteField(fieldCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FieldNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{fieldCode}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateField(FieldDto fieldDto,
                            @RequestPart("fieldCode") String fieldCode,
                            @RequestPart("fieldName") String fieldName,
                            @RequestPart("fieldLocation") Point fieldLocation,
                            @RequestPart("extendSizeOfTheField") Double extendSizeOfTheField,
                            @RequestPart("fieldImage1") MultipartFile fieldImage1,
                            @RequestPart("fieldImage2") MultipartFile fieldImage2
    ) {
        String base1 = "";
        String base2 = "";
        try {
            byte[] byte1 = fieldImage1.getBytes();
            byte[] byte2 = fieldImage2.getBytes();
            base1 = AppUtil.generateProfilePicToBase64(byte1);
            base2 = AppUtil.generateProfilePicToBase64(byte2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        var buildField = new FieldDto();
        buildField.setFieldCode(fieldCode);
        buildField.setFieldName(fieldName);
        buildField.setFieldLocation(fieldLocation);
        buildField.setExtendSizeOfTheField(extendSizeOfTheField);
        buildField.setFieldImage1(base1);
        buildField.setFieldImage2(base2);

        fieldService.updateField(fieldCode,buildField);
    }
}
