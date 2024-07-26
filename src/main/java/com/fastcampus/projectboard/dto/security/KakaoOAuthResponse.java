package com.fastcampus.projectboard.dto.security;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fastcampus.projectboard.dto.security.KakaoOAuthResponse.KaKaoAccount.Profile;

@SuppressWarnings("unchecked") // TODO: Map -> Object 변환 로직이 있어 제네릭 타입 캐스팅 문제를 무시한다. 더 좋은 방법이 있으면 변경
public record KakaoOAuthResponse(
        Long id,
        LocalDateTime connectedAt,
        Map<String, Object> properties,
        KaKaoAccount kaKaoAccount
) {
    public record KaKaoAccount(
            Boolean profileNicknameNeedsAgreement,
            Profile profile,
            Boolean hasEmail,
            Boolean emailNeedsAgreement,
            Boolean isEmailValid,
            Boolean isEmailVerified,
            String email
    ) {
        public record Profile(String nickname) {
            public static Profile from(Map<String, Object> attributes) {
                return new Profile(String.valueOf(attributes.get("nickname")));
            }
        }
    }

    public static KaKaoAccount from(Map<String, Object> attributes) {
        return new KaKaoAccount(
                Boolean.valueOf(String.valueOf(attributes.get("profile_nickname_needs_agreement"))),
                Profile.from((Map<String, Object>) attributes.get("profile")),
                Boolean.valueOf(String.valueOf(attributes.get("has_email"))),
                Boolean.valueOf(String.valueOf(attributes.get("email_needs_agreement"))),
                Boolean.valueOf(String.valueOf(attributes.get("is_email_valid"))),
                Boolean.valueOf(String.valueOf(attributes.get("is_email_verified"))),
                String.valueOf(attributes.get("email"))
        );
    }
}
