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
@Table(name="StaffEquipmentDetails")
public class StaffEquipmentDetails implements SuperEntity {
    @Id
    private String eqDetailsId;

    @ManyToOne
    @JoinColumn(name = "StaffId",nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "equipmentId",nullable = false)
    private Equipment equipment;
}
