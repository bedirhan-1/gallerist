package com.zoden.controller.impl;

import com.zoden.controller.IRestCustomerController;
import com.zoden.controller.RestBaseController;
import com.zoden.controller.RootEntity;
import com.zoden.dto.DtoCustomer;
import com.zoden.dto.DtoCustomerIU;
import com.zoden.service.impl.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class RestCustomerController extends RestBaseController implements IRestCustomerController {

    private final CustomerService customerService;
    public RestCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }

}
