package org.ricone.api.client.request;

public enum IdType {
    LOCAL("local"), BEDS("beds"), STATE("state");

    private final String value;

    public String getValue() {
        return value;
    }

    IdType(String value) {
        this.value = value;
    }
}