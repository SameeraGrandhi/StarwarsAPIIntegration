package com.starwars.models.viewobject;

import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIPlanetsV1Resource;
import com.starwars.rest.SwapAPIClient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwapV1PlanetsVO extends AbstractSwapAPIV1Resource implements ISwapResource{
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private SwapV1PeopleVO[] residents;
    private SwapV1FilmsVO[] films;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.PLANETS;
    }

    public SwapV1PlanetsVO from(SwapAPIClient apiClient, SwapAPIPlanetsV1Resource swapAPIPlanetsV1Resource) {
        return null;
    }

    public SwapV1PlanetsVO shortVO(SwapAPIPlanetsV1Resource swapAPIPlanetsV1Resource) {
        return null;
    }
}
