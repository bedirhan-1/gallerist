package com.zoden.controller;

import com.zoden.dto.DtoCustomer;
import com.zoden.dto.DtoCustomerIU;

public interface IRestCustomerController {
    RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
