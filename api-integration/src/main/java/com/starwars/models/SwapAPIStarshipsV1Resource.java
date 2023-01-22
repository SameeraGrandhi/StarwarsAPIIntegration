package com.starwars.models;

import lombok.Getter;
import lombok.Setter;


/**
 * {
 * 	"name": "Star Destroyer",
 * 	"model": "Imperial I-class Star Destroyer",
 * 	"manufacturer": "Kuat Drive Yards",
 * 	"cost_in_credits": "150000000",
 * 	"length": "1,600",
 * 	"max_atmosphering_speed": "975",
 * 	"crew": "47,060",
 * 	"passengers": "n/a",
 * 	"cargo_capacity": "36000000",
 * 	"consumables": "2 years",
 * 	"hyperdrive_rating": "2.0",
 * 	"MGLT": "60",
 * 	"starship_class": "Star Destroyer",
 * 	"pilots": [],
 * 	"films": [
 * 		"https://swapi.dev/api/films/1/",
 * 		"https://swapi.dev/api/films/2/",
 * 		"https://swapi.dev/api/films/3/"
 * 	],
 * 	"created": "2014-12-10T15:08:19.848000Z",
 * 	"edited": "2014-12-20T21:23:49.870000Z",
 * 	"url": "https://swapi.dev/api/starships/3/"
 * }
 */

@Getter
@Setter
public class SwapAPIStarshipsV1Resource extends AbstractSwapAPIV1Resource{
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    private String MGLT;
    private String starship_class;
    private String[] pilots;
    private String[] films;
}
