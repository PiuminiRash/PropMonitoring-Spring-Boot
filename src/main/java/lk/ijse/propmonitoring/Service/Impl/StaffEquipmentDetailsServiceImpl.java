package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.StaffEquipmentDetailsService;
import lk.ijse.propmonitoring.dao.FieldEquipmentDetailsDao;
import lk.ijse.propmonitoring.dao.StaffEquipmentDetailsDao;
import lk.ijse.propmonitoring.dto.impl.FieldEquipmentDetailsDto;
import lk.ijse.propmonitoring.dto.impl.StaffEquipmentDto;
import lk.ijse.propmonitoring.entity.impl.FieldEquipmentDetails;
import lk.ijse.propmonitoring.entity.impl.StaffEquipmentDetails;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffEquipmentDetailsServiceImpl implements StaffEquipmentDetailsService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private StaffEquipmentDetailsDao staffEquipmentDetailsDao;

    @Override
    public void saveStaffEquipmentDetails(StaffEquipmentDto staffEquipmentDto) {
        StaffEquipmentDetails savedFieldEquipmentDetails =
                staffEquipmentDetailsDao.save((mapping.toStaffEquipmentDetailsEntity(staffEquipmentDto)));
        if (savedFieldEquipmentDetails == null) {
            throw new DataPersistException("Orders Not Saved...!!! ");
        }
    }

    @Override
    public List<StaffEquipmentDto> getAllStaffEquipmentDetails() {
        List<StaffEquipmentDetails> allStaffEquipmentDetails = staffEquipmentDetailsDao.findAll();
        return mapping.StaffEquipmentDetailsList(allStaffEquipmentDetails);
    }
}
