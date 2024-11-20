package lk.ijse.propmonitoring.dao;

import lk.ijse.propmonitoring.entity.impl.StaffEquipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffEquipmentDetailsDao extends JpaRepository<StaffEquipmentDetails,String> {
//    @Query("SELECT c.cropCode FROM Crop c ORDER BY c.cropCode DESC")
//    String findLastCropCode();
}
