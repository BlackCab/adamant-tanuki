package com.adamant.tanuki.model.operation;

import jersey.repackaged.com.google.common.base.Predicate;
import jersey.repackaged.com.google.common.collect.Collections2;
import jersey.repackaged.com.google.common.collect.Iterables;

import java.util.Arrays;

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

    public static OperationType getBySign(final String sign) {
        return Iterables.getOnlyElement(Collections2.filter(Arrays.asList(OperationType.values()), new Predicate<OperationType>() {
            @Override
            public boolean apply(OperationType input) {
                return input.getSign().equals(sign);
            }
        }));
    }
}
