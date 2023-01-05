package com.example.simplespring.service;

import com.example.simplespring.domain.Member;
import com.example.simplespring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        var member = new Member();
        member.setName("spring");

        // when
        var saveId = memberService.join(member);

        // then
        var findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        // given
        var member1 = new Member();
        member1.setName("spring");
        var member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        var e = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        // then
        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}