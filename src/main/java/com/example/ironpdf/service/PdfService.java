package com.example.ironpdf.service;

import com.ironsoftware.ironpdf.PdfDocument;
import org.springframework.stereotype.Service;

/**
 * Author: nguyendinhthi
 * Date: 22/4/25
 */
@Service
public class PdfService {
    public byte[] generatePdfFromHtml(String htmlContent) {
        try (PdfDocument pdf = PdfDocument.renderHtmlAsPdf(htmlContent)) {
            return pdf.getBinaryData();
        }
    }
}
