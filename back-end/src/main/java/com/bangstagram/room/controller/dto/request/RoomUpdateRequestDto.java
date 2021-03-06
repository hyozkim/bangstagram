package com.bangstagram.room.controller.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class RoomUpdateRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String address;
    private String link;
    private String phone;
    private String description;

    public RoomUpdateRequestDto() {
    }

    @Builder
    public RoomUpdateRequestDto(String title, String link, String phone, String address, String description) {
        this.title = title;
        this.link = link;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }
}
