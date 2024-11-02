package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="userFieldDetails")
public class UserFieldDetails implements SuperEntity {
    @Id
    private String userFieldId;

    @ManyToOne
    @JoinColumn(name = "user_name", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "field_code", nullable = false)
    private Field field;
}
