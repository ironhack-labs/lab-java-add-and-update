package com.ironhack.addupdate.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    OFF,
    ON,
    ON_CALL;

    @JsonCreator
    public static Status fromString(String valueFromBody) {
        return Status.valueOf(valueFromBody.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}
