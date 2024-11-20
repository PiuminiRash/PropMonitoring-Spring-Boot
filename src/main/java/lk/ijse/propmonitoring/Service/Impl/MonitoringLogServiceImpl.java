package lk.ijse.propmonitoring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.propmonitoring.Service.MonitroingLogService;
import lk.ijse.propmonitoring.customStatusCode.SelectedErrorStatus;
import lk.ijse.propmonitoring.dao.MonitoringDao;
import lk.ijse.propmonitoring.dto.MonitoringLogStatus;
import lk.ijse.propmonitoring.dto.impl.MonitoringLogDto;
import lk.ijse.propmonitoring.entity.impl.MonitoringLog;
import lk.ijse.propmonitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitoringLogServiceImpl implements MonitroingLogService {
    @Autowired
    private MonitoringDao monitoringDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveMonitor(MonitoringLogDto monitoringLogDto) {
        MonitoringLog savedMonitor = monitoringDao.save(mapping.toMonitorEntity(monitoringLogDto));
        if (savedMonitor == null){
            throw new RuntimeException("Failed to save monitoring log");
        }
    }

    @Override
    public List<MonitoringLogDto> getAllMonitor() {
        List<MonitoringLog> allMonitor = monitoringDao.findAll();
        return mapping.toMonitorDtoList(allMonitor);
    }

    @Override
    public MonitoringLogStatus getSelectedMonitor(String logCode) {
        if (monitoringDao.existsById(logCode)){
            MonitoringLog referenceById = monitoringDao.getReferenceById(logCode);
            return mapping.toMonitorDto(referenceById);
        }else {
            return new SelectedErrorStatus(2,"Monitoring Log"+ logCode+ " Not Found");
        }
    }

    @Override
    public void updateMonitor(String logCode, MonitoringLogDto monitoringLogDto) {
        Optional<MonitoringLog> tempMonitor = monitoringDao.findById(logCode);
        if (tempMonitor.isPresent()){
            MonitoringLog monitoringLog = tempMonitor.get();
            monitoringLog.setDate(monitoringLogDto.getDate());
            monitoringLog.setLogDetails(monitoringLogDto.getLogDetails());
            monitoringLog.setObservedImage(monitoringLogDto.getObservedImage());
        }
    }

    @Override
    public void deleteMonitor(String logCode) {
        Optional<MonitoringLog> exist = monitoringDao.findById(logCode);
        if (exist.isPresent()){
            throw new RuntimeException("Monitoring Log Deleted Failed");
        }else {
            monitoringDao.deleteById(logCode);
        }
    }
}
