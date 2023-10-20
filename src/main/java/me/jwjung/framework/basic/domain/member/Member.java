package me.jwjung.framework.basic.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Member {

    private long id;
    private String name;
    private int age;

    private Member() {};

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
