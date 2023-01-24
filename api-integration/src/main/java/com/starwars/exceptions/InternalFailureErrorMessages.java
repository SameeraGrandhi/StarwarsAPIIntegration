package com.starwars.exceptions;

import lombok.Getter;

public enum InternalFailureErrorMessages implements IErrorMessage{
    FAILED_TO_RETRIEVE_RESULTS_WITH_FAILURE("Failed to retrieve requested results due to ");

    @Getter
    String errorMessage;

    InternalFailureErrorMessages(String format) {
        this.errorMessage = format;
    }
}
