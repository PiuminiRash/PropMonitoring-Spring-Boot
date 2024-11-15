package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.MonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringDao extends JpaRepository<MonitoringLog,String> {
}
