package com.zoden.controller;

import com.zoden.dto.AuthRequest;
import com.zoden.dto.AuthResponse;
import com.zoden.dto.DtoUser;
import com.zoden.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
    RootEntity<DtoUser> register(AuthRequest authRequest);
    RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
    RootEntity<AuthResponse> refresh(RefreshTokenRequest refreshTokenRequest);
}

