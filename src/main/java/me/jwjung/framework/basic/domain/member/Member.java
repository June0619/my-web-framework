package me.jwjung.framework.basic.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {

    private long id;
    private String name;
    private int age;

    private Member() {};

    public Member(long id, Member member) {
        this.id = id;
        this.name = member.name;
        this.age = member.age;
    }

}
