package com.chen.security.model;

import com.chen.security.Enum.Role;
import com.sun.tools.javac.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        //TODO:get user expire info,temporary return true
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO:get account lock info,temporary return true
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //TODO: get credential expire info,temporary return true
        return true;
    }

    @Override
    public boolean isEnabled() {
        //TODO: get user enable info,temporary return true
        return true;
    }
}
