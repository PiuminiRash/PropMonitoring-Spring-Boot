package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "field")
public class Field implements SuperEntity {
    @Id
    private String field_Code;
    private String fieldName;
    private String fieldLocation;
    private Double extendSizeOfTheField;

//    @OneToMany(mappedBy = "field")
//    private List<Crop> Field_Code;
//
    @OneToMany(mappedBy = "field")
    private List<StaffFieldDetails> fieldCode;

//    @OneToMany(mappedBy = "field")
//    private List<FieldEquipmentDetailsController> field_code;

    private String fieldImage1;
    private String fieldImage2;

//    @OneToMany(mappedBy = "field")
//    private List<UserFieldDetails> field_code;
}
