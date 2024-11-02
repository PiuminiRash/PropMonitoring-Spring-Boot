/* Created By Sithira Roneth
 * Date :10/29/24
 * Time :10:31
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.propmonitoring.entity.Role;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements SuperEntity {
    @Id
    private String userName;
    private String password;
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserFieldDetails> user_name;

    @OneToMany(mappedBy = "user")
    private List<UserFieldDetails> user_Name;

    @OneToMany(mappedBy = "user")
    private List<UserFieldDetails> username;
}
