package com.example.lastdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(PersonajeResource.PERSONAJES)
public class PersonajeResource {
    public static final String PERSONAJES = "/personajes";
    @Autowired
    PersonajeController personajeController;

    @GetMapping
    public List<PersonajeDto> readAll() {
        return personajeController.getAllPersonajes();
    }

    @GetMapping("{id}")
    public PersonajeDto getPersonaje(@PathVariable Integer id) {
        return personajeController.getPersonajeById(id);
    }

    @GetMapping("{id}/nombre")
    public Map<String, String> nombre(@PathVariable Integer id){
        return Collections.singletonMap("nombre",personajeController.getPersonajeById(id).getNombre());
    }


//    @PutMapping("{id}")
//    public PersonajeDto replace(@PathVariable Integer id, @RequestBody PersonajeDto personajeDto){
//
//    }
}