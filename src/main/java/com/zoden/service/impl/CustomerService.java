package com.zoden.service.impl;

import com.zoden.dto.*;
import com.zoden.enums.MessageType;
import com.zoden.exception.BaseException;
import com.zoden.exception.ErrorMessage;
import com.zoden.model.Account;
import com.zoden.model.Address;
import com.zoden.model.Customer;
import com.zoden.repository.AccountRepository;
import com.zoden.repository.AddressRepository;
import com.zoden.repository.CustomerRepository;
import com.zoden.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }

    public Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Optional<Address> optionalAddress = addressRepository.findById(dtoCustomerIU.getAddres_id());

        if (optionalAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, dtoCustomerIU.getAddres_id().toString()));
        }

        Optional<Account> optionalAccount = accountRepository.findById(dtoCustomerIU.getAccount_id());

        if (optionalAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, dtoCustomerIU.getAccount_id().toString()));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCustomerIU, customer);

        customer.setAccount(optionalAccount.get());
        customer.setAddress(optionalAddress.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setDtoAccount(dtoAccount);
        dtoCustomer.setDtoAddress(dtoAddress);

        return dtoCustomer;
    }
}
