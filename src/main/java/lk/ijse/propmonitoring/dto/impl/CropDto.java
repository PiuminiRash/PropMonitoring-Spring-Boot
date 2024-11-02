/* Created By Sithira Roneth
* Date :10/29/24
* Time :10:28
* Project Name :Prop-Monitoring-System 
* */
package lk.ijse.propmonitoring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropDto {
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String cropImage;
    private String category;
    private String season;
    private FieldDto field;
}
