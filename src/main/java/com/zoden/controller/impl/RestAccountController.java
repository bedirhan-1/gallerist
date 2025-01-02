package com.zoden.controller.impl;

import com.zoden.controller.IRestAccountController;
import com.zoden.controller.RestBaseController;
import com.zoden.controller.RootEntity;
import com.zoden.dto.DtoAccount;
import com.zoden.dto.DtoAccountIU;
import com.zoden.service.impl.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class RestAccountController extends RestBaseController implements IRestAccountController {

    private final AccountService accountService;
    RestAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
}
