package org.ricone.api.client.request;

import org.ricone.api.client.request.exception.InvalidPathException;
import org.ricone.api.client.request.exception.MissingArgumentException;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class XPressRequestID extends XRequest {
    private ServicePath servicePath;
    private String id;
    private IdType idType;
    private Integer schoolYear;
    private PagingInfo pagingInfo;

    private XPressRequestID() {
    }

    //GETTERS
    ServicePath getServicePath() {
        return servicePath;
    }

    String getId() {
        return id;
    }

    IdType getIdType() {
        return idType;
    }

    Integer getSchoolYear() {
        return schoolYear;
    }

    PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    //BUILDER
    public static class Builder extends PathVerifier {
        private ServicePath servicePath;
        private String id;
        private IdType idType;
        private Integer schoolYear;
        private PagingInfo pagingInfo;

        public Builder(ServicePath servicePath) {
            this.servicePath = servicePath;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder idType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public Builder schoolYear(int schoolYear) {
            this.schoolYear = schoolYear;
            return this;
        }

        public Builder pagingInfo(Integer pageNumber, Integer pageSize) {
            this.pagingInfo = new PagingInfo(pageNumber, pageSize);
            return this;
        }

        public XPressRequestID build() throws InvalidPathException, MissingArgumentException {
            if(isInvalidPath(this.servicePath)) {
                List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
                throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
            }

            if(isMissingId(this.servicePath)) {
                throw new MissingArgumentException(servicePath + " requires the id method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
            }

            if(isMissingIdType(this.servicePath)) {
                throw new MissingArgumentException(servicePath + " requires the idType method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
            }

            XPressRequestID xPressRequest = new XPressRequestID();
            xPressRequest.servicePath = this.servicePath;
            xPressRequest.pagingInfo = this.pagingInfo;
            xPressRequest.id = this.id;
            xPressRequest.idType = this.idType;
            xPressRequest.schoolYear = this.schoolYear;
            return xPressRequest;
        }

        @Override
        boolean isInvalidPath(ServicePath path) {
            return !path.getXPressRequestTypes().contains(RequestType.ID);
        }

        @Override
        boolean isMissingId(ServicePath path) {
            return !path.getServicePathType().equals(ServicePathType.OBJECT) && !StringUtils.hasText(id);
        }

        @Override
        boolean isMissingIdType(ServicePath path) {
            return idType == null;
        }
    }

    //OVERRIDES
    @Override
    boolean hasId() {
        return StringUtils.hasText(id);
    }

    boolean hasIdType() {
        return idType != null;
    }

    @Override
    boolean hasSchoolYear() {
        return schoolYear != null;
    }

    @Override
    boolean hasPaging() {
        return pagingInfo != null;
    }

    @Override
    public String toString() {
        return "XPressRequest{" + "servicePath=" + servicePath + ", id='" + id + '\'' + ", idType=" + idType + ", schoolYear=" + schoolYear + ", pagingInfo=" + pagingInfo + '}';
    }
}
