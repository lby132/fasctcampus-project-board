package com.fastcampus.projectboard.config;

import com.fastcampus.projectboard.dto.security.BoardPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext()) // 시큐리티에 담긴 정보를 getContext()로 불러온다. SecurityContextHolder 는 시큐리티의 모든 정보를 들고 있는 클래스이다.
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated) // 로그인을한 상태인지 확인
                .map(Authentication::getPrincipal) // 로그인 정보를 꺼내옴
                .map(BoardPrincipal.class::cast)
                .map(BoardPrincipal::getUsername);
    }
}
