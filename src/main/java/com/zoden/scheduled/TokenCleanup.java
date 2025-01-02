package com.zoden.scheduled;

import com.zoden.repository.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenCleanup {
    private final RefreshTokenRepository refreshTokenRepository;
    public TokenCleanup(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
    @Transactional
    public void cleanup() {
        refreshTokenRepository.deleteAllByExpiresAtBefore(new Date());
    }

}
