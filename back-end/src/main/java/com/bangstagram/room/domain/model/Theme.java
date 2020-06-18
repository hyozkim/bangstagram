package com.bangstagram.room.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Getter
public class Theme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEME_ID")
    private Long id;

    @Column(nullable = false)
    private String title;
    private String imgSrc;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    @JsonBackReference
    private Room room;

    public Theme() {
    }

    public void changeTheme(Room room) {
        this.room = room;
        room.getThemes().add(this);
    }

    @Builder
    public Theme(Long id, String title, String imgSrc, String description, String genre, Room room) {
        this.id = id;
        this.title = title;
        this.imgSrc = imgSrc;
        this.description = description;
        this.genre = genre;
        this.room = room;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("imgSrc", imgSrc)
                .append("description", description)
                .append("genre", genre)
                .append("room", room)
                .toString();
    }
}
