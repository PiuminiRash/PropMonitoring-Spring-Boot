package lk.ijse.propmonitoring.util;

import lk.ijse.propmonitoring.dto.impl.*;
import lk.ijse.propmonitoring.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    // user
    public User toUserEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
    public UserDto toUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
    public List<UserDto> asUserDtoList(List<User> userList) {
        return modelMapper.map(userList, new TypeToken<List<UserDto>>() {}.getType());
    }

    // crop
    public Crop toCropEntity(CropDto cropDto) {
        return modelMapper.map(cropDto, Crop.class);
    }
    public CropDto toCropDto(Crop crop) {
        return modelMapper.map(crop, CropDto.class);
    }
    public List<CropDto> cropDtoList(List<Crop> cropList) {
        return modelMapper.map(cropList, new TypeToken<List<CropDto>>() {}.getType());
    }

    // field
    public Field toFieldEntity(FieldDto fieldDtoDto) {
        return modelMapper.map(fieldDtoDto, Field.class);
    }
    public FieldDto toFieldDto(Field field) {
        return modelMapper.map(field, FieldDto.class);
    }
    public List<FieldDto> fieldDtoList(List<Field> fieldList) {
        return modelMapper.map(fieldList, new TypeToken<List<FieldDto>>() {}.getType());
    }

    // vehicle
    public Vehicle toVehicleEntity(VehicleDto vehicleDto) {
        return modelMapper.map(vehicleDto, Vehicle.class);
    }
    public VehicleDto toVehicleDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDto.class);
    }
    public List<VehicleDto> vehicleDtoList(List<Vehicle> vehicleList) {
        return modelMapper.map(vehicleList, new TypeToken<List<VehicleDto>>() {}.getType());
    }

    // equipment
    public Equipment toEquipmentEntity(EquipmentDto equipmentDto) {
        return modelMapper.map(equipmentDto, Equipment.class);
    }
    public EquipmentDto toEquipmentDto(Equipment equipment) {
        return modelMapper.map(equipment, EquipmentDto.class);
    }
    public List<EquipmentDto> toEquipmentDtoList(List<Equipment> equipmentList) {
        return modelMapper.map(equipmentList, new TypeToken<List<EquipmentDto>>() {}.getType());
    }
    // staff
    public Staff toStaffEntity(StaffDto staffDto) {
        return modelMapper.map(staffDto, Staff.class);
    }
    public StaffDto toStaffDto(Staff staff) {
        return modelMapper.map(staff, StaffDto.class);
    }
    public List<StaffDto> toStaffDtoList(List<Staff> staffList) {
        return modelMapper.map(staffList, new TypeToken<List<StaffDto>>() {}.getType());
    }

    // monitoring
    public MonitoringLog toMonitorEntity(MonitoringLogDto monitoringLogDto) {
        return modelMapper.map(monitoringLogDto, MonitoringLog.class);
    }
    public MonitoringLogDto toMonitorDto(MonitoringLog monitoringLog) {
        return modelMapper.map(monitoringLog, MonitoringLogDto.class);
    }
    public List<MonitoringLogDto> toMonitorDtoList(List<MonitoringLog> monitoringLogs) {
        return modelMapper.map(monitoringLogs, new TypeToken<List<MonitoringLogDto>>() {}.getType());
    }

    // fieldEquipmentDetails
    public FieldEquipmentDetails toFieldEquipmentDetailsEntity(FieldEquipmentDetailsDto fieldEquipmentDetailsDto) {
        return modelMapper.map(fieldEquipmentDetailsDto, FieldEquipmentDetails.class);
    }
    public FieldEquipmentDetailsDto toFieldEquipmentDetailsDto(FieldEquipmentDetails fieldEquipmentDetails) {
        return modelMapper.map(fieldEquipmentDetails, FieldEquipmentDetailsDto.class);
    }
    public List<FieldEquipmentDetailsDto> FieldEquipmentDetailsList(List<FieldEquipmentDetails> fieldEquipmentDetailsList) {
        return modelMapper.map(fieldEquipmentDetailsList, new TypeToken<List<FieldEquipmentDetailsDto>>() {}.getType());
    }

    // staffEquipmentDetails
    public StaffEquipmentDetails toStaffEquipmentDetailsEntity(StaffEquipmentDto staffEquipmentDto) {
        return modelMapper.map(staffEquipmentDto, StaffEquipmentDetails.class);
    }
    public StaffEquipmentDto toStaffEquipmentDetailsDto(StaffEquipmentDetails staffEquipmentDetails) {
        return modelMapper.map(staffEquipmentDetails, StaffEquipmentDto.class);
    }
    public List<StaffEquipmentDto> StaffEquipmentDetailsList(List<StaffEquipmentDetails> staffEquipmentDetailsList) {
        return modelMapper.map(staffEquipmentDetailsList, new TypeToken<List<StaffEquipmentDto>>() {}.getType());
    }

    // staffFieldDetails
    public StaffFieldDetails toStaffFieldDetailsEntity(StaffFieldDetailsDto staffFieldDetailsDto) {
        return modelMapper.map(staffFieldDetailsDto, StaffFieldDetails.class);
    }
    public StaffFieldDetailsDto toStaffFieldDetailsDto(StaffFieldDetails staffFieldDetails) {
        return modelMapper.map(staffFieldDetails, StaffFieldDetailsDto.class);
    }
    public List<StaffFieldDetailsDto> StaffFieldDetailsList(List<StaffFieldDetails> staffFieldDetailsList) {
        return modelMapper.map(staffFieldDetailsList, new TypeToken<List<StaffEquipmentDto>>() {}.getType());
    }
}

