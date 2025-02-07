package com.apiRickMorty.apiRickMorty.services;

import com.apiRickMorty.apiRickMorty.models.CharactersModel;
import com.apiRickMorty.apiRickMorty.models.EpisodesModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class EpisodeServices {
    private final WebClient webClient;

    public EpisodeServices(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }



    public Mono<EpisodesModel> findEpisodeById(String id) {
        log.info("Search for episode by ID [{}]", id);
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error-> Mono.error(new RuntimeException("verify the parameters")))
                .bodyToMono(EpisodesModel.class);

    }

}