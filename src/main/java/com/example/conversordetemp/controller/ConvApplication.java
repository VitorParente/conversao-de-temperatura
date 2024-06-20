package com.example.conversordetemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvApplication {
    @GetMapping("/")
    public ModelAndView conversor(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page");
        return modelAndView;
    }
    @PostMapping("/conversor")
    public String conversor(@RequestParam("num1")double num1,
                            @RequestParam("atual")int atual,
                            @RequestParam("futura")int futura,
                            Model model){
        double result =0;
        switch (atual){
            case 1:
                if (futura == 1){
                    result=num1;
                }else if(futura == 2){
                    result=(num1*9/5)+32;
                }else{
                    result=num1+273.15;
                }
                break;
            case 2:
                if (futura==1){
                    result=(num1-32)*5/9;
                }else if(futura==2){
                    result=num1;
                }else{
                    result=(num1-32)*5/9 +273.15;
                }
                break;
            case 3:
                if (futura==1){
                    result= num1-273.15;
                } else if (futura==2) {
                    result=(num1-273.15)*5/9+32;
                }else {
                    result=num1;
                }
        }
        model.addAttribute("result",result);
        return "page";
    }
}
