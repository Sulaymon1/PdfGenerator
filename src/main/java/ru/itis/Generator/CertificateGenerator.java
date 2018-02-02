package ru.itis.Generator;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Component;
import ru.itis.models.Certificate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class CertificateGenerator {

    private static final String QR_IMAGE = "src/main/resources/qr_codes/qr-code.jpg";
    public static final String SRC = "src/main/resources/results/certificate.pdf";
    private static final String DEST = "src/main/resources/results/certificate_new.pdf";

    /*public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {

    }*/

    public void createPDFWithQRCode( Certificate certificate) throws IOException, DocumentException, URISyntaxException {
        new PdfGenerator().createPdf(certificate);
        QrCodeGenerator.createStaticQR(certificate.getUrl());
        File file = new File(DEST);
        PdfReader reader = new PdfReader(SRC);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DEST));
        Image image = Image.getInstance(QR_IMAGE);
        PdfImage stream = new PdfImage(image, "", null);
        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(85, 200);
        PdfContentByte over = stamper.getOverContent(1);
        over.addImage(image);
        stamper.close();
        reader.close();
    }
}
