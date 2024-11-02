package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle implements SuperEntity {
    @Id
    private String vehicleCode;
    private String licensePlateNo;
    private String vehicleCategory;
    private String fuelType;
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "vehicle_Code",nullable = false)
//    private Staff staff;

    private String remarks;

    @OneToMany(mappedBy = "vehicle")
    private List<UserVehicleDetails> vehicle_code;
}
