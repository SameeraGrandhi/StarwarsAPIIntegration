package com.starwars.service;

import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.rest.SwapAPIClient;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starwars.criteria.SearchFilter;

import java.util.List;

/**
 * Service class which has all the business processing of the resource
 * It basically fetches the requested resource from Swap API and checks
 * for if any auxillary calls are required or not from the response
 * object
 */
@Service
public class StarwarSearchServiceImpl implements StarwarsSearchService {

    @Autowired
    SwapAPIClient swapAPIClient;

    /**
     * Retrieves the resource from Swap API and
     * processes it
     * @param type Swap resource type
     * @param searchFilter filter that needs to be applied on the name
     * @param <T> resource object type
     * @return Swap API response object
     */
    @Override
    public <T extends AbstractSwapAPIV1Resource> List<T> search(@NonNull final ResourceType type, @NonNull final SearchFilter searchFilter) {
        return type.get(swapAPIClient,searchFilter);
    }
}
