package ru.itis.controllers;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.models.Certificate;
import ru.itis.services.CertificateService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService service;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @PostMapping("/")
    public String getCertificatePDF(@ModelAttribute ModelMap map, @Valid Certificate certificate, BindingResult result){

        if (result.hasErrors()){
            return "redirect:/";
        }

        try {
            service.save(certificate);
        } catch (DocumentException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return "result";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response){
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition","attachment; filename=" + "certificate.pdf");
        service.getCertificate(response);

    }
    @GetMapping("/view")
    public void viewPDF(HttpServletResponse response){
        response.setContentType("application/pdf");
        service.getCertificate(response);
    }
}
