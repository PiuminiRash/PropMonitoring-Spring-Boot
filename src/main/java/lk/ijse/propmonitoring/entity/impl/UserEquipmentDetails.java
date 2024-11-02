package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userEquipmentDetails")
public class UserEquipmentDetails implements SuperEntity {
    @Id
    private String userEqId;

    @ManyToOne
    @JoinColumn(name = "user_Name", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "equipment_code", nullable = false)
    private Equipment equipment;
}
