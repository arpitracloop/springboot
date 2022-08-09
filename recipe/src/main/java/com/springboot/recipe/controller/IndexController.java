package com.springboot.recipe.controller;

import com.springboot.recipe.domain.Category;
import com.springboot.recipe.domain.UnitOfMeasure;
import com.springboot.recipe.repositories.CategoryRepository;
import com.springboot.recipe.repositories.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;


    @RequestMapping({"","/","/index"})
    public String getIndexPage()
    {
        Optional<Category> categoryOptional =categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Category Id is : "+categoryOptional.get().getId());
        System.out.println("UnitOfMeasure Id is : "+unitOfMeasureOptional.get().getId());
        return "index";
    }
}
