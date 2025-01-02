package com.zoden.controller;

import com.zoden.dto.DtoGallerist;
import com.zoden.dto.DtoGalleristIU;

public interface IRestGalleristController {
    RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU galleristIU);
}
