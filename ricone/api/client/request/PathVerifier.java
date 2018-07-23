package org.ricone.api.client.request;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
abstract class PathVerifier {
    boolean isInvalidPath(ServicePath path) {
        return false;
    }

    ;

    boolean isMissingId(ServicePath path) {
        return false;
    }

    ;

    boolean isMissingIdType(ServicePath path) {
        return false;
    }

    ;

    boolean isMissingChangesSince(ServicePath path) {
        return false;
    }

    ;

    boolean isMissingAUPPType(ServicePath path) {
        return false;
    }

    ;

    boolean isMissingPagingInfo(ServicePath path) {
        return false;
    }

    ;
}
