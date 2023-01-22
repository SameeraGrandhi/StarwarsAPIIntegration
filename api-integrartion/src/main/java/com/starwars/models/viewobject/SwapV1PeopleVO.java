package com.starwars.models.viewobject;

import com.starwars.models.AbstractSwapAPIV1Resource;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIPeopleV1Resource;
import com.starwars.rest.SwapAPIClient;

@Getter
@Setter
@Builder
public class SwapV1PeopleVO extends AbstractSwapAPIV1Resource implements ISwapResource {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private SwapV1PeopleVO homeworld;
    private SwapV1FilmsVO[] films;
    private SwapV1SpeciesVO[] species;
    private SwapV1VehiclesVO[] vehicles;
    private SwapV1StarshipsVO[] starships;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.PEOPLE;
    }

    public static SwapV1PeopleVO withFull(SwapAPIClient apiClient, SwapAPIPeopleV1Resource swapAPIPeopleV1Resource) {
        return null;
    }

    public static SwapV1PeopleVO withMinimal(@NonNull final SwapAPIPeopleV1Resource swapAPIPeopleV1Resource) {

        return null;
    }
}
