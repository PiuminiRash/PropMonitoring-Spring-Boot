package lk.ijse.propmonitoring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoring.entity.Role;
import lk.ijse.propmonitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements SuperEntity , UserDetails {
    @Id
    private String userName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany(mappedBy = "user")
//    private List<UserFieldDetails> user_name;
//
//    @OneToMany(mappedBy = "user")
//    private List<UserFieldDetails> user_Name;
//
//    @OneToMany(mappedBy = "user")
//    private List<UserFieldDetails> username;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
