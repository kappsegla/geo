package com.example.geo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {

    PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository) {
        this.playgroundRepository = playgroundRepository;
    }

    List<Playground> getAll(){
        return playgroundRepository.findAll();
    }

    public Playground createNew(Playground playground) {
        return playgroundRepository.save(playground);
    }
}
