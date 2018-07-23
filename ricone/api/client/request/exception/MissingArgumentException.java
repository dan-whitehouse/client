package org.ricone.api.client.request.exception;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class MissingArgumentException extends Exception {
    public MissingArgumentException() {
    }

    public MissingArgumentException(String message) {
        super(message);
    }
}
