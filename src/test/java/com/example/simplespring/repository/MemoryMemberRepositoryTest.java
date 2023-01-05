package com.example.simplespring.repository;

import com.example.simplespring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        var member = new Member();
        member.setName("Spring");

        repository.save(member);

        var result = repository.findById(member.getId()).get();
        assertEquals(member, result);
    }

    @Test
    void findByName() {
        var member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        var member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        var result = repository.findByName("Spring1").get();
        assertEquals(member1, result);
    }

    @Test
    void findAll() {
        var member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        var member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        var result = repository.findAll();
        assertEquals(2, result.size());
    }
}
