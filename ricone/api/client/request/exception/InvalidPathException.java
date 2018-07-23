package org.ricone.api.client.request.exception;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class InvalidPathException extends Exception {
    public InvalidPathException() {
    }

    public InvalidPathException(String message) {
        super(message);
    }
}
