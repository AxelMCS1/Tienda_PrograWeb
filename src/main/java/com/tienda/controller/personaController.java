/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.iPaisService;
import com.tienda.service.iPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author axelc
 */
@Controller
public class personaController {
    
    @Autowired
    private iPersonaService personaService;
    
    @Autowired
    private iPaisService paisService;
    
    @GetMapping("/persona")
    public String index(Model model){
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Persona");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }
     @GetMapping("/personaN")
    public String crearPersona(Model model){
        List<Pais> listaPaises = paisService.getCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){//modelAtribute para espicificar va a ir del front-end
    
        personaService.savePersona(persona);
        return "redirect:/persona";
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model){
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.getCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";
}
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona){
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
}