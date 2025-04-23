package com.example.ironpdf.controller;

import com.example.ironpdf.facade.PdfFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: nguyendinhthi
 * Date: 22/4/25
 */
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class PdfController {

    private final PdfFacade facade;

    @GetMapping(value = "/api/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<ByteArrayResource> getPdf() {
        var resource = facade.getPdf();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=example.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
