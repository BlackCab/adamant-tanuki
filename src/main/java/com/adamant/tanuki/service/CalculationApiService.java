package com.adamant.tanuki.service;

import com.adamant.tanuki.model.Result;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 05.09.2015.
 */
@Service
public class CalculationApiService {
    public Double getAggregatedResultFromAllApi(long first, long second, String operation) {
        return CalculationHelper.applyOperation(first, second, operation); // TODO perform requests to all APIs
    }

}
