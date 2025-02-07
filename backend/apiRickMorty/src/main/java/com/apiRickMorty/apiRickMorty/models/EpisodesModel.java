package com.apiRickMorty.apiRickMorty.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EpisodesModel {

    private String id;
    private String name;
    private String episode;
    private String characters;
}
