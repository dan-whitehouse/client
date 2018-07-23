package org.ricone.api.client.response.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"phoneNumberType", "number", "primaryIndicator"})
public class PhoneNumber {

    @JsonProperty("phoneNumberType")
    private String phoneNumberType;
    @JsonProperty("number")
    private String number;
    @JsonProperty("primaryIndicator")
    private String primaryIndicator;

    public PhoneNumber() {
    }

    public PhoneNumber(String phoneNumberType, String number, String primaryIndicator) {
        super();
        this.phoneNumberType = phoneNumberType;
        this.number = number;
        this.primaryIndicator = primaryIndicator;
    }

    @JsonProperty("phoneNumberType")
    public String getPhoneNumberType() {
        return phoneNumberType;
    }

    @JsonProperty("phoneNumberType")
    public void setPhoneNumberType(String phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("primaryIndicator")
    public String getPrimaryIndicator() {
        return primaryIndicator;
    }

    @JsonProperty("primaryIndicator")
    public void setPrimaryIndicator(String primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" + "phoneNumberType='" + phoneNumberType + '\'' + ", number='" + number + '\'' + ", primaryIndicator='" + primaryIndicator + '\'' + '}';
    }
}