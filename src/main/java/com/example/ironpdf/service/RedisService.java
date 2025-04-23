package com.example.ironpdf.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: nguyendinhthi
 * Date: 22/4/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redis;

    public String getLicense(String licenseKey) {
        String key = redis.opsForValue().get(licenseKey);
        return StringUtils.isBlank(key) ? "" : key;
    }

    public void setLicense(String licenseKey, String licenseValue) {
        redis.opsForValue().set(licenseKey, licenseValue.trim());
        log.info("[REDIS] {} set to {}", licenseKey, getLicense(licenseKey));
    }
}
