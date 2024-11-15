package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Exception.CropNotFoundException;
import lk.ijse.propmonitoring.Service.CropService;
import lk.ijse.propmonitoring.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoring.dao.CropDao;
import lk.ijse.propmonitoring.dto.CropStatus;
import lk.ijse.propmonitoring.dto.impl.CropDto;
import lk.ijse.propmonitoring.dto.impl.FieldDto;
import lk.ijse.propmonitoring.entity.impl.Crop;
import lk.ijse.propmonitoring.entity.impl.Field;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Autowired
    private CropDao cropDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCrop(CropDto cropDto) {
        Crop savedCrop = cropDao.save(mapping.toCropEntity(cropDto));
        if (savedCrop == null){
            throw new RuntimeException("Save crop failed");
        }
    }

    @Override
    public CropStatus getSelectedCrop(String cropCode) {
        if (cropDao.existsById(cropCode)){
            Crop selectedCrop = cropDao.getReferenceById(cropCode);
            return mapping.toCropDto(selectedCrop);
        }else {
            return new SelectedErrorStatus(2,"Crop with code " + cropCode + " not found");
        }
    }

    @Override
    public List<CropDto> getAllCrops() {
        List<Crop> allCrops = cropDao.findAll();
        return mapping.cropDtoList(allCrops);
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<Crop> existCrop = cropDao.findById(cropCode);
        if (existCrop.isPresent()){
            throw new CropNotFoundException("Crop with code " + cropCode + " not found");
        }else {
            cropDao.deleteById(cropCode);
        }
    }

    @Override
    public void updateCrop(String cropCode, CropDto cropDto) {
        Optional<Crop> tempCrop = cropDao.findById(cropCode);
        if (tempCrop.isPresent()){
            //tempCrop.get().setCropCode(cropDto.getCropCode());
            tempCrop.get().setCropName(cropDto.getCropName());
            tempCrop.get().setScientificName(cropDto.getScientificName());
            tempCrop.get().setCropImage(tempCrop.get().getCropImage());
            tempCrop.get().setSeason(cropDto.getSeason());

            Field field = mapping.toFieldEntity((FieldDto) cropDto.getField());
            tempCrop.get().setField(field);
        }
    }

    @Override
    public String generateCropCode() {
        String lastCode = cropDao.findLastCropCode();
        if (lastCode == null){
            return "Crop-001";
        }
        String[] parts = lastCode.split("-");
        int lastNumber = Integer.parseInt(parts[1]);
        int newNumber = lastNumber + 1;

        return String.format("Crop-%03d", newNumber);
    }
}

