package com.apartment.EATDA.domain.user;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void 회원가입() {
        //given
        String name = "박수민";
        String phoneNumber = "010-1234-5678";
        String sex = "여";
        String dateOfBirth = "2000-06-17";
        String nickname = "뭉이";
        String username = "pushclap";
        String password = "19011671";

        userRepository.save(User.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .sex(sex)
                .dateOfBirth(dateOfBirth)
                .nickname(nickname)
                .username(username)
                .password(password)
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(user.getSex()).isEqualTo(sex);
        assertThat(user.getDateOfBirth()).isEqualTo(dateOfBirth);
        assertThat(user.getNickname()).isEqualTo(nickname);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}