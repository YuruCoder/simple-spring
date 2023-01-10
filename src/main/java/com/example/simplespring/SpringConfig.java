package com.example.simplespring;

import com.example.simplespring.repository.JdbcTemplateMemberRepository;
import com.example.simplespring.repository.MemberRepository;
import com.example.simplespring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // 메모리에 저장
        // return new MemoryMemberRepository();

        // h2 database 에 저장 (고전적 방법)
        // return new JdbcMemberRepository(dataSource);

        return new JdbcTemplateMemberRepository(dataSource);
    }
}
