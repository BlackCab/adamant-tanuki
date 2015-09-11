package com.adamant.tanuki.db;

import com.adamant.tanuki.model.Member;
import com.adamant.tanuki.model.Result;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by igor on 06.09.2015.
 */
@Repository
public class CalculationDaoImpl implements CalculationDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addMember(long member) {
        Member memberModel = getMemberByValue(member);
        if (memberModel != null) {
            return;
        }

        memberModel = new Member();
        memberModel.setValue(member);

        persist(memberModel);
    }

    @Override
    @Transactional
    public Result addResult(long first, long second, String operation, double result) {
        Result resultModel = new Result();

        Member firstMember = getMemberByValue(first);
        firstMember.setValue(first);
        Member secondMember = getMemberByValue(second);
        firstMember.setValue(second);

        resultModel.setMember1(firstMember);
        resultModel.setMember2(secondMember);
        resultModel.setOperation(operation);
        resultModel.setResult(result);

        persist(resultModel);

        return resultModel;
    }

    @Override
    @Transactional
    public Result findResult(long member1, long member2, String operation) {
        Query query = sessionFactory.openSession().getNamedQuery("findResult")
                .setLong("first", member1)
                .setLong("second", member2)
                .setString("operation", operation);
        List<Result> resultList = ((List<Result>) query.list());
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public Member getMemberByValue(long value) {
        Session session = sessionFactory.openSession();
        Member member = (Member) session
                .createQuery("from Member as m where m.value=:value")
                .setParameter("value", value)
                .uniqueResult();
        session.close();
        return member;
    }

    private void persist(Object object) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
        session.close();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
