package com.apartment.EATDA.web;

import com.apartment.EATDA.domain.user.User;
import com.apartment.EATDA.domain.user.UserRepository;
import com.apartment.EATDA.web.dto.UserSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void user_저장된다() throws Exception {
        //given
        String name = "박수민";
        String phoneNumber = "010-1234-5678";
        String sex = "여";
        String dateOfBirth = "2000-06-17";
        String nickname = "뭉이";
        String username = "pushclap";
        String password = "19011671";

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .sex(sex)
                .dateOfBirth(dateOfBirth)
                .nickname(nickname)
                .username(username)
                .password(password)
                .build();

        String url = "http://localhost:" + port + "/user/signUp";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> all = userRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(all.get(0).getSex()).isEqualTo(sex);
        assertThat(all.get(0).getDateOfBirth()).isEqualTo(dateOfBirth);
        assertThat(all.get(0).getNickname()).isEqualTo(nickname);
        assertThat(all.get(0).getUsername()).isEqualTo(username);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
    }
}
