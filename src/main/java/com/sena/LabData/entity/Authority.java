package com.sena.LabData.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Authority implements GrantedAuthority {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
     @Column
     private String authority;

     @ManyToOne
     @JoinColumn(name = "user_id")
     private  UsuarioLab User;


     public Authority() {
     }

     public Authority (String authority){
          this.authority = authority;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     @Override
     public String getAuthority() {
          return authority;
     }

     public void setAuthority(String authority) {
          this.authority = authority;
     }

     public UsuarioLab getUser() {
          return User;
     }

     public void setUser(UsuarioLab user) {
          User = user;
     }
}
