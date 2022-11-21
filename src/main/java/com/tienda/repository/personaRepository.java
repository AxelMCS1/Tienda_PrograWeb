/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author axelc
 */
public interface personaRepository extends CrudRepository<Persona, Long>{
    
    Persona findByNombre (String nombre);
}
