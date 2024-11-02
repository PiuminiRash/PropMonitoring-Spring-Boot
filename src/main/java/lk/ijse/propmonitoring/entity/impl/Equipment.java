package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.propmonitoring.entity.Status;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lk.ijse.propmonitoring.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipment")
public class Equipment implements SuperEntity {
    @Id
    private String eqId;
    private String equipmentName;
    private Type equipmentType;
    private Status status;

    @OneToMany(mappedBy = "equipment")
    private List<FieldEquipmentDetails> field;

    @OneToMany(mappedBy = "equipment")
    private List<StaffEquipmentDetails> equipment_id;

    @OneToMany(mappedBy = "equipment")
    private List<UserEquipmentDetails> equipment_code;
}
