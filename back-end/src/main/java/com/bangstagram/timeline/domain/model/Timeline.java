package com.bangstagram.timeline.domain.model;

import com.bangstagram.common.model.CommonEntity;
import com.bangstagram.user.domain.model.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

/**
 * author: Ji-Hoon Bae
 * Date: 2020.04.28
 */

@Entity
@Getter
public class Timeline extends CommonEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIMELINE_ID")
    private Long id;

    private String title;

    private String body;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private Long roomId;

    public Timeline() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    //public Timeline(String title, String body, Long userId, Long roomId) {
    public Timeline(String title, String body, User user, Long roomId) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.roomId = roomId;
    }

    public void update(String title, String body) {
        this.title = title;
        this.body = body;
    }
}