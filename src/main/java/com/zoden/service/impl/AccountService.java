package com.zoden.service.impl;

import com.zoden.dto.DtoAccount;
import com.zoden.dto.DtoAccountIU;
import com.zoden.model.Account;
import com.zoden.repository.AccountRepository;
import com.zoden.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(DtoAccountIU dtoAccountIU) {
        Account account = new Account();
        account.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAccountIU, account);

        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();
        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount, dtoAccount);

        return dtoAccount;
    }
}
