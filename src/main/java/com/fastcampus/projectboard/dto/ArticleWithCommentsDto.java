package com.fastcampus.projectboard.dto;

import java.time.LocalDateTime;

public record ArticleWithCommentsDto(
        Long id,
        UserAccountDto userAccountDto,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {


}
