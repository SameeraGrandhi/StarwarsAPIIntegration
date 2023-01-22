package com.starwars.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SearchResponse<T extends AbstractSwapAPIV1Resource> {

    public int count;
    public String next;
    public String previous;
    public List<T> results;
}
