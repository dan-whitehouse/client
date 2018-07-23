package org.ricone.api.client.request3;

import org.ricone.api.client.request3.exception.InvalidPathException;
import org.ricone.api.client.request3.exception.MissingArgumentException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class XRequestChangesSinceBuilder extends PathVerifier {
    private ServicePath servicePath;
    private PagingInfo pagingInfo;
    private ChangesSince changesSince;

    public XRequestChangesSinceBuilder(ServicePath servicePath) {
        this.servicePath = servicePath;
    }

    public XRequestChangesSinceBuilder pagingInfo(Integer pageNumber, Integer pageSize) {
        this.pagingInfo = new PagingInfo(pageNumber, pageSize);
        return this;
    }

    public XRequestChangesSinceBuilder changesSince(LocalDateTime opaqueMarker) {
        this.changesSince = new ChangesSince(opaqueMarker);
        return this;
    }

    public XPressRequest build() throws InvalidPathException, MissingArgumentException, IllegalArgumentException {
        XPressRequest xPressRequest = new XPressRequest();
        xPressRequest.setServicePath(this.servicePath);
        xPressRequest.setPagingInfo(this.pagingInfo);
        xPressRequest.setChangesSince(this.changesSince);

        if(isInvalidPath(xPressRequest)) {
            List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
            throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
        }

        if(isMissingChangesSince(xPressRequest)) {
            throw new MissingArgumentException(servicePath + " requires the changesSince method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
        }

        return xPressRequest;
    }

    @Override
    boolean isInvalidPath(XPressRequest request) {
        return !request.containsRequestType(RequestType.CHANGES_SINCE);
    }

    @Override
    boolean isMissingChangesSince(XPressRequest request) {
        return !request.hasChangesSince();
    }
}