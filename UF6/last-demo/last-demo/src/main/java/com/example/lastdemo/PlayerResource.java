package com.example.lastdemo;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(com.example.lastdemo.PlayerResource.PLAYER)

public class PlayerResource {
    public static final String PLAYER = "/player";
    @Autowired
    PlayerController playerController;

    @GetMapping
    public List<PlayerDto> readAll() {
        return playerController.getAllPlayers();
    }

    @GetMapping("{id}")
    public PlayerDto getPlayer(@PathVariable Integer id) {
        return playerController.getPlayerById(id);
    }

    @GetMapping("{id}/name")
    public Map<String, String> name(@PathVariable Integer id) {
        return Collections.singletonMap("name", playerController.getPlayerById(id).getName());
    }

    @PostMapping
    public void addPlayer(@RequestBody Player player) {
        playerController.addPlayer(player);
    }

    //curl -X DELETE http://localhost:8080/player/{id}
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        System.out.println(id);
        playerController.deletePlayer(playerController.getPlayerById(id));
    }


    /*curl --location --request PUT 'http://localhost:8080/player/1' \
--header 'Content-Type: application/json' \
--data '{ "playerId": 1,
        "name": "Joel",
        "age": 4,
        "position": "TestPosition",
        "college": "Duke",
        "draftTeam": "Test",
        "draftPos": 25,
        "draftYear": 1990,
        "born": "1968-06-23T23:00:00.000+00:00",
        "expCareer": 5
    }'
     */
    @PutMapping("{id}")
    public PlayerDto replacePlayer(@PathVariable Integer id, @RequestBody PlayerDto playerDto) {
        return playerController.replacePlayer(id, playerDto);
    }

    /*
    * curl --location --request PATCH 'http://localhost:8080/player/1' \
--header 'Content-Type: application/json-patch+json' \
--data '[{"op":"replace","path":"/name","value":"PollitoMaster"}]'
    * */
    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody JsonPatch patch) {
        return playerController.updatePlayer(id, patch);
    }
}
