package com.starwars.exceptions;

/**
 * Class represents all the exceptions that are certainly due to user related
 * errors . Ex: Invalid input etc.
 * Typically this exception class corresponds to client errors.
 * @author SameeraGrandhi
 */
public class UserException extends RuntimeException {

    /**
     * Constructor for creating exception using an
     * error message
     * @param errorMessage error message
     */
    public UserException(UserErrorMessages errorMessage) {
        super(errorMessage.getErrorMessage());
    }

    /**
     * Overloaded Constructor for creating exception using an existing
     * Throwable instance
     * @param errorMessage error message of the exception
     * @param th throwable instance
     */
    public UserException(UserErrorMessages errorMessage, Throwable th) {
        super(errorMessage.getErrorMessage(), th);
    }
}
