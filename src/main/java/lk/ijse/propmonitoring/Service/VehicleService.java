package lk.ijse.propmonitoring.Service;

import lk.ijse.propmonitoring.dto.VehicleStatus;
import lk.ijse.propmonitoring.dto.impl.VehicleDto;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDto vehicleDto);
    VehicleStatus getSelectedVehicle(String vehicleCode);
    List<VehicleDto> getAllVehicles();
    void updateVehicle(String vehicleCode,VehicleDto vehicleDto);
    void deleteVehicle(String vehicleCode);
    String generatedVehicleCode();
}
