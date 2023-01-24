package com.starwars.exceptions;

import lombok.Getter;

public enum UserErrorMessages implements IErrorMessage{
    INVALID_REQUEST_PARAMETERS("Invalid request paramters"),
    INVALID_SEARCH_STRING("Invalid search string provided"),
    INVALID_RESOURCE_TYPE("Provided type is not valid");

    @Getter
    String errorMessage;

    UserErrorMessages(String format) {
        this.errorMessage = format;
    }
}
