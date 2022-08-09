package com.springboot.recipe.repositories;

import com.springboot.recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasureRepository, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
