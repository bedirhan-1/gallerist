package com.zoden.service;

import com.zoden.dto.DtoCustomer;
import com.zoden.dto.DtoCustomerIU;

public interface ICustomerService {

    DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}
