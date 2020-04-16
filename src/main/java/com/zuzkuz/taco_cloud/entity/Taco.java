package com.zuzkuz.taco_cloud.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco")
public class Taco {

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String tacoName;

    private Date createdAt;

    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

}