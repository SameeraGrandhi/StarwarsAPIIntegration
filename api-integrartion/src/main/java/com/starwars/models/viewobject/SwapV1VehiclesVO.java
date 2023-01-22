package com.starwars.models.viewobject;

import lombok.Getter;
import lombok.Setter;
import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIPeopleV1Resource;
import com.starwars.models.SwapAPIVehiclesV1Resource;
import com.starwars.rest.SwapAPIClient;

@Setter
@Getter
public class SwapV1VehiclesVO extends AbstractSwapAPIV1Resource implements ISwapResource{

    private String cargo_capacity;
    private String consumables;
    private String cost_in_credits;
    private String crew;
    private String length;
    private String manufacturer;
    private String max_atmosphering_speed;
    private String name;
    private String model;
    private String passengers;
    private SwapAPIPeopleV1Resource[] pilots;
    private SwapV1FilmsVO[] films;
    private String vehicle_class;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.VEHICLES;
    }

    public ISwapResource from(SwapAPIClient apiClient, SwapAPIVehiclesV1Resource swapAPIVehiclesV1Resource) {
        return null;
    }

    public SwapV1VehiclesVO shortVO(SwapAPIVehiclesV1Resource swapAPIVehiclesV1Resource) {
        return null;
    }
}
