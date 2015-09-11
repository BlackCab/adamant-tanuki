package com.adamant.tanuki.controller;

import com.adamant.tanuki.db.CalculationDao;
import com.adamant.tanuki.response.ResultResponse;
import com.adamant.tanuki.response.Status;
import com.adamant.tanuki.model.Result;
import com.adamant.tanuki.service.CalculationApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by ishulyak on 10.09.2015.
 */
@RestController
public class CalculationController {
    @Autowired
    private CalculationDao calculationDao;

    @Autowired
    private CalculationApiService calculationApiService;

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ResultResponse getResult(@RequestParam("first") Long first,
                                    @RequestParam("second") Long second,
                                    @RequestParam("operation") String operation) {
        Result result = calculationDao.findResult(first, second, operation);
        if (result == null) {
            double resultValue = calculationApiService.getAggregatedResultFromAllApi(first, second, operation);
            calculationDao.addMember(first);
            calculationDao.addMember(second);
            result = calculationDao.addResult(first, second, operation, resultValue);
        }

        return new ResultResponse(Status.SUCCESS, result, "Скалькулировано!");
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    public void setCalculationCalculationDao(CalculationDao calculationDao) {
        this.calculationDao = calculationDao;
    }

    public void setCalculationApiService(CalculationApiService calculationApiService) {
        this.calculationApiService = calculationApiService;
    }
}
