package com.example.ironpdf.facade;

import com.example.ironpdf.model.LicenseReq;
import com.example.ironpdf.service.RedisService;
import com.ironsoftware.ironpdf.License;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Author: nguyendinhthi
 * Date: 22/4/25
 */
@Slf4j
@Component
public class LicenseFacade {

    private static final String KEY = "ironpdf:license";

    private volatile String licenseKey;
    private final RedisService redisService;

    public LicenseFacade(RedisService redisService,
                         @Value("${ironpdf.license.key}") String defaultKey) {
        this.redisService = redisService;
        String key = redisService.getLicense(KEY);
        if (StringUtils.isBlank(key)) {
            key = defaultKey;
        }
        applyKey(key);
    }

    @Scheduled(cron = "${ironpdf.license.cron}")
    public void refresh() {
        String key = redisService.getLicense("ironpdf:license");
        if (key != null && !key.equals(licenseKey)) {
            applyKey(key);
            log.info("IronPDF license updated from Redis: {}", key);
        }
    }

    public void saveLicense(LicenseReq req) {
        applyKey(req.getLicense());
    }

    public String getLicense() {
        return License.getLicenseKey();
    }

    private void applyKey(String license) {
        License.setLicenseKey(license);
        this.licenseKey = license;
        redisService.setLicense(KEY, license);
    }
}
