package com.zoden.controller;

import com.zoden.dto.DtoAddress;
import com.zoden.dto.DtoAddressIU;

public interface IRestAddressController {
    RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
