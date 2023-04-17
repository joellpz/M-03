package com.example.lastdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {
    @Autowired
    PersonajeDAO repository;

    public List<Personaje> findAll() {
        return repository.findAll();
    }

    public Personaje getPersonajeById(Integer id) {
        Optional<Personaje> optionalPersonaje;
        optionalPersonaje = repository.findById(id);
        return optionalPersonaje.orElse(null);
    }

    public Personaje newPersonaje(Personaje personaje){
        return repository.save(personaje);

    }
}
