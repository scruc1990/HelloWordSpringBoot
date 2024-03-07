package com.practica1.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practica1.helloworld.models.entity.Usuario;

@Controller
@RequestMapping("/app")
public class indexController {

    @GetMapping({ "/", "/index", "/home" })
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Boot");
        return "index";
    }

    @GetMapping({ "/perfil" })
    public String perfil(Model model) {

        Usuario usuario = new Usuario("Enmanuel", "Tavera", "emmanuel302001@gmail.com");

        model.addAttribute("titulo", "perfil");
        model.addAttribute("nombre", usuario.getNombre().concat(usuario.getApellido()));
        // model.addAttribute("apellido", usuario.getApellido());
        model.addAttribute("email", usuario.getEmail());
        return "perfil";
    }

    @GetMapping({ "/listar" })
    public String listar(Model model) {
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Enmanuel", "Tavera", "enmanuel@tavera.com"));
        usuarios.add(new Usuario("Enmanuel2", "Tavera2", "enmanuel2@tavera2.com"));
        usuarios.add(new Usuario("Enmanuel3", "Tavera3", "enmanuel3@tavera3.com"));
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }


    @GetMapping({"/Login"})
    public String login(@RequestParam(name = "email", required = false , defaultValue = "") String email, 
        @RequestParam(name = "password", required = false, defaultValue = "") String password, Model model) {

        if (email.equals("pepito@gmail.com") && password.equals("1234")){
            model.addAttribute("email", email);
            return "rutaVariable/index";
        } else {
            model.addAttribute("message", "Correo o contraseña incorrectos!!");
            model.addAttribute("errors", true);
            return "/auth/login";
        }
        
    }

}
