package com.example.geo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaygroundController {

    PlaygroundService playgroundService;

    public PlaygroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @GetMapping("/playgrounds")
    public List<Playground> getAll(){
        return playgroundService.getAll();
    }

    @PostMapping("/playgrounds")
    public ResponseEntity<Void> createNew(@RequestBody Playground playground){
        var playg = playgroundService.createNew(playground);
        //Todo: Add created with uri
        return ResponseEntity.ok().build();
    }

}
