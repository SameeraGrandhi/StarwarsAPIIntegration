package com.starwars.data;

import com.starwars.models.SwapAPIPeopleV1Resource;
import com.starwars.models.SwapAPIPlanetsV1Resource;

public class TestDataHolder {

    public static SwapAPIPeopleV1Resource getSamplePeopleAPIResponse() {
        SwapAPIPeopleV1Resource peopleV1Resource = new SwapAPIPeopleV1Resource();
        peopleV1Resource.setBirth_year("2000");
        peopleV1Resource.setEye_color("Black");
        peopleV1Resource.setName("ABC");
        peopleV1Resource.setFilms(new String[]{"Film1","Film2","Film3"});
        peopleV1Resource.setMass("23");
        peopleV1Resource.setGender("Male");
        peopleV1Resource.setHeight("5'7");
        return peopleV1Resource;
    }

    public static SwapAPIPeopleV1Resource getMinimalPeopleAPIResponse() {
        SwapAPIPeopleV1Resource peopleV1Resource = new SwapAPIPeopleV1Resource();
        peopleV1Resource.setBirth_year("1900");
        peopleV1Resource.setEye_color("Black");
        peopleV1Resource.setName("PQR");
        peopleV1Resource.setFilms(new String[]{"Film12","Film23","Film34"});
        peopleV1Resource.setMass("322");
        peopleV1Resource.setGender("Female");
        peopleV1Resource.setHeight("5'4");
        return peopleV1Resource;
    }

    public static SwapAPIPlanetsV1Resource getSamplePlanetsAPIResource() {
        SwapAPIPlanetsV1Resource planetsV1Resource = new SwapAPIPlanetsV1Resource();
        planetsV1Resource.setName("Planet1");
        planetsV1Resource.setFilms(new String[]{"Film1"});
        planetsV1Resource.setClimate("18");
        planetsV1Resource.setDiameter("23");
        planetsV1Resource.setResidents(new String[]{"Res1","Res2"});
        planetsV1Resource.setGravity("10");
        planetsV1Resource.setOrbital_period("24");
        planetsV1Resource.setPopulation("1.3T");
        planetsV1Resource.setRotation_period("200");
        planetsV1Resource.setTerrain("abcd");
        planetsV1Resource.setSurface_water("456");
        return planetsV1Resource;
    }
}
