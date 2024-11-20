package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.FieldEquipmentDetailsService;
import lk.ijse.propmonitoring.dao.FieldEquipmentDetailsDao;
import lk.ijse.propmonitoring.dto.impl.FieldEquipmentDetailsDto;
import lk.ijse.propmonitoring.entity.impl.FieldEquipmentDetails;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FeildEquipmentDetailsServiceImpl implements FieldEquipmentDetailsService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private FieldEquipmentDetailsDao fieldEquipmentDetailsDao;

    @Override
    public void saveFieldEquipmentDetails(FieldEquipmentDetailsDto fieldEquipmentDetailsDto) {
        FieldEquipmentDetails savedFieldEquipmentDetails =
                fieldEquipmentDetailsDao.save((mapping.toFieldEquipmentDetailsEntity(fieldEquipmentDetailsDto)));
        if (savedFieldEquipmentDetails == null) {
            throw new DataPersistException("Orders Not Saved...!!! ");
        }
    }

    @Override
    public List<FieldEquipmentDetailsDto> getAllFieldEquipmentDetails() {
        List<FieldEquipmentDetails> allFieldEquipmentDetails = fieldEquipmentDetailsDao.findAll();
        return mapping.FieldEquipmentDetailsList(allFieldEquipmentDetails);
    }
}
