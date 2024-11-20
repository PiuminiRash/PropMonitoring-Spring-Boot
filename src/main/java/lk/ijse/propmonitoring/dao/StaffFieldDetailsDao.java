package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.StaffFieldDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffFieldDetailsDao extends JpaRepository<StaffFieldDetails,String> {
}
