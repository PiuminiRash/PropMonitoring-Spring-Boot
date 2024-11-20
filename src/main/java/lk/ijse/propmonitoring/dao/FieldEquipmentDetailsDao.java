package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.FieldEquipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldEquipmentDetailsDao extends JpaRepository<FieldEquipmentDetails,String> {
//    @Query("SELECT fe.cropCode FROM FieldEquipmentDetails fe ORDER BY fe.cropCode DESC")
//    String findLastFieldEquipmentCode();
}
