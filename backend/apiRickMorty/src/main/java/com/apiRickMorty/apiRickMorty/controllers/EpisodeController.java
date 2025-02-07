package com.apiRickMorty.apiRickMorty.controllers;


import com.apiRickMorty.apiRickMorty.models.EpisodesModel;
import com.apiRickMorty.apiRickMorty.services.EpisodeServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EpisodeController {

    EpisodeServices episodeServices;

    @GetMapping("/episode/{id}")
    public Mono<EpisodesModel> getEpisodeById(@PathVariable String id){
        return episodeServices.findEpisodeById(id);
    }
}
