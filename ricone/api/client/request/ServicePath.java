package org.ricone.api.client.request;

import java.util.List;

public enum ServicePath {
    GET_XLEA_BY_REFID("xLeas/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XLEA_BY_ID("xLeas/{id}", ServicePathType.SINGLE, List.of(RequestType.ID)), GET_XLEAS("xLeas", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XLEAS_BY_XSCHOOL_REFID("xSchools/{refId}/xLeas", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XLEAS_BY_XROSTER_REFID("xRosters/{refId}/xLeas", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XLEAS_BY_XSTAFF_REFID("xStaffs/{refId}/xLeas", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XLEAS_BY_XSTUDENT_REFID("xStudents/{refId}/xLeas", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XLEAS_BY_XCONTACT_REFID("xContacts/{refId}/xLeas", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XSCHOOL_BY_REFID("xSchools/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XSCHOOL_BY_ID("xSchools/{id}", ServicePathType.SINGLE, List.of(RequestType.ID)), GET_XSCHOOLS("xSchools", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XSCHOOLS_BY_XLEA_REFID("xLeas/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSCHOOLS_BY_XCALENDAR_REFID("xCalendars/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSCHOOLS_BY_XCOURSE_REFID("xCourses/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSCHOOLS_BY_XROSTER_REFID("xRosters/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSCHOOLS_BY_XSTAFF_REFID("xStaffs/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSCHOOLS_BY_XSTUDENT_REFID("xStudents/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSCHOOLS_BY_XCONTACT_REFID("xContacts/{refId}/xSchools", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XCALENDAR_BY_REFID("xCalendars/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XCALENDARS("xCalendars", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XCALENDARS_BY_XLEA_REFID("xLeas/{refId}/xCalendars", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XCALENDARS_BY_XSCHOOL_REFID("xSchools/{refId}/xCalendars", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XCOURSE_BY_REFID("xCourses/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XCOURSES("xCourses", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XCOURSES_BY_XLEA_REFID("xLeas/{refId}/xCourses", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XCOURSES_BY_XSCHOOL_REFID("xSchools/{refId}/xCourses", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XCOURSES_BY_XROSTER_REFID("xRosters/{refId}/xCourses", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XROSTER_BY_REFID("xRosters/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XROSTERS("xRosters", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XROSTERS_BY_XLEA_REFID("xLeas/{refId}/xRosters", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XROSTERS_BY_XSCHOOL_REFID("xSchools/{refId}/xRosters", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XROSTERS_BY_XCOURSE_REFID("xCourses/{refId}/xRosters", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XROSTERS_BY_XSTAFF_REFID("xStaffs/{refId}/xRosters", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XROSTERS_BY_XSTUDENT_REFID("xStudents/{refId}/xRosters", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XSTAFF_BY_REFID("xStaffs/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XSTAFF_BY_ID("xStaffs/{id}", ServicePathType.SINGLE, List.of(RequestType.ID)), GET_XSTAFFS("xStaffs", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XSTAFFS_BY_XLEA_REFID("xLeas/{refId}/xStaffs", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSTAFFS_BY_XSCHOOL_REFID("xSchools/{refId}/xStaffs", ServicePathType.PREDICATE, List.of(RequestType.BASIC, RequestType.AUPP)), GET_XSTAFFS_BY_XCOURSE_REFID("xCourses/{refId}/xStaffs", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSTAFFS_BY_XROSTER_REFID("xRosters/{refId}/xStaffs", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSTAFFS_BY_XSTUDENT_REFID("xStudents/{refId}/xStaffs", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XSTUDENT_BY_REFID("xStudents/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XSTUDENT_BY_ID("xStudents/{id}", ServicePathType.SINGLE, List.of(RequestType.ID)), GET_XSTUDENTS("xStudents", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XSTUDENTS_BY_XLEA_REFID("xLeas/{refId}/xStudents", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSTUDENTS_BY_XSCHOOL_REFID("xSchools/{refId}/xStudents", ServicePathType.PREDICATE, List.of(RequestType.BASIC, RequestType.AUPP)), GET_XSTUDENTS_BY_XROSTER_REFID("xRosters/{refId}/xStudents", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSTUDENTS_BY_XSTAFF_REFID("xStaffs/{refId}/xStudents", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XSTUDENTS_BY_XCONTACT_REFID("xContacts/{refId}/xStudents", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), //----
    GET_XCONTACT_BY_REFID("xContacts/{refId}", ServicePathType.SINGLE, List.of(RequestType.BASIC)), GET_XCONTACTS("xContacts", ServicePathType.OBJECT, List.of(RequestType.BASIC, RequestType.CHANGES_SINCE)), GET_XCONTACTS_BY_XLEA_REFID("xLeas/{refId}/xContacts", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XCONTACTS_BY_XSCHOOL_REFID("xSchools/{refId}/xContacts", ServicePathType.PREDICATE, List.of(RequestType.BASIC)), GET_XCONTACTS_BY_XSTUDENT_REFID("xStudents/{refId}/xContacts", ServicePathType.PREDICATE, List.of(RequestType.BASIC));

    private final String value;
    private ServicePathType servicePathType;
    private List<RequestType> requestTypes;

    ServicePath(String value, ServicePathType servicePathType, List<RequestType> requestTypes) {
        this.value = value;
        this.servicePathType = servicePathType;
        this.requestTypes = requestTypes;
    }

    public String getValue() {
        return value;
    }

    public ServicePathType getServicePathType() {
        return servicePathType;
    }

    public List<RequestType> getXPressRequestTypes() {
        return requestTypes;
    }
}