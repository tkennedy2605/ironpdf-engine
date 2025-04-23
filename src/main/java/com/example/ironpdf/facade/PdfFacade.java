package com.example.ironpdf.facade;

import com.example.ironpdf.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

/**
 * Author: nguyendinhthi
 * Date: 22/4/25
 */
@Component
@RequiredArgsConstructor
public class PdfFacade {

    private final PdfService pdfService;

    public ByteArrayResource getPdf() {
        String html = """
                <h1>Xin chào IronPDF!</h1>
                <p>Đây là ví dụ sinh PDF với Config hot-reload.</p>
                """;
        byte[] pdfBytes = pdfService.generatePdfFromHtml(html);
        return new ByteArrayResource(pdfBytes);
    }
}
