package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto implements FieldStatus {
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extendSizeOfTheField;
    private List<CropDto> crops;
    private List<StaffDto> staffs;
    private String fieldImage1;
    private String fieldImage2;
}
