package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.MonitoringLogStatus;
import lk.ijse.propmonitoring.dto.impl.MonitoringLogDto;

import java.util.List;

public interface MonitroingLogService {
    void saveMonitor(MonitoringLogDto monitoringLogDto);
    List<MonitoringLogDto> getAllMonitor();
    MonitoringLogStatus getSelectedMonitor(String logCode);
    void updateMonitor(String logCode,MonitoringLogDto monitoringLogDto);
    void deleteMonitor(String logCode);
}
