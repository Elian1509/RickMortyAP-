package com.apiRickMorty.apiRickMorty.controllers;

import com.apiRickMorty.apiRickMorty.models.CharactersModel;
import com.apiRickMorty.apiRickMorty.services.CharactersServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class CharactersController {

    CharactersServices charactersServices;

    @GetMapping("/character/{id}")
    public Mono<CharactersModel> getCharacterById(@PathVariable String id){
        return charactersServices.findCharacterById(id);
    }
}



