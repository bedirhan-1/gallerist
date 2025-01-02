package com.zoden.service;

import com.zoden.dto.AuthRequest;
import com.zoden.dto.AuthResponse;
import com.zoden.dto.DtoUser;
import com.zoden.dto.RefreshTokenRequest;

public interface IAuthenticationService {
    DtoUser register(AuthRequest authRequest);
    AuthResponse authenticate(AuthRequest authRequest);
    AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
