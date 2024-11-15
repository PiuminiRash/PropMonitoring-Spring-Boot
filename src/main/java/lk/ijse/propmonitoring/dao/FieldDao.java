package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends JpaRepository<Field, String> {
}
