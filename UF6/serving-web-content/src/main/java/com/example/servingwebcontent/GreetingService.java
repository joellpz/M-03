package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private List<String> llista;
    @Autowired
    public GreetingService(List<String> llista) {
        this.llista = llista;
    }

    public List<String> getMessages() {
        return llista;
    }

    public void addMessage(String msg){
        llista.add(msg);
    }
}
