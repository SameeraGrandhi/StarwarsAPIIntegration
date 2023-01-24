package com.starwars.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Object represents the search response of the starwars api response
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
public class SearchResponse<T extends AbstractSwapAPIV1Resource> {

    public int count;
    public String next;
    public String previous;
    public List<T> results;
}
