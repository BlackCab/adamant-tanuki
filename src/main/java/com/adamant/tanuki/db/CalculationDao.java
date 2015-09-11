package com.adamant.tanuki.db;

import com.adamant.tanuki.model.Member;
import com.adamant.tanuki.model.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by igor on 03.09.2015.
 */
public interface CalculationDao extends Repository<Result, Long> {
    void addMember(long member);

    Result addResult(long member1id, long member2id, String operation, double result);

    Result findResult(long member1, long member2, String operation);

    Member getMemberByValue(long value);

}
