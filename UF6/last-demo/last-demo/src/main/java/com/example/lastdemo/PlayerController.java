package com.example.lastdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    PlayerService playerService;
    ObjectMapper objectMapper = new ObjectMapper();

    public List<PlayerDto> getAllPlayers() {
        List<Player> playerList = playerService.findAll();
        List<PlayerDto> playerDtoList = playerList.stream().map(PlayerDto::new).toList();
        return playerDtoList;
    }

    public PlayerDto getPlayerById(Integer id) {
        Player player = playerService.getPlayerById(id);
        return new PlayerDto(player);
    }

    public void addPlayer(Player player) {
        playerService.newPlayer(player);
    }

    public void deletePlayer(PlayerDto player){
        playerService.deletePlayer(new Player(player));
    }

    public PlayerDto replacePlayer(int id, PlayerDto playerDto){
       return new PlayerDto(playerService.replacePlayer(id, new Player(playerDto)));
    }

    public ResponseEntity<Player> updatePlayer(Integer id, JsonPatch patch) {
        try {
            Player player = playerService.getPlayerById(id);
            Player playerPatched = applyPatchToPlayer(patch, player);
            playerService.updatePlayer(playerPatched);
            return ResponseEntity.ok(playerPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private Player applyPatchToPlayer(JsonPatch patch, Player targetPlayer) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetPlayer, JsonNode.class));
        return objectMapper.treeToValue(patched, Player.class);
    }
}
