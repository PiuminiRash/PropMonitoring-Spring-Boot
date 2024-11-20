package lk.ijse.propmonitoring.Controller;

import lk.ijse.propmonitoring.Exception.CropNotFoundException;
import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.CropService;
import lk.ijse.propmonitoring.dto.CropStatus;
import lk.ijse.propmonitoring.dto.impl.CropDto;
import lk.ijse.propmonitoring.dto.impl.FieldDto;
import lk.ijse.propmonitoring.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {
    @Autowired
    private CropService cropService;
    private final Logger logger = LoggerFactory.getLogger(CropController.class);

    @GetMapping
    public String CropController() {
        return "OK";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("cropCode") String cropCode,
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season,
            @RequestPart("field") List<FieldDto> field
    ) {
        System.out.println("Awa");
        System.out.println("cropImage" + cropImage);
        String bs64 = "";
        try {
            byte[] byteCrop = cropImage.getBytes();
            bs64 = AppUtil.generateProfilePicToBase64(byteCrop);

            //String generatedCode = cropService.generateCropCode();

            var buildCrop = new CropDto();
            buildCrop.setCropCode(cropCode);
            buildCrop.setCropName(cropName);
            buildCrop.setScientificName(scientificName);
            buildCrop.setCropImage(bs64);
            buildCrop.setCategory(category);
            buildCrop.setSeason(season);
            buildCrop.setField(field);

            cropService.saveCrop(buildCrop);
            logger.info("Crop Saved");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{cropCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CropStatus getSelectedCrop(@PathVariable("cropCode") String cropCode) {
        return cropService.getSelectedCrop(cropCode);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{crop-code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCrop(@PathVariable("crop-code") String cropCode) {
        try {
            cropService.deleteCrop(cropCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDto> getAllCrops() {
        return cropService.getAllCrops();
    }

    @PutMapping(value = "{crop_code}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateCrop(CropDto cropDto,
                           @RequestPart("cropCode") String cropCode,
                           @RequestPart("cropName") String cropName,
                           @RequestPart("scientificName") String scientificName,
                           @RequestPart("cropImage") MultipartFile cropImage,
                           @RequestPart("category") String category,
                           @RequestPart("season") String season,
                           @RequestPart("field") List<FieldDto> field
    ) {
        System.out.println("cropImage" + cropImage);
        String bs64 = "";
        try {
            byte[] byteCrop = cropImage.getBytes();
            bs64 = AppUtil.generateProfilePicToBase64(byteCrop);

        } catch (IOException e) {
            e.printStackTrace();
        }

        var buildCrop = new CropDto();
        //buildCrop.setCropCode(cropCode);
        buildCrop.setCropName(cropName);
        buildCrop.setScientificName(scientificName);
        buildCrop.setCropImage(bs64);
        buildCrop.setCategory(category);
        buildCrop.setSeason(season);
        buildCrop.setField(field);

        cropService.updateCrop(cropCode, buildCrop);
    }
}
