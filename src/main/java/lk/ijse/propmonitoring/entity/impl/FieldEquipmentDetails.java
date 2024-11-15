package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FieldEquipmentDetailsController")
public class FieldEquipmentDetails implements SuperEntity {
    @Id
    private String fieldDetailsId;

    @ManyToOne
    @JoinColumn(name = "filed_code", nullable = false)
    private Field field;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;
}
