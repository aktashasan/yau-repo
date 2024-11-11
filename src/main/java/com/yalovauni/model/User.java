package com.yalovauni.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; //username: hasan_77
    private String password; //password: 123456

}
