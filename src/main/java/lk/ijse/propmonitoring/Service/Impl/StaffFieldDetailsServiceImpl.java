package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Exception.DataPersistException;
import lk.ijse.propmonitoring.Service.StaffFieldDetailsService;
import lk.ijse.propmonitoring.dao.StaffFieldDetailsDao;
import lk.ijse.propmonitoring.dto.impl.StaffFieldDetailsDto;
import lk.ijse.propmonitoring.entity.impl.StaffFieldDetails;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffFieldDetailsServiceImpl implements StaffFieldDetailsService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private StaffFieldDetailsDao staffFieldDetailsDao;

    @Override
    public void saveStaffFieldDetails(StaffFieldDetailsDto staffFieldDetailsDto) {
        StaffFieldDetails savedStaffFieldDetails =
                staffFieldDetailsDao.save((mapping.toStaffFieldDetailsEntity(staffFieldDetailsDto)));
        if (savedStaffFieldDetails == null) {
            throw new DataPersistException("Orders Not Saved...!!! ");
        }
    }

    @Override
    public List<StaffFieldDetailsDto> getAllStaffFieldDetails() {
        List<StaffFieldDetails> allStaffFieldDetails = staffFieldDetailsDao.findAll();
        return mapping.StaffFieldDetailsList(allStaffFieldDetails);
    }
}
