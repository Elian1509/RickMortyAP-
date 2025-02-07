package com.apiRickMorty.apiRickMorty.services;


import com.apiRickMorty.apiRickMorty.models.CharactersModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class CharactersServices {
    private final WebClient webClient;

    public CharactersServices(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharactersModel> findCharacterById(String id){
        log.info("Search for character by ID [{}]", id);
        return webClient
                .get()
                .uri("/character/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verify the parameters")))
                .bodyToMono(CharactersModel.class);
    }
}
