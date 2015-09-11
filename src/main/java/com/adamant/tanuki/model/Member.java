package com.adamant.tanuki.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by igor on 06.09.2015.
 */
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "member_value")
    private long value;

    @JsonIgnore
    @OneToMany(mappedBy = "member1")
    private Set<Result> results1;

    @JsonIgnore
    @OneToMany(mappedBy = "member2")
    private Set<Result> results2;

    public Member() {
    }

    public Member(long id, long value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Set<Result> getResults1() {
        return results1;
    }

    public void setResults1(Set<Result> results1) {
        this.results1 = results1;
    }

    public Set<Result> getResults2() {
        return results2;
    }

    public void setResults2(Set<Result> results2) {
        this.results2 = results2;
    }
}
