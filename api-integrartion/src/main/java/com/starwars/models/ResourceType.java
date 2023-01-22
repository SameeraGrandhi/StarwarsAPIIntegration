package com.starwars.models;

import lombok.Getter;
import com.starwars.criteria.SearchFilter;
import com.starwars.rest.SwapAPIClient;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This Enum represents individual Swap API resources
 * information .
 */
public enum ResourceType {

    PEOPLE("People",SwapAPIPeopleV1Resource.class) {
        @Override
        List<SwapAPIPeopleV1Resource> getSpecificResource(SwapAPIClient apiClient, SearchFilter searchFilter) {
            return apiClient.findPeople(searchFilter);
        }
    },
    VEHICLES("Vehicles",SwapAPIVehiclesV1Resource.class) {
        @Override
        List<SwapAPIVehiclesV1Resource> getSpecificResource(SwapAPIClient apiClient, SearchFilter searchFilter) {
            return apiClient.findVehicles(searchFilter);
        }
    },
    SPECIES("Species",SwapAPISpeciesV1Resource.class) {
        @Override
        List<SwapAPISpeciesV1Resource> getSpecificResource(SwapAPIClient apiClient, SearchFilter searchFilter) {
            return apiClient.findSpecies(searchFilter);
        }
    },
    STARSHIPS("Starships",SwapAPIStarshipsV1Resource.class) {
        @Override
        List<SwapAPIStarshipsV1Resource> getSpecificResource(SwapAPIClient apiClient, SearchFilter searchFilter) {
            return apiClient.findStarShips(searchFilter);
        }
    },
    FILMS("Films",SwapAPIFilmsV1Resource.class) {
        @Override
        List<SwapAPIFilmsV1Resource> getSpecificResource(SwapAPIClient apiClient, SearchFilter searchFilter) {
            return apiClient.findFilms(searchFilter);
        }
    },
    PLANETS("Planets",SwapAPIPlanetsV1Resource.class) {
        @Override
        List<SwapAPIPlanetsV1Resource> getSpecificResource(SwapAPIClient apiClient, SearchFilter searchFilter) {
            return apiClient.findPlanets(searchFilter);
        }
    };

    @Getter
    String type;

    @Getter
    Class<? extends AbstractSwapAPIV1Resource> apiClass;

    private static Map<String,ResourceType> resourceTypeMap;

    static {
        resourceTypeMap = new HashMap<>();
        for(ResourceType each: ResourceType.values()) {
            resourceTypeMap.put(each.getType(),each);
        }
    }

    <T extends AbstractSwapAPIV1Resource> ResourceType(String type, Class<T> klazz) {
        this.type = type;
        this.apiClass = klazz;
    }

    abstract <T extends  AbstractSwapAPIV1Resource> List<T> getSpecificResource(@NonNull final SwapAPIClient apiClient,
                                                                                @NonNull final SearchFilter searchFilter);

    public <T extends  AbstractSwapAPIV1Resource> List<T> get(@NonNull final SwapAPIClient apiClient,
                                                              @NonNull final SearchFilter searchFilter) {
        return getSpecificResource(apiClient,searchFilter);
    }

    public static ResourceType from(String typeString) {
        return resourceTypeMap.getOrDefault(typeString,null);
    }
}
