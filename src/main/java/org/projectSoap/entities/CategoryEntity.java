package org.projectSoap.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "categoryTitle")
    private String categoryTitle;

    @OneToMany(mappedBy = "categories")
    private List<ProductEntity> products;
}
