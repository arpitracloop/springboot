package com.springboot.webapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;



    @RequestMapping("/list-todos")
    public String lisAllTodos(ModelMap model)
    {
        List<Todo> todos = todoService.findByUsername("mojojojo");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping("/add-todo")
    public String showTodoPage()
    {
        return "todo";
    }

}
