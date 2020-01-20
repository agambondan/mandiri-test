package com.enigma.entity;

import com.enigma.constant.GeneratorConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mst_user")
public class User {

    @Id
    @GeneratedValue(generator = GeneratorConstant.GENERATOR_NAME_UUID)
    @GenericGenerator(name = GeneratorConstant.GENERATOR_NAME_UUID, strategy = GeneratorConstant.UUID)
    public String idUser;
    public String fullName;
    @Column(unique = true)
    public String username;
    public String password;
    public String email;
    public String phoneNumber;
    public String role;

    @OneToMany(mappedBy = "idUser", cascade = CascadeType.PERSIST)
    public List<Article> articleList = new ArrayList<>();

}
