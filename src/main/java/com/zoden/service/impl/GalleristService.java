package com.zoden.service.impl;

import com.zoden.dto.DtoAddress;
import com.zoden.dto.DtoCustomerIU;
import com.zoden.dto.DtoGallerist;
import com.zoden.dto.DtoGalleristIU;
import com.zoden.enums.MessageType;
import com.zoden.exception.BaseException;
import com.zoden.exception.ErrorMessage;
import com.zoden.model.Address;
import com.zoden.model.Gallerist;
import com.zoden.repository.AddressRepository;
import com.zoden.repository.GalleristRepository;
import com.zoden.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristService implements IGalleristService {

    private final GalleristRepository galleristRepository;
    private final AddressRepository addressRepository;
    GalleristService(GalleristRepository galleristRepository, AddressRepository addressRepository) {
        this.galleristRepository = galleristRepository;
        this.addressRepository = addressRepository;
    }

    public Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
        Gallerist gallerist = new Gallerist();
        Optional<Address> optionalAddress = addressRepository.findById(dtoGalleristIU.getAddress_id());

        if (optionalAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, dtoGalleristIU.getAddress_id().toString()));
        }

        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setCreateTime(new Date());
        gallerist.setAddress(optionalAddress.get());

        return gallerist;
    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU galleristIU) {
        Gallerist savedGallerist = galleristRepository.save(createGallerist(galleristIU));
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);


        return dtoGallerist;
    }
}
