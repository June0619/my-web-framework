package me.jwjung.framework.basic.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("member", 20);
        //when
        memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll() {
        //given
        Member memberA = new Member("memberA", 10);
        Member memberB = new Member("memberB", 20);
        //when
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        List<Member> findMembers = memberRepository.findAll();
        //then
        assertThat(findMembers.size()).isEqualTo(2);
        assertThat(findMembers).contains(memberA, memberB);
    }
}