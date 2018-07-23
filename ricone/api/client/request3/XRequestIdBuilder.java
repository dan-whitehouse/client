package org.ricone.api.client.request3;

import org.ricone.api.client.request3.exception.InvalidPathException;
import org.ricone.api.client.request3.exception.MissingArgumentException;

import java.util.List;
import java.util.stream.Collectors;

public class XRequestIdBuilder extends PathVerifier {
    private ServicePath servicePath;
    private String id;
    private IdType idType;
    private Integer schoolYear;

    public XRequestIdBuilder(ServicePath servicePath) {
        this.servicePath = servicePath;
    }

    public XRequestIdBuilder id(String id) {
        this.id = id;
        return this;
    }

    public XRequestIdBuilder schoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
        return this;
    }

    public XRequestIdBuilder idType(IdType idType) {
        this.idType = idType;
        return this;
    }

    public XPressRequest build() throws InvalidPathException, MissingArgumentException, IllegalArgumentException {
        XPressRequest xPressRequest = new XPressRequest();
        xPressRequest.setServicePath(this.servicePath);
        xPressRequest.setId(this.id);
        xPressRequest.setIdType(this.idType);
        xPressRequest.setSchoolYear(this.schoolYear);

        if(isInvalidPath(xPressRequest)) {
            List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
            throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
        }

        if(isMissingId(xPressRequest)) {
            throw new MissingArgumentException(servicePath + " requires the id method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
        }

        if(isMissingIdType(xPressRequest)) {
            throw new MissingArgumentException(servicePath + " requires the idType method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
        }

        return xPressRequest;
    }

    @Override
    boolean isInvalidPath(XPressRequest request) {
        return !request.containsRequestType(RequestType.ID);
    }

    @Override
    boolean isMissingId(XPressRequest request) {
        return !request.isServicePathType(ServicePathType.OBJECT) && !request.hasId();
    }

    @Override
    boolean isMissingIdType(XPressRequest request) {
        return !request.hasIdType();
    }
}