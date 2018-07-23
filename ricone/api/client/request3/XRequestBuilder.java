package org.ricone.api.client.request3;

import org.ricone.api.client.request3.exception.InvalidPathException;
import org.ricone.api.client.request3.exception.MissingArgumentException;

import java.util.List;
import java.util.stream.Collectors;

public class XRequestBuilder extends PathVerifier {
    private ServicePath servicePath;
    private String id;
    private Integer schoolYear;
    private PagingInfo pagingInfo;

    public XRequestBuilder(ServicePath servicePath) {
        this.servicePath = servicePath;
    }

    public XRequestBuilder id(String id) {
        this.id = id;
        return this;
    }

    public XRequestBuilder schoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
        return this;
    }

    public XRequestBuilder pagingInfo(Integer pageNumber, Integer pageSize) {
        this.pagingInfo = new PagingInfo(pageNumber, pageSize);
        return this;
    }

    public XPressRequest build() throws InvalidPathException, MissingArgumentException, IllegalArgumentException {
        XPressRequest xPressRequest = new XPressRequest();
        xPressRequest.setServicePath(this.servicePath);
        xPressRequest.setPagingInfo(this.pagingInfo);
        xPressRequest.setId(this.id);
        xPressRequest.setSchoolYear(this.schoolYear);

        if(isInvalidPath(xPressRequest)) {
            List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
            throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
        }

        if(isMissingId(xPressRequest)) {
            throw new MissingArgumentException(servicePath + " requires the refId method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
        }

        return xPressRequest;
    }

    @Override
    boolean isInvalidPath(XPressRequest request) {
        return !request.containsRequestType(RequestType.BASIC);
    }

    @Override
    boolean isMissingId(XPressRequest request) {
        return !request.isServicePathType(ServicePathType.OBJECT) && !request.hasId();
    }
}