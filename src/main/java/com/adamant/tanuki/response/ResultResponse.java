package com.adamant.tanuki.response;

import com.adamant.tanuki.model.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by igor on 03.09.2015.
 */

public class ResultResponse {
    private Status status;
    private Result result;
    private String message;

    public ResultResponse(Status status, Result result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    @JsonProperty
    public Status getStatus() {
        return status;
    }

    @JsonProperty
    public Result getResult() {
        return result;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
