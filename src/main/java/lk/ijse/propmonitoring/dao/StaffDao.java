package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<Staff, String> {
}
