package com.bangstagram.user.service;

import com.bangstagram.user.domain.model.api.request.JoinRequestDto;
import com.bangstagram.user.domain.model.api.response.AuthResponseDto;
import com.bangstagram.user.domain.model.api.response.JoinResponseDto;
import com.bangstagram.user.domain.model.user.User;
import com.bangstagram.user.domain.repository.UserRepository;
import com.bangstagram.user.security.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWT jwt;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JWT jwt) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwt = jwt;
    }

    @Transactional
    public JoinResponseDto join(JoinRequestDto joinRequestDto) {
        User user = save(joinRequestDto.newUser(passwordEncoder));

        String jwtToken = user.newJwtToken(jwt, new String[]{"USER_ROLE"});

        return new JoinResponseDto(user,jwtToken);
    }

    private User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        checkNotNull(email, "email must be provided.");

        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        checkNotNull(email, "email must be provided.");

        return Optional.ofNullable(userRepository.findByEmail(email));
    }


}