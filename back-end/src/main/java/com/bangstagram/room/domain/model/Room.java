package com.bangstagram.room.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Getter
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String link;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String phone;

    private String address;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    @JsonManagedReference // to solve 순환 참조 해결
    private List<Theme> themes = new ArrayList<>();

    public Room() {
    }

    @Builder
    public Room(Long id, String title, String link, String description, String phone, String address, List<Theme> themes) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.themes = themes;
    }

    public void update(String title, String link, String phone, String address, String description) {
        this.title = title;
        this.link = link;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }
/*
    public void addTheme(Theme theme) {
        themes.add(theme);
    }

    public void addThemes(List<Theme> themes) {
        this.themes.addAll(themes);
    }

    public void updateThemes(List<Theme> themes) {
        this.themes.clear();
        this.themes.addAll(themes);
    }

 */

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("link", link)
                .append("description", description)
                .append("phone", phone)
                .append("address", address)
                .append("themes", themes)
                .toString();
    }
}
