package com.adamant.tanuki.model.operation;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by igor on 06.09.2015.
 */
public enum OperationType {
    ADD("+", new Sum()),
    SUBTRACT("-", new Subtraction()),
    MULTIPLY("*", new Multiplication()),
    DIVIDE("/", new Division());

    private String sign;
    private Operation operation;

    OperationType(String sign, Operation operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public String getSign() {
        return sign;
    }

    public Operation getOperation() {
        return operation;
    }

    public static Optional<OperationType> getBySign(String sign) {
        return Arrays.asList(OperationType.values()).stream().filter(o -> o.getSign().equals(sign)).findFirst();
    }
}
