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
public class XPressRequestAUPP extends XRequest {
    private ServicePath servicePath;
    private String refId;
    private PagingInfo pagingInfo;
    private AUPPType auppType;

    private XPressRequestAUPP() {
    }

    //GETTERS
    ServicePath getServicePath() {
        return servicePath;
    }

    String getRefId() {
        return refId;
    }

    PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    AUPPType getAuppType() {
        return auppType;
    }

    //BUILDER
    public static class Builder extends PathVerifier {
        private ServicePath servicePath;
        private String refId;
        private PagingInfo pagingInfo;
        private AUPPType auppType;

        public Builder(ServicePath servicePath) {
            this.servicePath = servicePath;
        }

        public Builder refId(String refId) {
            this.refId = refId;
            return this;
        }

        public Builder pagingInfo(Integer pageNumber, Integer pageSize) {
            this.pagingInfo = new PagingInfo(pageNumber, pageSize);
            return this;
        }

        public Builder auppType(AUPPType auppType) {
            this.auppType = auppType;
            return this;
        }

        public XPressRequestAUPP build() throws InvalidPathException, MissingArgumentException {
            if(isInvalidPath(this.servicePath)) {
                List<String> xPressRequestTypeValues = servicePath.getXPressRequestTypes().stream().map(RequestType::getValue).collect(Collectors.toList());
                throw new InvalidPathException(servicePath + " does not work with " + this.getClass().getCanonicalName() + ". Try a different ServicePath or use one of the following classes: " + String.join(", ", xPressRequestTypeValues));
            }

            if(isMissingId(this.servicePath)) {
                throw new MissingArgumentException(servicePath + " requires the refId method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
            }

            if(isMissingAUPPType(this.servicePath)) {
                throw new MissingArgumentException(servicePath + " requires the auppType method be set on " + this.getClass().getCanonicalName() + ". Set a value or try a different ServicePath.");
            }

            XPressRequestAUPP xPressRequest = new XPressRequestAUPP();
            xPressRequest.servicePath = this.servicePath;
            xPressRequest.refId = this.refId;
            xPressRequest.pagingInfo = this.pagingInfo;
            xPressRequest.auppType = this.auppType;
            return xPressRequest;
        }

        @Override
        boolean isInvalidPath(ServicePath path) {
            return !path.getXPressRequestTypes().contains(RequestType.AUPP);
        }

        @Override
        boolean isMissingId(ServicePath path) {
            return !path.getServicePathType().equals(ServicePathType.OBJECT) && !StringUtils.hasText(refId);
        }

        @Override
        boolean isMissingAUPPType(ServicePath path) {
            return auppType != null;
        }
    }

    //OVERRIDES
    @Override
    boolean hasId() {
        return StringUtils.hasText(refId);
    }

    @Override
    boolean hasAUPP() {
        return auppType != null;
    }

    @Override
    boolean hasPaging() {
        return pagingInfo != null;
    }

    @Override
    public String toString() {
        return "XPressRequestAUPP{" + "servicePath=" + servicePath + ", refId='" + refId + '\'' + ", pagingInfo=" + pagingInfo + ", auppType=" + auppType + '}';
    }
}
