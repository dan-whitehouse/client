package org.ricone.api.client.request2;

import org.ricone.api.client.request2.exception.InvalidPathException;
import org.ricone.api.client.request2.exception.MissingArgumentException;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class XRequestBuilder {
    private ServicePath servicePath;
    private String id;
    private IdType idType;
    private Integer schoolYear;
    private PagingInfo pagingInfo;
    private AUPPType auppType;
    private ChangesSince changesSince;

    public XRequestBuilder(ServicePath servicePath) {
        this.servicePath = servicePath;
    }

    public XRequestBuilder id(String id) {
        this.id = id;
        return this;
    }

    public XRequestBuilder idType(IdType idType) {
        this.idType = idType;
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

    public XRequestBuilder auppType(AUPPType auppType) {
        this.auppType = auppType;
        return this;
    }

    public XRequestBuilder changesSince(LocalDateTime opaqueMarker) {
        this.changesSince = new ChangesSince(opaqueMarker);
        return this;
    }

    public XPressRequest build() throws InvalidPathException, MissingArgumentException, IllegalArgumentException {
        if(servicePath.getXPressRequestTypes().contains(RequestType.BASIC)) {
            if(servicePath.getServicePathType().equals(ServicePathType.OBJECT)) {
                if(hasId()) {
                    throw new IllegalArgumentException(servicePath + " requires the id method not be set.");
                }
                if(hasIdType()) {
                    throw new IllegalArgumentException(servicePath + " requires the idType method not be set.");
                }
                if(hasChangesSince()) {
                    throw new IllegalArgumentException(servicePath + " requires the changesSince method not be set.");
                }
                if(hasAUPP()) {
                    throw new IllegalArgumentException(servicePath + " requires the auppType method not be set.");
                }
            }
            else {
                if(!hasId()) {
                    throw new MissingArgumentException(servicePath + " requires the id method be set.");
                }
                if(!hasIdType() || !getIdType().equals(IdType.REF_ID)) {
                    throw new MissingArgumentException(servicePath + " requires the idType method be set, and with a value of REF_ID.");
                }
                if(hasChangesSince()) {
                    throw new IllegalArgumentException(servicePath + " requires the changesSince method not be set.");
                }
                if(hasAUPP()) {
                    throw new IllegalArgumentException(servicePath + " requires the auppType method not be set.");
                }
            }
        }
        else if(servicePath.getXPressRequestTypes().contains(RequestType.ID)) {
            if(!hasId()) {
                throw new MissingArgumentException(servicePath + " requires the id method be set.");
            }
            if(!hasIdType() || getIdType().equals(IdType.REF_ID)) {
                List<IdType> idTypes = List.of(IdType.values()).stream().filter(idType -> !idType.equals(IdType.REF_ID)).collect(Collectors.toList());
                throw new MissingArgumentException(servicePath + " requires the idType method be set, and with one of these values: " + idTypes);
            }
            if(hasChangesSince()) {
                throw new IllegalArgumentException(servicePath + " requires the changesSince method not be set.");
            }
            if(hasAUPP()) {
                throw new IllegalArgumentException(servicePath + " requires the auppType method not be set.");
            }
        }
        else if(servicePath.getXPressRequestTypes().contains(RequestType.CHANGES_SINCE)) {
            if(!hasChangesSince()) {
                throw new MissingArgumentException(servicePath + " requires the changesSince method be set.");
            }
            if(hasId()) {
                throw new IllegalArgumentException(servicePath + " requires the id method not be set.");
            }
            if(hasIdType() || !getIdType().equals(IdType.REF_ID)) {
                throw new MissingArgumentException(servicePath + " requires the idType method be set, and with a value of REF_ID.");
            }
            if(hasSchoolYear()) {
                throw new IllegalArgumentException(servicePath + " requires the schoolYear method not be set.");
            }
            if(hasAUPP()) {
                throw new IllegalArgumentException(servicePath + " requires the auppType method not be set.");
            }
        }
        else if(servicePath.getXPressRequestTypes().contains(RequestType.AUPP)) {
            if(!hasId()) {
                throw new MissingArgumentException(servicePath + " requires the id method be set.");
            }
            if(!hasIdType() || !getIdType().equals(IdType.REF_ID)) {
                throw new MissingArgumentException(servicePath + " requires the idType method be set, and with a value of REF_ID.");
            }
            if(!hasAUPP()) {
                throw new MissingArgumentException(servicePath + " requires the auppType method be set.");
            }
            if(hasSchoolYear()) {
                throw new IllegalArgumentException(servicePath + " requires the schoolYear method not be set.");
            }
            if(hasChangesSince()) {
                throw new IllegalArgumentException(servicePath + " requires the changesSince method not be set.");
            }
        }

        XPressRequest xPressRequest = new XPressRequest();
        xPressRequest.setServicePath(this.servicePath);
        xPressRequest.setPagingInfo(this.pagingInfo);
        xPressRequest.setId(this.id);
        xPressRequest.setIdType(this.idType);
        xPressRequest.setSchoolYear(this.schoolYear);
        xPressRequest.setAuppType(this.auppType);
        xPressRequest.setChangesSince(this.changesSince);
        return xPressRequest;
    }

    private ServicePath getServicePath() {
        return servicePath;
    }

    private String getId() {
        return id;
    }

    private IdType getIdType() {
        return idType;
    }

    private Integer getSchoolYear() {
        return schoolYear;
    }

    private PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    private AUPPType getAuppType() {
        return auppType;
    }

    private ChangesSince getChangesSince() {
        return changesSince;
    }

    private boolean hasId() {
        return StringUtils.hasText(id);
    }

    private boolean hasIdType() {
        return idType != null;
    }

    private boolean hasSchoolYear() {
        return schoolYear != null;
    }

    private boolean hasPaging() {
        return pagingInfo != null;
    }

    private boolean hasAUPP() {
        return auppType != null;
    }

    private boolean hasChangesSince() {
        return changesSince != null;
    }
}