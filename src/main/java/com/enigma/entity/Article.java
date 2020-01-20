package com.enigma.entity;

import com.enigma.constant.GeneratorConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mst_article")
public class Article {

    @Id
    @GeneratedValue(generator = GeneratorConstant.GENERATOR_NAME_UUID)
    @GenericGenerator(name = GeneratorConstant.GENERATOR_NAME_UUID, strategy = GeneratorConstant.UUID)
    public String idArticle;
    public String title;
    @Column(columnDefinition = "TEXT")
    public String description;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = GeneratorConstant.DATE_PATTERN)
    public Date createdAt = new Date();
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = GeneratorConstant.DATE_PATTERN)
    public Date updateAt = new Date();

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    public User idUser;
    @Transient
    public String idUserTransient;
    @Transient
    public String idCategoryTransient;

    @ManyToMany(mappedBy = "articles")
    private List<Category> categoryList;

}
