package com.zoden.service;

import com.zoden.dto.DtoGallerist;
import com.zoden.dto.DtoGalleristIU;

public interface IGalleristService {
    DtoGallerist saveGallerist(DtoGalleristIU galleristIU);
}
