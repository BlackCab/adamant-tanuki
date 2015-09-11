package com.adamant.tanuki.service;

import com.adamant.tanuki.model.operation.OperationType;

import static com.adamant.tanuki.model.operation.OperationType.getBySign;

/**
 * Created by igor on 08.09.2015.
 */
public class CalculationHelper {
    public static double applyOperation(long first, long second, String operation) {
        return getBySign(operation).get().getOperation().apply(first, second);
    }

}
