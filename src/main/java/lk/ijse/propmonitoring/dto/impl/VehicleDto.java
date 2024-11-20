package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto implements VehicleStatus {
    private String vehicleCode;
    private String licensePlateNo;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private StaffDto staffMemberDetails;
    private String remarks;
}
