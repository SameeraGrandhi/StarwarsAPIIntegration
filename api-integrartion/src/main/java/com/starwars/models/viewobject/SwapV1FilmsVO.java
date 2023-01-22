package com.starwars.models.viewobject;

import com.starwars.models.AbstractSwapAPIV1Resource;
import com.starwars.models.ResourceType;
import com.starwars.models.SwapAPIFilmsV1Resource;
import com.starwars.models.SwapAPIPeopleV1Resource;
import com.starwars.rest.SwapAPIClient;
import com.starwars.utils.URLUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SwapV1FilmsVO extends AbstractSwapAPIV1Resource implements ISwapResource {

    private String title;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private SwapV1PeopleVO[] characters;
    private SwapV1PlanetsVO[] planets;
    private SwapV1StarshipsVO[] starships;
    private SwapV1VehiclesVO[] vehicles;
    private SwapV1SpeciesVO[] species;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.FILMS;
    }

    /*public SwapV1FilmsVO from(@NonNull final SwapAPIClient apiClient, @NonNull final SwapAPIFilmsV1Resource swapAPIFilmsV1Resource) {
        SwapV1FilmsVOBuilder filmsVOBuilder = SwapV1FilmsVO.builder()
                .title(swapAPIFilmsV1Resource.getTitle())
                .episode_id(swapAPIFilmsV1Resource.getEpisode_id())
                .opening_crawl(swapAPIFilmsV1Resource.getOpening_crawl())
                .director(swapAPIFilmsV1Resource.getDirector())
                .producer(swapAPIFilmsV1Resource.getProducer())
                .release_date(swapAPIFilmsV1Resource.getRelease_date());

        SwapV1PeopleVO[] characters = new SwapV1PeopleVO[swapAPIFilmsV1Resource.getCharacters().length];
        int index=0;
        for(String character: swapAPIFilmsV1Resource.getCharacters()) {
            int id = URLUtils.getIdFromUrl(character);
            SwapAPIPeopleV1Resource peopleV1Resource = apiClient.getPeople(id);
            SwapV1PeopleVO peopleVO =  SwapV1PeopleVO.builder()
                    .birth_year(peopleV1Resource.getBirth_year())
                    .eye_color(peopleV1Resource.getEye_color())
                    .gender(peopleV1Resource.getGender())
                    .hair_color(peopleV1Resource.getHair_color())
                    .height(peopleV1Resource.getHeight())
                    .mass(peopleV1Resource.getMass())
                    .name(peopleV1Resource.getName())
                    .skin_color(peopleV1Resource.getSkin_color())
                    .build();
            characters[index++] = peopleVO;
        }
        filmsVOBuilder.characters(characters);

        SwapV1SpeciesVO[] species = new SwapV1SpeciesVO[swapAPIFilmsV1Resource.getSpecies().length];
        return filmsVOBuilder.build();
    }*/

    public static SwapV1FilmsVO shortVO(SwapAPIFilmsV1Resource swapAPIFilmsV1Resource) {
        return null;
    }
}
