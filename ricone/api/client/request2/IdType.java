package org.ricone.api.client.request2;

public enum IdType {
    LOCAL("local"), BEDS("beds"), STATE("state"), REF_ID("refId");

    private final String value;

    public String getValue() {
        return value;
    }

    IdType(String value) {
        this.value = value;
    }
}