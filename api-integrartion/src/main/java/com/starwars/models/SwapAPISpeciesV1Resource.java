package com.starwars.models;

import lombok.Getter;
import lombok.Setter;

/**
 * {
 * 	"name": "Wookie",
 * 	"classification": "mammal",
 * 	"designation": "sentient",
 * 	"average_height": "210",
 * 	"skin_colors": "gray",
 * 	"hair_colors": "black, brown",
 * 	"eye_colors": "blue, green, yellow, brown, golden, red",
 * 	"average_lifespan": "400",
 * 	"homeworld": "https://swapi.dev/api/planets/14/",
 * 	"language": "Shyriiwook",
 * 	"people": [
 * 		"https://swapi.dev/api/people/13/",
 * 		"https://swapi.dev/api/people/80/"
 * 	],
 * 	"films": [
 * 		"https://swapi.dev/api/films/1/",
 * 		"https://swapi.dev/api/films/2/",
 * 		"https://swapi.dev/api/films/3/",
 * 		"https://swapi.dev/api/films/6/"
 * 	],
 * 	"created": "2014-12-10T16:44:31.486000Z",
 * 	"edited": "2014-12-20T21:36:42.142000Z",
 * 	"url": "https://swapi.dev/api/species/3/"
 * }
 */
@Getter
@Setter
public class SwapAPISpeciesV1Resource extends AbstractSwapAPIV1Resource{

    private String name;
    private String classification;
    private String designation;
    private String average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private String average_lifespan;
    private String homeworld;
    private String language;
    private String[] people;
    private String[] films;
}
