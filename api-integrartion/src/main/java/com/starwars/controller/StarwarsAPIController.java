package com.starwars.controller;

import com.starwars.criteria.SearchFilter;
import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.service.StarwarsSearchService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * Controller which provides search endpoint for fetching
 * StarWar details from Swap API
 *
 * @see <a href="https://swapi.dev/">Swap API TryOut</a>
 * @see <a href="https://swapi.dev/documentation">Swap API Documentation</a>
 */
@RestController
@RequestMapping(value= "/api/v1")
public class StarwarsAPIController {

    @Autowired
    StarwarsSearchService starwarsSearchService;

    /**
     * Retrieves the details of StarWars with specific resource and search criteria
     * @param type type of resource to be searched for
     * @param searchText text to be searched
     * @param <T> Resource Object type
     * @return Resource Object
     */
    @GetMapping(value="/search")
    public <T extends AbstractSwapAPIV1Resource> List<T> searchDetails(@RequestParam("type") String type,
                                                                       @RequestParam("name") String searchText) {
        validateRequestParameters(type,searchText);
        SearchFilter searchFilter = new SearchFilter() {
            @Override
            public String fieldValue() {
                return searchText;
            }
        };
        ResourceType resourceType = ResourceType.from(type);
        if(Objects.isNull(resourceType)) {
            throw new IllegalArgumentException("Invalid resource type provided");
        }
        return starwarsSearchService.search(resourceType,searchFilter);
    }

    private void validateRequestParameters(String type, String searchText) {
        if(Objects.isNull(type) || Strings.isBlank(searchText)) {
            throw new IllegalArgumentException("Invalid request parameters");
        }
    }
}
