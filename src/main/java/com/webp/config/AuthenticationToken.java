package com.webp.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationToken {

     private String username;
     private Collection<? extends GrantedAuthority> authorities;
     private String token;

     public AuthenticationToken(String username, Collection<? extends GrantedAuthority> collection, String token) {
          this.username = username;
          this.authorities = collection;
          this.token = token;
     }

     public String getUsername() {
          return username;
     }
     public void setUsername(String username) {
          this.username = username;
     }
     public Collection<? extends GrantedAuthority> getAuthorities() {
          return authorities;
     }
     public void setAuthorities(Collection<GrantedAuthority> authorities) {
          this.authorities = authorities;
     }
     public String getToken() {
          return token;
     }
     public void setToken(String token) {
          this.token = token;
     }
}
