/*
 * RIC One File Bridge
 * Version: 1.0.0 Build 20170604-1
 * Copyright © 2017 New York State Education Department
 * Created At Northeastern Regional Information Center By Daniel Whitehouse
 */

package org.ricone.api.client.response.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"@refId", "name", "localId", "stateProvinceId", "otherIds", "sex", "email", "primaryAssignment", "otherAssignments"})
@JsonRootName(value = "xStaff")
public class XStaff {
    @JsonProperty("@refId")
    @JacksonXmlProperty(localName = "refId", isAttribute = true)
    private String refId;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("localId")
    private String localId;
    @JsonProperty("stateProvinceId")
    private String stateProvinceId;
    @JsonProperty("otherIds")
    private OtherIds otherIds;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("email")
    private Email email;
    @JsonProperty("primaryAssignment")
    private PrimaryAssignment primaryAssignment;
    @JsonProperty("otherAssignments")
    private OtherAssignments otherAssignments;
    @JsonProperty("appProvisioningInfo")
    private AppProvisioningInfo appProvisioningInfo;

    public XStaff() {
    }

    public XStaff(String refId, Name name, String localId, String stateProvinceId, OtherIds otherIds, String sex, Email email, PrimaryAssignment primaryAssignment, OtherAssignments otherAssignments) {
        super();
        this.refId = refId;
        this.name = name;
        this.localId = localId;
        this.stateProvinceId = stateProvinceId;
        this.otherIds = otherIds;
        this.sex = sex;
        this.email = email;
        this.primaryAssignment = primaryAssignment;
        this.otherAssignments = otherAssignments;
    }

    public XStaff(String refId, AppProvisioningInfo appProvisioningInfo) {
        super();
        this.refId = refId;
        this.appProvisioningInfo = appProvisioningInfo;
    }

    @JsonProperty("@refId")
    @JacksonXmlProperty(localName = "refId", isAttribute = true)
    public String getRefId() {
        return refId;
    }

    @JsonProperty("@refId")
    public void setRefId(String refId) {
        this.refId = refId;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("localId")
    public String getLocalId() {
        return localId;
    }

    @JsonProperty("localId")
    public void setLocalId(String localId) {
        this.localId = localId;
    }

    @JsonProperty("stateProvinceId")
    public String getStateProvinceId() {
        return stateProvinceId;
    }

    @JsonProperty("stateProvinceId")
    public void setStateProvinceId(String stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    @JsonProperty("otherIds")
    public OtherIds getOtherIds() {
        return otherIds;
    }

    @JsonProperty("otherIds")
    public void setOtherIds(OtherIds otherIds) {
        this.otherIds = otherIds;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonProperty("email")
    public Email getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(Email email) {
        this.email = email;
    }

    @JsonProperty("primaryAssignment")
    public PrimaryAssignment getPrimaryAssignment() {
        return primaryAssignment;
    }

    @JsonProperty("primaryAssignment")
    public void setPrimaryAssignment(PrimaryAssignment primaryAssignment) {
        this.primaryAssignment = primaryAssignment;
    }

    @JsonProperty("otherAssignments")
    public OtherAssignments getOtherAssignments() {
        return otherAssignments;
    }

    @JsonProperty("otherAssignments")
    public void setOtherAssignments(OtherAssignments otherAssignments) {
        this.otherAssignments = otherAssignments;
    }

    @JsonProperty("appProvisioningInfo")
    public AppProvisioningInfo getAppProvisioningInfo() {
        return appProvisioningInfo;
    }

    @JsonProperty("appProvisioningInfo")
    public void setAppProvisioningInfo(AppProvisioningInfo appProvisioningInfo) {
        this.appProvisioningInfo = appProvisioningInfo;
    }

    @Override
    public String toString() {
        return "XStaff{" + "refId='" + refId + '\'' + ", name=" + name + ", localId='" + localId + '\'' + ", stateProvinceId='" + stateProvinceId + '\'' + ", otherIds=" + otherIds + ", sex='" + sex + '\'' + ", email=" + email + ", primaryAssignment=" + primaryAssignment + ", otherAssignments=" + otherAssignments + '}';
    }
}