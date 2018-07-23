package org.ricone.api.client.request3;

import org.springframework.util.StringUtils;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
class XPressRequest implements XRequest {
    private ServicePath servicePath;
    private String id;
    private IdType idType;
    private Integer schoolYear;
    private PagingInfo pagingInfo;
    private AUPPType auppType;
    private ChangesSince changesSince;

    XPressRequest() {
    }

    public void setServicePath(ServicePath servicePath) {
        this.servicePath = servicePath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

    public void setAuppType(AUPPType auppType) {
        this.auppType = auppType;
    }

    public void setChangesSince(ChangesSince changesSince) {
        this.changesSince = changesSince;
    }

    @Override
    public ServicePath getServicePath() {
        return this.servicePath;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public IdType getIdType() {
        return this.idType;
    }

    @Override
    public Integer getSchoolYear() {
        return this.schoolYear;
    }

    @Override
    public PagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    @Override
    public AUPPType getAuppType() {
        return this.auppType;
    }

    @Override
    public ChangesSince getChangesSince() {
        return this.changesSince;
    }

    @Override
    public boolean hasId() {
        return StringUtils.hasText(id);
    }

    @Override
    public boolean hasIdType() {
        return idType != null;
    }

    @Override
    public boolean hasPaging() {
        return pagingInfo != null;
    }

    @Override
    public boolean hasSchoolYear() {
        return schoolYear != null;
    }

    @Override
    public boolean hasAUPP() {
        return auppType != null;
    }

    @Override
    public boolean hasChangesSince() {
        return changesSince != null;
    }

    @Override
    public boolean containsRequestType(RequestType requestType) {
        return servicePath.getXPressRequestTypes().contains(requestType);
    }

    @Override
    public boolean isServicePathType(ServicePathType servicePathType) {
        return servicePath.getServicePathType().equals(servicePathType);
    }
}
