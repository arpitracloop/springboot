package com.springboot.recipe.bootstrap;

import com.springboot.recipe.domain.*;
import com.springboot.recipe.repositories.CategoryRepository;
import com.springboot.recipe.repositories.RecipeRepository;
import com.springboot.recipe.repositories.UnitOfMeasureRepository;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class RecipeBootstrap {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    private List<Recipe> getRecipes()
    {
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent())
        {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tableSpoonUomOptional.isPresent())
        {
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUomOptional.isPresent())
        {
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOptional.isPresent())
        {
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOptional.isPresent())
        {
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupsUomOptional.isPresent())
        {
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tablespoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        // get categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent())
        {
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent())
        {
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        // Yummy Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(10);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("...Directions to make Guac...");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("This is recipe note ");

        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("avacado", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(5),teaspoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("lime juice",new BigDecimal(2),tablespoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("onion",new BigDecimal(2),tablespoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("chiles",new BigDecimal(2),eachUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("cilantro",new BigDecimal(2),tablespoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("black pepper",new BigDecimal(2),dashUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("tomatoes",new BigDecimal(5),eachUom,guacRecipe));


        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        //add to return list
        recipes.add(guacRecipe);

        // Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Veg Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("...Directions to make Taco...");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("... Notes for the recipe...");

        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Chili Powder", new BigDecimal(2),tablespoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Oregano", new BigDecimal(1),teaspoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Cumin", new BigDecimal(1),teaspoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1),teaspoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(5),teaspoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Garlic", new BigDecimal(1),eachUom, tacosRecipe));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);
        return recipes;


    }
}
