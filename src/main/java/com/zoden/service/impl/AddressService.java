package com.zoden.service.impl;

import com.zoden.dto.DtoAddress;
import com.zoden.dto.DtoAddressIU;
import com.zoden.model.Address;
import com.zoden.repository.AddressRepository;
import com.zoden.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;
    AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAddressIU, address);

        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();

        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        BeanUtils.copyProperties(savedAddress, dtoAddress);

        return dtoAddress;
    }


}
