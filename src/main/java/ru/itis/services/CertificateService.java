package ru.itis.services;

import com.itextpdf.text.DocumentException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.Generator.CertificateGenerator;
import ru.itis.models.Certificate;
import ru.itis.repositories.CertificateRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository repository;

    @Autowired
    private CertificateGenerator certificateGenerator;

    public void save(Certificate certificate) throws DocumentException, IOException, URISyntaxException {
        repository.save(certificate);
        certificateGenerator.createPDFWithQRCode(certificate);

    }

    public void getCertificate(HttpServletResponse response){
        File file = new File("src/main/resources/results/certificate_new.pdf");
        try {
            InputStream is = new FileInputStream(file);
            IOUtils.copy(is,response.getOutputStream() );
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
