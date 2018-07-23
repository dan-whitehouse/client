package org.ricone.api.client.request3;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public interface XRequest {
    ServicePath getServicePath();

    String getId();

    IdType getIdType();

    Integer getSchoolYear();

    PagingInfo getPagingInfo();

    AUPPType getAuppType();

    ChangesSince getChangesSince();

    boolean hasId();

    boolean hasIdType();

    boolean hasPaging();

    boolean hasSchoolYear();

    boolean hasAUPP();

    boolean hasChangesSince();

    boolean containsRequestType(RequestType requestType);

    boolean isServicePathType(ServicePathType servicePathType);
}
