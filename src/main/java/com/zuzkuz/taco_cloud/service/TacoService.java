package com.zuzkuz.taco_cloud.service;

import com.zuzkuz.taco_cloud.dao.TacoRepository;
import com.zuzkuz.taco_cloud.entity.Ingredient;
import com.zuzkuz.taco_cloud.entity.Taco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;


    public class TacoService implements TacoRepository {


        private JdbcTemplate jdbc;
        public TacoService(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }
        @Override
        public Taco save(Taco taco) {
            long tacoId = saveTacoInfo(taco);
            taco.setId(tacoId);
            for (Ingredient ingredient : taco.getIngredients()) {
                saveIngredientToTaco(ingredient, tacoId);
            }
            return taco;
        }


        private long saveTacoInfo(Taco taco) {
            taco.setCreatedAt(new Date());
            PreparedStatementCreator psc =
                    new PreparedStatementCreatorFactory(
                            "insert into Taco (name, createdAt) values (?, ?)",
                            Types.VARCHAR, Types.TIMESTAMP
                    ).newPreparedStatementCreator(
                            Arrays.asList(
                                    taco.getTacoName(),
                                    new Timestamp(taco.getCreatedAt().getTime())));
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbc.update(psc, keyHolder);
            return keyHolder.getKey().longValue();
        }
        private void saveIngredientToTaco(
                Ingredient ingredient, long tacoId) {
            jdbc.update(
                    "insert into Taco_Ingredients (taco, ingredient) " +
                            "values (?, ?)",
                    tacoId, ingredient.getId());
        }

    @Override
    public <S extends Taco> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Taco> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Taco> findAll() {
        return null;
    }

    @Override
    public Iterable<Taco> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Taco taco) {

    }

    @Override
    public void deleteAll(Iterable<? extends Taco> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

