package com.springboot.recipe.controller;

import com.springboot.recipe.services.RecipeService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Data

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService)
    {
        this.recipeService=recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model)
    {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
