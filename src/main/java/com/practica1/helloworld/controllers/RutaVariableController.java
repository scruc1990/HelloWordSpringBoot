package com.practica1.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("variable")
public class RutaVariableController {

    // http://localhost:5030/variable/string/pruebasssss
    @GetMapping("string/{texto}")
    public String var(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Ruta Variable para almacenar (@PathVariable)" );
        model.addAttribute("resultado", "El texto enviado "+texto );
        return "rutaVariable/ver";
    }


    @GetMapping("string/{texto}/{edad}")
    public String var(@PathVariable String texto, @PathVariable Integer edad, Model model) {
        model.addAttribute("titulo", "Ruta Variable para almacenar (@PathVariable)" );
        model.addAttribute("edad", "La edad es "+edad );
        model.addAttribute("resultado", "El texto enviado "+texto );
        return "rutaVariable/ver";
    }

    @GetMapping("/{titulo}")
   public String index(@PathVariable String titulo, Model model) {
       model.addAttribute("titulo", titulo );
       return "rutaVariable/index";
   }

}
