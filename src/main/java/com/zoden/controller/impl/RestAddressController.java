package com.zoden.controller.impl;

import com.zoden.controller.IRestAddressController;
import com.zoden.controller.RestBaseController;
import com.zoden.controller.RootEntity;
import com.zoden.dto.DtoAddress;
import com.zoden.dto.DtoAddressIU;
import com.zoden.service.impl.AddressService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class RestAddressController extends RestBaseController implements IRestAddressController {

    private final AddressService addressService;
    RestAddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.saveAddress(dtoAddressIU));
    }
}
