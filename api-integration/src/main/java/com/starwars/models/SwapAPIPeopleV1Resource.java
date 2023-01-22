package com.starwars.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {
 * 	"name": "Luke Skywalker",
 * 	"height": "172",
 * 	"mass": "77",
 * 	"hair_color": "blond",
 * 	"skin_color": "fair",
 * 	"eye_color": "blue",
 * 	"birth_year": "19BBY",
 * 	"gender": "male",
 * 	"homeworld": "https://swapi.dev/api/planets/1/",
 * 	"films": [
 * 		"https://swapi.dev/api/films/1/",
 * 		"https://swapi.dev/api/films/2/",
 * 		"https://swapi.dev/api/films/3/",
 * 		"https://swapi.dev/api/films/6/"
 * 	],
 * 	"species": [],
 * 	"vehicles": [
 * 		"https://swapi.dev/api/vehicles/14/",
 * 		"https://swapi.dev/api/vehicles/30/"
 * 	],
 * 	"starships": [
 * 		"https://swapi.dev/api/starships/12/",
 * 		"https://swapi.dev/api/starships/22/"
 * 	],
 * 	"created": "2014-12-09T13:50:51.644000Z",
 * 	"edited": "2014-12-20T21:17:56.891000Z",
 * 	"url": "https://swapi.dev/api/people/1/"
 * }
 */

@Getter
@Setter
@NoArgsConstructor
public class SwapAPIPeopleV1Resource extends AbstractSwapAPIV1Resource{

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String[] films;
    private String[] species;
    private String[] vehicles;
    private String[] starships;

}
