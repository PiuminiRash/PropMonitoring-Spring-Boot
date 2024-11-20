package lk.ijse.propmonitoring.customStatusCode;

import lk.ijse.propmonitoring.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//public class SelectedErrorStatus implements UserStatus, NoteStatus {
public class SelectedErrorStatus implements UserStatus , CropStatus, VehicleStatus, EquipmentStatus, FieldStatus, StaffStatus, MonitoringLogStatus {
    private int statusCode;
    private String status;
}