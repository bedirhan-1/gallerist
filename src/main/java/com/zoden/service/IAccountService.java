package com.zoden.service;

import com.zoden.dto.DtoAccount;
import com.zoden.dto.DtoAccountIU;

public interface IAccountService {
    DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
