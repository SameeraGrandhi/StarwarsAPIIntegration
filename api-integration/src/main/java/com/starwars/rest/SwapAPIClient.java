package com.starwars.rest;

import com.starwars.models.*;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.starwars.criteria.SearchFilter;

import java.util.*;

import static com.starwars.spring.CacheConfiguration.CUSTOM_KEY_GENERATOR_BEAN_NAME;


/**
 * Rest Client for contacting Swap API service
 * This Client will be the point of interaction to StarWars service API's
 *
 * @see <a href="https://swapi.dev/documentation">Swap API Documentation</a>
 * @see <a href="https://swapi.dev/"></a>
 */
@Service
@Log4j2
public class SwapAPIClient {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL_DELIMITER = "/";
    private static final String SEARCH_URL_DELIMITER = "?search=";
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static final String PARAMETERS = "parameters";
    private static final String STARWARS_CACHE_NAME = "starwarsCache";

    private ParameterizedTypeReference<SearchResponse<SwapAPIPeopleV1Resource>> peopleTypeReference =
            new ParameterizedTypeReference<SearchResponse<SwapAPIPeopleV1Resource>>() {
            };

    private ParameterizedTypeReference<SearchResponse<SwapAPIPlanetsV1Resource>> planetTypeReference =
            new ParameterizedTypeReference<SearchResponse<SwapAPIPlanetsV1Resource>>() {
            };

    private ParameterizedTypeReference<SearchResponse<SwapAPISpeciesV1Resource>> speciesTypeReference =
            new ParameterizedTypeReference<SearchResponse<SwapAPISpeciesV1Resource>>() {
            };

    private ParameterizedTypeReference<SearchResponse<SwapAPIStarshipsV1Resource>> starshipsTypeReference =
            new ParameterizedTypeReference<SearchResponse<SwapAPIStarshipsV1Resource>>() {
            };

    private ParameterizedTypeReference<SearchResponse<SwapAPIFilmsV1Resource>> filmsTypeReference =
            new ParameterizedTypeReference<SearchResponse<SwapAPIFilmsV1Resource>>() {
            };

    private ParameterizedTypeReference<SearchResponse<SwapAPIVehiclesV1Resource>> vehiclesTypeReference =
            new ParameterizedTypeReference<SearchResponse<SwapAPIVehiclesV1Resource>>() {
            };

    /**
     * Abstracts the search API of Swap People resource
     * @param searchCriteria the keyword to be searched under name field
     * @return matched people resources
     */
    @Cacheable(keyGenerator = CUSTOM_KEY_GENERATOR_BEAN_NAME, value = STARWARS_CACHE_NAME)
    public List<SwapAPIPeopleV1Resource> findPeople(@NonNull SearchFilter searchCriteria) {
        System.out.println("Invoking the call from SWAP service");
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append(ResourceType.PEOPLE.getType().toLowerCase())
                .append(URL_DELIMITER)
                .append(SEARCH_URL_DELIMITER)
                .append(searchCriteria.fieldValue());
        return search(urlBuilder.toString(), peopleTypeReference);
    }

    /**
     * Abstracts the search API of Swap Planets resource
     * @param searchCriteria the keyword to be searched under name field
     * @return matched Planets resources
     */
    @Cacheable(keyGenerator = CUSTOM_KEY_GENERATOR_BEAN_NAME, value = STARWARS_CACHE_NAME)
    public List<SwapAPIPlanetsV1Resource> findPlanets(@NonNull SearchFilter searchCriteria) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append(ResourceType.PLANETS.getType().toLowerCase())
                .append(URL_DELIMITER)
                .append(SEARCH_URL_DELIMITER)
                .append(searchCriteria.fieldValue());

        return search(urlBuilder.toString(), planetTypeReference);
    }

    /**
     * Abstracts the search API of Swap Vehicles resource
     * @param searchCriteria the keyword to be searched under name field
     * @return matched Vehicles resources
     */
    @Cacheable(keyGenerator = CUSTOM_KEY_GENERATOR_BEAN_NAME, value = STARWARS_CACHE_NAME)
    public List<SwapAPIVehiclesV1Resource> findVehicles(@NonNull SearchFilter searchCriteria) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append(ResourceType.VEHICLES.getType().toLowerCase())
                .append(URL_DELIMITER)
                .append(SEARCH_URL_DELIMITER)
                .append(searchCriteria.fieldValue());
        return search(urlBuilder.toString(), vehiclesTypeReference);
    }

    /**
     * Abstracts the search API of Swap Species resource
     * @param searchCriteria the keyword to be searched under name field
     * @return matched Species resources
     */
    @Cacheable(keyGenerator = CUSTOM_KEY_GENERATOR_BEAN_NAME, value = STARWARS_CACHE_NAME)
    public List<SwapAPISpeciesV1Resource> findSpecies(@NonNull SearchFilter searchCriteria) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append(ResourceType.SPECIES.getType().toLowerCase())
                .append(URL_DELIMITER)
                .append(SEARCH_URL_DELIMITER)
                .append(searchCriteria.fieldValue());

        return search(urlBuilder.toString(), speciesTypeReference);
    }

    /**
     * Abstracts the search API of Swap Starships resource
     * @param searchCriteria the keyword to be searched under name field
     * @return matched Starships resources
     */
    @Cacheable(keyGenerator = CUSTOM_KEY_GENERATOR_BEAN_NAME, value = STARWARS_CACHE_NAME)
    public List<SwapAPIStarshipsV1Resource> findStarShips(@NonNull SearchFilter searchCriteria) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append(ResourceType.STARSHIPS.getType().toLowerCase())
                .append(URL_DELIMITER)
                .append(SEARCH_URL_DELIMITER)
                .append(searchCriteria.fieldValue());

        return search(urlBuilder.toString(), starshipsTypeReference);
    }

    /**
     * Abstracts the search API of Swap Films resource
     * @param searchCriteria the keyword to be searched under name field
     * @return matched Films resources
     */
    @Cacheable(keyGenerator = CUSTOM_KEY_GENERATOR_BEAN_NAME, value = STARWARS_CACHE_NAME)
    public List<SwapAPIFilmsV1Resource> findFilms(@NonNull SearchFilter searchCriteria) {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append(ResourceType.FILMS.getType().toLowerCase())
                .append(URL_DELIMITER)
                .append(SEARCH_URL_DELIMITER)
                .append(searchCriteria.fieldValue());

        return search(urlBuilder.toString(), filmsTypeReference);
    }

    private <T extends AbstractSwapAPIV1Resource> List<T> search(@NonNull String url,
                                                                 @NonNull ParameterizedTypeReference<SearchResponse<T>> typeReference) {
        List<T> matchedResources = new ArrayList<>();
        boolean hasNextPage = true;
        do {
            log.info("Invoking search call using: {}", url);
            SearchResponse<T> searchResponse = restTemplate.exchange(url, HttpMethod.GET,
                    buildHttEntityHeader(), typeReference).getBody();
            if (!Objects.isNull(searchResponse)) {
                matchedResources.addAll(searchResponse.getResults());
                if (!Strings.isBlank(searchResponse.getNext())) {
                    url = searchResponse.getNext();
                } else {
                    hasNextPage = false;
                }
            }
        } while (hasNextPage);
        return matchedResources;
    }

    private HttpEntity<String> buildHttEntityHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(PARAMETERS, headers);
        return entity;
    }
}
