package com.zoden.controller.impl;

import com.zoden.controller.IRestAuthenticationController;
import com.zoden.controller.RestBaseController;
import com.zoden.controller.RootEntity;
import com.zoden.dto.AuthRequest;
import com.zoden.dto.AuthResponse;
import com.zoden.dto.DtoUser;
import com.zoden.dto.RefreshTokenRequest;
import com.zoden.service.impl.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    private final AuthenticationServiceImpl authenticationService;
    RestAuthenticationControllerImpl(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.register(authRequest));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.authenticate(authRequest));
    }

    @PostMapping("/refresh-token")
    @Override
    public RootEntity<AuthResponse> refresh(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}
