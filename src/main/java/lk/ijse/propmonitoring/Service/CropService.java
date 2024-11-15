package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.CropStatus;
import lk.ijse.propmonitoring.dto.impl.CropDto;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    CropStatus getSelectedCrop(String cropCode);
    List<CropDto> getAllCrops();
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode,CropDto cropDto);
    String generateCropCode();
}
