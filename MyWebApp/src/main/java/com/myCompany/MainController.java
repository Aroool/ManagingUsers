package com.myCompany;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomepage(){
        System.out.println("Main Controller");
        return "index";    }


}
