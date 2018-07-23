package org.ricone.api.client.request2;

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

    //GETTERS
    public ServicePath getServicePath() {
        return servicePath;
    }

    public String getId() {
        return id;
    }

    public IdType getIdType() {
        return idType;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    public AUPPType getAuppType() {
        return auppType;
    }

    public ChangesSince getChangesSince() {
        return changesSince;
    }

    //SETTERS
    void setServicePath(ServicePath servicePath) {
        this.servicePath = servicePath;
    }

    void setId(String id) {
        this.id = id;
    }

    void setIdType(IdType idType) {
        this.idType = idType;
    }

    void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

    void setAuppType(AUPPType auppType) {
        this.auppType = auppType;
    }

    void setChangesSince(ChangesSince changesSince) {
        this.changesSince = changesSince;
    }

    //OVERRIDES
    @Override
    public boolean hasId() {
        return StringUtils.hasText(id);
    }

    @Override
    public boolean hasIdType() {
        return idType != null;
    }

    @Override
    public boolean hasSchoolYear() {
        return schoolYear != null;
    }

    @Override
    public boolean hasPaging() {
        return pagingInfo != null;
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
    public String toString() {
        return "_XPressRequest{" + "servicePath=" + servicePath + ", id='" + id + '\'' + ", idType=" + idType + ", schoolYear=" + schoolYear + ", pagingInfo=" + pagingInfo + ", auppType=" + auppType + ", changesSince=" + changesSince + '}';
    }
}
