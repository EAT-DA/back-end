package com.apartment.EATDA.web.dto;

import com.apartment.EATDA.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String phoneNumber;
    private String sex;
    private String dateOfBirth;
    private String nickname;
    private String username;
    private String password;

    @Builder
    public UserSaveRequestDto(String name, String phoneNumber, String sex, String dateOfBirth, String nickname, String username, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .sex(sex)
                .dateOfBirth(dateOfBirth)
                .nickname(nickname)
                .username(username)
                .password(password)
                .build();
    }
}
