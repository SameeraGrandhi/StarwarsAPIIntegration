package com.starwars.service;

import com.starwars.criteria.SearchFilter;
import com.starwars.data.TestDataHolder;
import com.starwars.exceptions.InternalFailureException;
import com.starwars.exceptions.UserErrorMessages;
import com.starwars.exceptions.UserException;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIPeopleV1Resource;
import com.starwars.rest.SwapAPIClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StarwarsSearchServiceTest {

    @Mock
    private SwapAPIClient apiClient;

    @InjectMocks
    private StarwarSearchServiceImpl searchService;

    private SearchFilter defaultSearchFilter = new SearchFilter() {
        @Override
        public String fieldValue() {
            return "a";
        }
    };

    /**
     * When - Valid resource type and search filter is provided
     * Then - return the search api results successfully
     */
    @Test
    public void whenResourceTypeIsPeople_ThenReturnSuccess() {
        List<SwapAPIPeopleV1Resource> peopleV1ResourceList = new ArrayList<>();
        peopleV1ResourceList.add(TestDataHolder.getSamplePeopleAPIResponse());
        peopleV1ResourceList.add(TestDataHolder.getMinimalPeopleAPIResponse());
        when(apiClient.findPeople(defaultSearchFilter)).thenReturn(peopleV1ResourceList);

        Assertions.assertEquals(searchService.search(ResourceType.PEOPLE,defaultSearchFilter),
                peopleV1ResourceList);
    }

    /**
     * When - resource type and search filter are valid and execution fails with exception
     * Then - Throw exception
     */
    @Test
    public void whenResourceTypeThrowsException_ThenThrowException() {

        when(searchService.search(ResourceType.SPECIES,defaultSearchFilter))
                .thenThrow(InternalFailureException.class);

        Assertions.assertThrows(InternalFailureException.class,()->{
            searchService.search(ResourceType.SPECIES,defaultSearchFilter);
        });
    }
}
