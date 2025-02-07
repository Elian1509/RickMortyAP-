package com.apiRickMorty.apiRickMorty.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharactersModel {


    private String id;
    private String name;
    private String species;
    private String gender;
    private String image;
    private List<String> episode;


}
