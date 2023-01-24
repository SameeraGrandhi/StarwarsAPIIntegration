package com.starwars.exceptions;

public class InternalFailureException extends RuntimeException{

    public InternalFailureException(InternalFailureErrorMessages errorMessage){
        super(errorMessage.getErrorMessage());
    }

    public InternalFailureException(InternalFailureErrorMessages errorMessage, Throwable throwable){
        super(errorMessage.getErrorMessage(), throwable);
    }
}
