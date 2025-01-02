package com.zoden.controller.impl;

import com.zoden.controller.IRestGalleristController;
import com.zoden.controller.RestBaseController;
import com.zoden.controller.RootEntity;
import com.zoden.dto.DtoGallerist;
import com.zoden.dto.DtoGalleristIU;
import com.zoden.service.impl.GalleristService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gallerist")
public class RestGalleristController extends RestBaseController implements IRestGalleristController {
    private final GalleristService galleristService;
    RestGalleristController(GalleristService galleristService) {
        this.galleristService = galleristService;
    }

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU galleristIU) {
        return ok(galleristService.saveGallerist(galleristIU));
    }
}
