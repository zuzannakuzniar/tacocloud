package com.zuzkuz.taco_cloud.dao;

import com.zuzkuz.taco_cloud.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    Iterable<Ingredient> findAll();
    Ingredient findIngredientById(String id);
    Ingredient save(Ingredient ingredient);

}
