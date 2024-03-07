package com.practica1.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/params")
public class ParamsController {
   // http://localhost:8080/params/string?texto=prueba

   @GetMapping("/")
   public String index(@RequestParam(name = "title", required = false, defaultValue = "Index Ver") String param, Model model) {
       model.addAttribute("titulo", param );
       return "params/index";
   }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required = false, defaultValue = " Sin parametro!! ") String param,Model model) {
        model.addAttribute("Resultado", "El texto enviado "+param );
        return "params/ver";
    
    }

    @GetMapping("/mix")
    public String param(@RequestParam String texto, @RequestParam Integer texto2, Model model) {

        model.addAttribute("Resultado", "El texto enviado "+texto + " y el numero es "+texto2);
        
        return "params/ver";
    }


    
    
}