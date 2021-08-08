package com.apartment.EATDA.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private String sex;
    @Column
    private String dateOfBirth;
    @Column
    private String nickname;
    @Column
    private String username;
    @Column
    private String password;

    @Builder
    public User(String name, String phoneNumber, String sex, String dateOfBirth, String nickname, String username, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public User update(String name, String phoneNumber, String sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;

        return this;
    }
}