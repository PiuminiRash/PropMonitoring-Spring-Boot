package lk.ijse.propmonitoring.Service.Impl;

import lk.ijse.propmonitoring.Service.FieldService;
import lk.ijse.propmonitoring.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoring.dao.FieldDao;
import lk.ijse.propmonitoring.dto.FieldStatus;
import lk.ijse.propmonitoring.dto.impl.FieldDto;
import lk.ijse.propmonitoring.entity.impl.Field;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveField(FieldDto fieldDto) {
        Field savedField = fieldDao.save(mapping.toFieldEntity(fieldDto));
        if (savedField == null) {
            throw new RuntimeException("Save field failed");
        }
    }

    @Override
    public List<FieldDto> getAllFields() {
        List<Field> allField = fieldDao.findAll();
        return mapping.fieldDtoList(allField);
    }

    @Override
    public FieldStatus getSelectedField(String fieldCode) {
        if (fieldDao.existsById(fieldCode)) {
            Field selectedField = fieldDao.getReferenceById(fieldCode);
            return mapping.toFieldDto(selectedField);
        }else {
            return new SelectedErrorStatus(2,"Field with code "+ fieldCode +" not found");
        }
    }

    @Override
    public void updateField(String fieldCode, FieldDto fieldDto) {
        Optional<Field> tempField = fieldDao.findById(fieldCode);
        if (tempField.isPresent()) {
            Field field = tempField.get();
            field.setFieldName(fieldDto.getFieldName());
            field.setFieldLocation(String.valueOf(fieldDto.getFieldLocation()));
            field.setExtendSizeOfTheField(fieldDto.getExtendSizeOfTheField());
            field.setFieldImage1(fieldDto.getFieldImage1());
            field.setFieldImage2(fieldDto.getFieldImage2());
        }
    }

    @Override
    public void deleteField(String fieldCode) {
        Optional<Field> existField = fieldDao.findById(fieldCode);
        if (existField.isPresent()) {
            throw new RuntimeException("Delete field failed");
        }else {
            fieldDao.deleteById(fieldCode);
        }
    }
}
