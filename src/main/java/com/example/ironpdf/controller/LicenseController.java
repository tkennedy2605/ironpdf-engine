package com.example.ironpdf.controller;

import com.example.ironpdf.facade.LicenseFacade;
import com.example.ironpdf.model.LicenseReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: nguyendinhthi
 * Date: 22/4/25
 */
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseFacade facade;

    @PutMapping("/api/license")
    public void createLicense(@RequestBody LicenseReq req) {
        facade.saveLicense(req);
    }

    @GetMapping("/api/license/refresh")
    public void refresh() {
        facade.refresh();
    }

    @GetMapping("/api/license")
    public String getLicense() {
        return facade.getLicense();
    }
}
