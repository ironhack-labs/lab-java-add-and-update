package com.ironhack.addupdate.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Department {
    CARDIOLOGY,
    IMMUNOLOGY,
    ORTHOPAEDIC,
    PULMONARY,
    PSYCHIATRIC;

    // Personalizo la deserialización
    //@JsonCreator le indica a Jackson
    // cómo transformar el texto del JSON (aunque venga en minúsculas)
    // al enum correspondiente.
    //Jackson (la librería que convierte JSON a Java)
    @JsonCreator
    public static Department fromString(String valueFromBody) {
        return Department.valueOf(valueFromBody.toUpperCase());
    }

    @JsonValue //personalizo la serialización
    public String toJson() {
        return this.name().toLowerCase();
    }
}
