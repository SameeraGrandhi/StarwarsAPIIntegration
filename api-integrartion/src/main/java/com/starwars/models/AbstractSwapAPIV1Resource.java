package com.starwars.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public abstract class AbstractSwapAPIV1Resource implements Serializable {

    private String created;
    private String edited;
    private String url;
}
