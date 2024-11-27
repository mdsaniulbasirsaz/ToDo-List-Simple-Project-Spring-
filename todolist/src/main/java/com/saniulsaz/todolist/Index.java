package com.saniulsaz.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @RequestMapping("/index")
    public String Hello(Model model) {
       
        model.addAttribute("name", "To Do List");
        return "index";
    }
}
