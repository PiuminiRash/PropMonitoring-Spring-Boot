package lk.ijse.propmonitoring.dto.impl;

import lk.ijse.propmonitoring.dto.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropDto implements CropStatus {
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String cropImage;
    private String category;
    private String season;
    private List<FieldDto> field;
}
