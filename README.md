# StarwarsAPIIntegration
This repository integrates with Starwars API to fetch the resource details as requested by the user
It uses Java, Spring boot for the integration.

### Problem Statement

To find details of Planets, Spaceships, Vehicles, People, Films and Species from all of star wars movie. End user should be able to view results by changing “type” and “name”. Here “type” could be one of Planets, Spaceships, Vehicles, People, Films and Species and “name” could be name of any of the object in that type e.g. type=Vehicles&name=Sand Crawler;

### Requirements:

1. End user should be able to view results by changing the input parameters
2. The service should be ready to be released to production or live environment
3. The service should be accessible via web browser or postman (using any one of JavaScript frameworks, HTML or JSON)
4. The solution should support offline mode with toggles.
5. The service should return relevant results as expected, even while the underlying dependencies (Ex: Public API) are not available!

### Local development

#### Pre-requisites
1. JDK 11
2. Maven 3.8.7 version

#### Build and deploy in development environment
3. Clone the application from the github repository
4. Run ```sh devstart.sh ``` to build and start the spring boot server.
5. Run ```sh devstop.sh``` to stop the server.

### Swagger
#### API Contract

1. Search API
```/api/v1/search?type=<resource-type>&name=<search-text>```

Returns a json with a list of resource type objects along with its details. 
Returns 4xx if the request parameters fail to validate 
Sample json:
```
[
  {
    "created": "2014-12-10T15:11:50.376000Z",
    "edited": "2014-12-20T21:17:50.311000Z",
    "url": "https://swapi.dev/api/people/3/",
    "name": "R2-D2",
    "height": "96",
    "mass": "32",
    "hair_color": "n/a",
    "skin_color": "white, blue",
    "eye_color": "red",
    "birth_year": "33BBY",
    "gender": "n/a",
    "homeworld": "https://swapi.dev/api/planets/8/",
    "films": [
      "https://swapi.dev/api/films/1/",
      "https://swapi.dev/api/films/2/",
      "https://swapi.dev/api/films/3/",
      "https://swapi.dev/api/films/4/",
      "https://swapi.dev/api/films/5/",
      "https://swapi.dev/api/films/6/"
    ],
    "species": [
      "https://swapi.dev/api/species/2/"
    ],
    "vehicles": [

    ],
    "starships": [

    ]
  }
]
```

Note: 

* API Spec can be viewed at: http://localhost:8080/swagger-ui/index.html

* For other environments , view with the ```/swagger-ui/index.html``` context along with your host

### Design

#### High Level architecture:
![HLD](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/blob/main/docs/images/current-arch.png)

* User initiates a web request to the server
* the request will be validated and processed by invoking a swap api to fetch the corresponding results
* the response is converted to the viewable mode and returned back to the user.

#### Low level design
The below diagram shows how the interactions are made between each component.

![SequenceDiagram](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/blob/main/docs/images/sequence-diagram.jpg)
![ClassDiagram](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/blob/main/docs/images/class-diagram.jpg)

##### Design analysis & trade-offs
Find the design analysis document to find details in depth [here](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/wiki/Design-Analysis)

### Git flow

The below diagram illustrates how the build is triggered and the jenkins pipeline is initiated.

![Image](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/blob/main/docs/images/gitflow.png)

Note: Currently webhook is not configured as Jenkins server is not available as public 

### References

[Assumptions & Improvements](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/wiki/Assumptions-and-Improvements)

[Design analysis and choices made](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/wiki/Design-Analysis)

[Design patterns used in the code](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/wiki/Design-Patterns)

[Starwars Website](https://swapi.dev/)

[Starwars API Documentation](https://swapi.dev/documentation)

#### NOTE: Please read [wiki](https://github.com/SameeraGrandhi/StarwarsAPIIntegration/wiki) for more details on the implementation