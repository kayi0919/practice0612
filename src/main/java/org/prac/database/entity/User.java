package org.prac.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users" )
//@Table(name = "member", schema = "public", catalog = "tku2023")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="realname")
    private String realname;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="enabled")
    private String enabled;

    @Transient
    private String action;
}