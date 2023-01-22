package com.starwars.models.viewobject;

import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIStarshipsV1Resource;
import com.starwars.rest.SwapAPIClient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwapV1StarshipsVO extends AbstractSwapAPIV1Resource implements ISwapResource{

    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    private String MGLT;
    private String starship_class;
    private SwapV1PeopleVO[] pilots;
    private SwapV1FilmsVO[] films;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.STARSHIPS;
    }

    public SwapV1StarshipsVO from(SwapAPIClient apiClient, SwapAPIStarshipsV1Resource swapAPIStarshipsV1Resource) {
        return null;
    }

    public SwapV1StarshipsVO shortVO(SwapAPIStarshipsV1Resource swapAPIStarshipsV1Resource) {
        return null;
    }
}
