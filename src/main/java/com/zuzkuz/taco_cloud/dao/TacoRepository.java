package com.zuzkuz.taco_cloud.dao;

import com.zuzkuz.taco_cloud.entity.Ingredient;
import com.zuzkuz.taco_cloud.entity.Taco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {

        Taco save(Taco design);


}
