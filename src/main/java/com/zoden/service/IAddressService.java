package com.zoden.service;

import com.zoden.dto.DtoAddress;
import com.zoden.dto.DtoAddressIU;

public interface IAddressService {
    DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
