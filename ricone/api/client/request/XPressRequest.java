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
public class XPressRequest extends XRequest {
    private ServicePath servicePath;
    private String refId;
    private Integer schoolYear;
    private PagingInfo pagingInfo;

    private XPressRequest() {
    }

    //GETTERS
    ServicePath getServicePath() {
        return servicePath;
    }

    String getRefId() {
        return refId;
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
        private String refId;
        private Integer schoolYear;
        private PagingInfo pagingInfo;

        public Builder(ServicePath servicePath) {
            this.servicePath = servicePath;
        }

        public Builder refId(String refId) {
            this.refId = refId;
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

        public XPressRequest build() throws InvalidPathException, MissingArgumentException {
            if(isInvalidPath(this.servicePath)) {
                List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
                throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
            }

            if(isMissingId(this.servicePath)) {
                throw new MissingArgumentException(servicePath + " requires the refId method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
            }

            XPressRequest xPressRequest = new XPressRequest();
            xPressRequest.servicePath = this.servicePath;
            xPressRequest.pagingInfo = this.pagingInfo;
            xPressRequest.refId = this.refId;
            xPressRequest.schoolYear = this.schoolYear;
            return xPressRequest;
        }

        @Override
        public boolean isInvalidPath(ServicePath path) {
            return !path.getXPressRequestTypes().contains(RequestType.BASIC);
        }

        @Override
        public boolean isMissingId(ServicePath path) {
            return !path.getServicePathType().equals(ServicePathType.OBJECT) && !StringUtils.hasText(refId);
        }
    }

    //OVERRIDES
    @Override
    boolean hasId() {
        return StringUtils.hasText(refId);
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
        return "XPressRequest{" + "servicePath=" + servicePath + ", refId='" + refId + '\'' + ", schoolYear=" + schoolYear + ", pagingInfo=" + pagingInfo + '}';
    }
}
