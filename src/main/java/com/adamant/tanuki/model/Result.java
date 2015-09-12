package com.adamant.tanuki.model;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;

/**
 * Created by igor on 05.09.2015.
 */
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findResult",
                query = "SELECT * FROM results r WHERE r.member_1_id = (SELECT m.id FROM members m WHERE m.member_value = :first) AND r.member_2_id = (SELECT m.id FROM members m WHERE m.member_value = :second) AND r.operation=:operation",
                resultClass = Result.class
        )
})
@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_1_id")
    private Member member1;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "member_2_id")
    private Member member2;

    @Column(name = "operation")
    private String operation;

    @Column(name = "result")
    private Double result;

    public Result() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Member getMember1() {
        return member1;
    }

    public void setMember1(Member member1) {
        this.member1 = member1;
    }

    public Member getMember2() {
        return member2;
    }

    public void setMember2(Member member2) {
        this.member2 = member2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

}
