package com.starwars.models;

import com.starwars.rest.SwapAPIClient;
import com.starwars.models.viewobject.ISwapResource;

public interface IResourceMapper<T extends AbstractSwapAPIV1Resource> {

    ISwapResource from(SwapAPIClient apiClient, T t);

    ISwapResource shortVO(T t);

}
