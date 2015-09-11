package com.adamant.tanuki.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by igor on 03.09.2015.
 */
public enum Status {
    SUCCESS("Success", 1),
    NOT_FOUND("Result wasn't found", 2),
    ERROR("Something went wrong", 3);

    private String message;
    private int code;

    Status(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public int getCode() {
        return code;
    }
}
