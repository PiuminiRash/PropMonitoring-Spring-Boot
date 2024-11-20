package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.Role;
import lk.ijse.propmonitoring.entity.impl.Staff;
import lk.ijse.propmonitoring.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffDao extends JpaRepository<Staff, String> {
    Optional<Role> findByEmail(String email);
}
