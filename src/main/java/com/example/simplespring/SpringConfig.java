package com.example.simplespring;

import com.example.simplespring.repository.MemberRepository;
import com.example.simplespring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /* JPA Data 에서는 필요 없는 물건입니다...
    @Bean
    public MemberRepository memberRepository() {
        // 메모리에 저장
        // return new MemoryMemberRepository();

        // h2 database 에 저장 (고전적 방법)
        // return new JdbcMemberRepository(dataSource);

        // h2 database 에 저장 (템플릿 사용)
        // return new JdbcTemplateMemberRepository(dataSource);

        // JPA 사용
        // return new JpaMemberRepository(em);
    }
     */
}
