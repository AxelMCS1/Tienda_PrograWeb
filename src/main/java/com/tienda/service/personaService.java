/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.personaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author axelc
 */
@Service
public class personaService implements iPersonaService{
     @Autowired
     private personaRepository personaRepository;
    
    @Override
    public List<Persona> getAllPersona() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(long id) {
        return personaRepository.findById(id).orElse(null);
        //retorne ese objeto si existe, si no devuelve null
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }
    
}
