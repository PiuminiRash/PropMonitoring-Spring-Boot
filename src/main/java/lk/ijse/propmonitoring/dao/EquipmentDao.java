package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, String> {
}
