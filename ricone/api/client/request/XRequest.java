package org.ricone.api.client.request;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public abstract class XRequest {

    boolean hasId() {
        return false;
    }

    boolean hasIdType() {
        return false;
    }

    boolean hasPaging() {
        return false;
    }

    boolean hasSchoolYear() {
        return false;
    }

    boolean hasAUPP() {
        return false;
    }

    boolean hasChangesSince() {
        return false;
    }
}
