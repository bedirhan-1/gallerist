package com.zoden.controller;

import com.zoden.dto.DtoAccount;
import com.zoden.dto.DtoAccountIU;

public interface IRestAccountController {
    RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
