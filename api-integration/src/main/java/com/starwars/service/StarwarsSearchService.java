package com.starwars.service;

import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.criteria.SearchFilter;

import java.util.List;

public interface StarwarsSearchService {

    public <T extends AbstractSwapAPIV1Resource> List<T> search(ResourceType type, SearchFilter searchFilter);
}
