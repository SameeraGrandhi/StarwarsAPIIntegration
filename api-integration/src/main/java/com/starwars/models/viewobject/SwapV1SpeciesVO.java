package com.starwars.models.viewobject;

import com.starwars.models.SwapAPISpeciesV1Resource;
import lombok.Getter;
import lombok.Setter;
import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.rest.SwapAPIClient;

@Getter
@Setter
public class SwapV1SpeciesVO extends AbstractSwapAPIV1Resource implements ISwapResource {
    private String name;
    private String classification;
    private String designation;
    private String average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private String average_lifespan;
    private SwapV1PeopleVO homeworld;
    private String language;
    private SwapV1PeopleVO[] people;
    private SwapV1FilmsVO[] films;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.SPECIES;
    }

    public SwapV1SpeciesVO from(SwapAPIClient apiClient, SwapAPISpeciesV1Resource swapAPISpeciesV1Resource) {
        return null;
    }

    public SwapV1SpeciesVO shortVO(SwapAPISpeciesV1Resource swapAPISpeciesV1Resource) {
        return null;
    }
}
