package com.adamant.tanuki.model.operation;

/**
 * Created by igor on 08.09.2015.
 */
public class Sum implements Operation{

    @Override
    public double apply(long first, long second) {
        return first + second;
    }
}
