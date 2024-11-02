package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="monitoringLog")
public class MonitoringLog implements SuperEntity {
    @Id
    private String logCode;
    private Date date;
    private String logDetails;
    private String observedImage;

    @OneToMany(mappedBy = "monitoringLog")
    private List<UserMonitoringLogDetails> lod_code;
}
