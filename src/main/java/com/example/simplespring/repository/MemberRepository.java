package com.example.simplespring.repository;

import com.example.simplespring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
