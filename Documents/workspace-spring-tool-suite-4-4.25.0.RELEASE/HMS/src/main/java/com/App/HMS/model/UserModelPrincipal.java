package com.App.HMS.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class UserModelPrincipal implements UserDetails {

    private UserModel userModel;

    public UserModelPrincipal(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // "ROLE_" for Spring Security to recognize them
        return List.of(() -> "ROLE_" + userModel.getRole());
    }

    @Override
    public String getPassword() {
        return userModel.getPass();  
    }

    @Override
    public String getUsername() {
        return userModel.getEmail();
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

    // Getter for Full Name
    public String getFullname() {
        return userModel.getFirstname() ;  
    }
}
