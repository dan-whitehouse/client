package org.ricone.api.client.request;

import org.ricone.api.client.request.exception.InvalidPathException;
import org.ricone.api.client.request.exception.MissingArgumentException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class XPressRequestChangesSince extends XRequest {
    private ServicePath servicePath;
    private PagingInfo pagingInfo;
    private ChangesSince changesSince;

    private XPressRequestChangesSince() {
    }

    //GETTERS
    ServicePath getServicePath() {
        return servicePath;
    }

    PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    ChangesSince getChangesSince() {
        return changesSince;
    }

    //BUILDER
    public static class Builder extends PathVerifier {
        private ServicePath servicePath;
        private PagingInfo pagingInfo;
        private ChangesSince changesSince;

        public Builder(ServicePath servicePath) {
            this.servicePath = servicePath;
        }

        public Builder pagingInfo(Integer pageNumber, Integer pageSize) {
            this.pagingInfo = new PagingInfo(pageNumber, pageSize);
            return this;
        }

        public Builder changesSince(LocalDateTime opaqueMarker) {
            this.changesSince = new ChangesSince(opaqueMarker);
            return this;
        }

        public XPressRequestChangesSince build() throws InvalidPathException, MissingArgumentException {
            if(isInvalidPath(this.servicePath)) {
                List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
                throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
            }

            if(isMissingChangesSince(this.servicePath)) {
                throw new MissingArgumentException(servicePath + " requires the changesSince method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
            }

            XPressRequestChangesSince xPressRequest = new XPressRequestChangesSince();
            xPressRequest.servicePath = this.servicePath;
            xPressRequest.pagingInfo = this.pagingInfo;
            xPressRequest.changesSince = this.changesSince;
            return xPressRequest;
        }

        @Override
        boolean isInvalidPath(ServicePath path) {
            return !path.getXPressRequestTypes().contains(RequestType.CHANGES_SINCE);
        }

        @Override
        boolean isMissingChangesSince(ServicePath path) {
            return this.changesSince == null;
        }
    }

    //OVERRIDES
    @Override
    boolean hasChangesSince() {
        return changesSince != null;
    }

    @Override
    boolean hasPaging() {
        return pagingInfo != null;
    }

    @Override
    public String toString() {
        return "XPressRequestChangesSince{" + "servicePath=" + servicePath + ", pagingInfo=" + pagingInfo + ", changesSince=" + changesSince + '}';
    }
}
