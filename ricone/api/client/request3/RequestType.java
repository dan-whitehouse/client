package org.ricone.api.client.request3;

public enum RequestType {
    BASIC("XPressRequest"), ID("XPressRequestID"), CHANGES_SINCE("XPressRequestChangesSince"), AUPP("XPressRequestAUPP");

    private final String value;

    public String getValue() {
        return value;
    }

    RequestType(String value) {
        this.value = value;
    }
}