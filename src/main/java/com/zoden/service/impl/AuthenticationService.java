package com.zoden.service.impl;

import com.zoden.dto.AuthRequest;
import com.zoden.dto.AuthResponse;
import com.zoden.dto.DtoUser;
import com.zoden.dto.RefreshTokenRequest;
import com.zoden.exception.BaseException;
import com.zoden.exception.ErrorMessage;
import com.zoden.enums.MessageType;
import com.zoden.jwt.JwtService;
import com.zoden.model.RefreshToken;
import com.zoden.model.User;
import com.zoden.repository.RefreshTokenRepository;
import com.zoden.repository.UserRepository;
import com.zoden.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationProvider authenticationProvider;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;

    AuthenticationService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationProvider authenticationProvider, JwtService jwtService, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.jwtService = jwtService;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public User createUser(AuthRequest authRequest) {
        User newUser = new User();
        newUser.setCreateTime(new Date());
        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));

        return newUser;
    }

    public RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        refreshToken.setUser(user);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    public boolean isRefreshTokenExpired(Date date) {
        return new Date().before(date);
    }

    @Override
    public DtoUser register(AuthRequest authRequest) {
        DtoUser dtoUser = new DtoUser();

        if(userRepository.findByUsername(authRequest.getUsername()).isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_ALREADY_EXISTS, authRequest.getUsername()));
        }

        User savedUser = userRepository.save(createUser(authRequest));

        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        AuthResponse authResponse = new AuthResponse();

        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationProvider.authenticate(usernamePasswordAuthenticationToken);

            Optional<User> optional = userRepository.findByUsername(authRequest.getUsername());

            if(optional.isEmpty()){
                throw new BaseException(new ErrorMessage(MessageType.USER_NOT_FOUND, authRequest.getUsername()));
            }

            String accessToken = jwtService.generateToken(optional.get());
            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optional.get()));
            authResponse.setRefreshToken(savedRefreshToken.getRefreshToken());
            authResponse.setToken(accessToken);

            return authResponse;
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INCORRECT, e.getMessage()));
        }
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        Optional<RefreshToken> optional = refreshTokenRepository.findRefreshTokenByRefreshToken(refreshTokenRequest.getRefreshToken());
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, refreshTokenRequest.getRefreshToken()));
        } else if (!isRefreshTokenExpired(optional.get().getExpiresAt())) {
            refreshTokenRepository.delete(optional.get());
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED, refreshTokenRequest.getRefreshToken()));
        }

        User user = optional.get().getUser();

        String accessToken = jwtService.generateToken(user);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }
}

