package com.example.lastdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerDAO repository;

    public List<Player> findAll() {
        return repository.findAll();
    }

    public Player getPlayerById(Integer id) {
        Optional<Player> optionalPlayer;
        optionalPlayer = repository.findById(id);
        return optionalPlayer.orElse(null);
    }

    public Player newPlayer(Player player) {
        return repository.save(player);
    }

    public void deletePlayer(Player player) {
        repository.delete(player);
    }
    public Player replacePlayer(int id,Player player){
        repository.deleteById(id);
        return repository.save(player);
    }

    public void updatePlayer(Player playerPatched) {
        repository.save(playerPatched);
    }
}
