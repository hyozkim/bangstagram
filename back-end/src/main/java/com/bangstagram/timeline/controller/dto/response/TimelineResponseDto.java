package com.bangstagram.timeline.controller.dto.response;

import com.bangstagram.user.domain.model.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * author: Ji-Hoon Bae
 * Date: 2020.04.28
 */

@Getter
public class TimelineResponseDto {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private User user;
    private Long roomId;

    public TimelineResponseDto() {
    }

    @Builder
    public TimelineResponseDto(Long id, String title, String body, LocalDateTime createdAt, User user, Long roomId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "TimelineResponseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", roomId=" + roomId +
                '}';
    }
}
