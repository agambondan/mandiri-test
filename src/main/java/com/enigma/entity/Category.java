package com.enigma.entity;

import com.enigma.constant.GeneratorConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mst_categories")
public class Category {

    @Id
    @GeneratedValue(generator = GeneratorConstant.GENERATOR_NAME_UUID)
    @GenericGenerator(name = GeneratorConstant.GENERATOR_NAME_UUID, strategy = GeneratorConstant.UUID)
    public String idCategory;
    @Column(unique = true)
    public String categoryName;

    @ManyToMany()
    @JoinTable(name = "category_article", joinColumns = @JoinColumn(name = "id_article"), inverseJoinColumns = @JoinColumn(name = "id_category"))
    private List<Article> articles;

}
