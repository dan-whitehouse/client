package org.ricone.api.client.request3;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
abstract class PathVerifier {
    boolean isInvalidPath(XPressRequest request) {
        return false;
    }

    ;

    boolean isMissingId(XPressRequest request) {
        return false;
    }

    ;

    boolean isMissingIdType(XPressRequest request) {
        return false;
    }

    ;

    boolean isMissingChangesSince(XPressRequest request) {
        return false;
    }

    ;

    boolean isMissingAUPPType(XPressRequest request) {
        return false;
    }

    ;

    boolean isMissingPagingInfo(XPressRequest request) {
        return false;
    }

    ;
}
