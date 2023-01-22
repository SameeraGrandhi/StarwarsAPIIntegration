package com.starwars.controller;

import com.starwars.data.TestDataHolder;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIPeopleV1Resource;
import com.starwars.models.SwapAPIPlanetsV1Resource;
import com.starwars.service.StarwarsSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StarwarsAPIControllerTest {

    @Mock
    private StarwarsSearchService searchService;

    @InjectMocks
    private StarwarsAPIController apiController;

    /**
     * When - A search string with people type is provided
     * Then - return appropriate results with success
     */
    @Test
    public void whenPeopleTypeWithValidSearchString_ThenReturnSuccess(){
        List peopleV1ResourceList = new ArrayList<>();
        peopleV1ResourceList.add(TestDataHolder.getSamplePeopleAPIResponse());
        when(searchService.search(any(),any())).thenReturn(peopleV1ResourceList);

        List<SwapAPIPeopleV1Resource> actualResources = apiController.searchDetails(
                ResourceType.PEOPLE.getType(),"a");
        Assertions.assertEquals(actualResources, peopleV1ResourceList );
    }

    /**
     * When - A search string with planets type is provided
     * Then - return appropriate results with success
     */
    @Test
    public void whenPlanetsTypeWithValidSearchString_ThenReturnSuccess(){
        List planetsV1ResourceList = new ArrayList<>();
        planetsV1ResourceList.add(TestDataHolder.getSamplePlanetsAPIResource());
        when(searchService.search(any(),any())).thenReturn(planetsV1ResourceList);

        List<SwapAPIPlanetsV1Resource> actualResources = apiController.searchDetails(
                ResourceType.PLANETS.getType(),"Pl");
        Assertions.assertEquals(actualResources, planetsV1ResourceList );

    }

    /**
     * When - A search string with species type is provided
     * Then - with no results matching , return empty list
     */
    @Test
    public void whenSpeciesTypeWithValidSearchString_ThenReturnSuccess(){
        when(searchService.search(any(),any())).thenReturn(Collections.emptyList());

        List<SwapAPIPlanetsV1Resource> actualResources = apiController.searchDetails(
                ResourceType.SPECIES.getType(),"r");
        Assertions.assertTrue(actualResources.size()==0);
    }

    /**
     * When - A search string with invalid resource type is provided
     * Then - Throw IllegalArgumentException
     */
    @Test
    public void whenInvalidTypeWithValidSearchString_ThenThrowException(){

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            apiController.searchDetails("invalid","r");
        },"Invalid resource type provided");
    }

    /**
     * When - A null search string is provided
     * Then - Throw IllegalArgumentException
     */
    @Test
    public void whenInvalidSearchStringIsProvided_ThenThrowException(){

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            apiController.searchDetails(ResourceType.STARSHIPS.getType(), "");
        },"Invalid request parameters");

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            apiController.searchDetails(ResourceType.FILMS.getType(), null);
        },"Invalid request parameters");
    }

}
