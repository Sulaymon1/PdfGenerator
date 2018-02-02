package ru.itis.Generator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import ru.itis.models.Certificate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;

public class PdfGenerator {
    public static final String BACKGROUND_IMAGE = "src/main/resources/background.jpg";
    public static final String DEST = "src/main/resources/results/certificate.pdf";
    public static final String[] MONTHS = new String[]{"janeiro", "fevereiro", "março", "abril",
            "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
    private  final BaseColor LIGHT_BLUE = new BaseColor(96,196,237);

    /* public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {
         new PdfGenerator().createPdf(certificate);
     }*/
    public void createPdf(Certificate certificate) throws IOException, DocumentException, URISyntaxException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        String studentName = certificate.getName()+" "+certificate.getLastname();
        String activityName = certificate.getActivityName();
        String courseName = certificate.getCourseName();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(certificate.getDate() );

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        System.out.println("day: " + day);
        System.out.println("month: " + month);
        System.out.println("year: " + year);
        String dateText = day+ " de "+ MONTHS[month]+" de " + year;

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));


        document.open();

        Paragraph top = new Paragraph();
        Paragraph certificadoText = new Paragraph();
        Paragraph underCertificadoText = new Paragraph();
        Paragraph text = new Paragraph();
        Paragraph date = new Paragraph();
        Paragraph site = new Paragraph();

        BaseFont bf = BaseFont.createFont("fonts/arial.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
        Font font = new Font(Font.FontFamily.HELVETICA,10,Font.BOLD);
        Font fontBold = new Font(Font.FontFamily.HELVETICA,10,Font.BOLD);
        Font fontSite = new Font(Font.FontFamily.HELVETICA,10,Font.BOLD);
        Font headerFont = new Font(bf,30, Font.BOLD);
        Font underHeaderFont = new Font(bf,17);
        font = new Font(bf,14);
        fontBold = new Font(bf, 14, Font.BOLD);
        fontSite = new Font(bf,14,Font.NORMAL, LIGHT_BLUE );

        Chunk headerChunk = new Chunk("CERTIFICADO", headerFont);
        Chunk underHeaderChunk = new Chunk("───  DE CONCLUSÃO  ───", underHeaderFont);
        Chunk chunk = new  Chunk("O E-didático certiﬁca que a aluna "+studentName+" concluiu a Atividade Acadêmica "+activityName+" do módulo "+courseName, font);
        Chunk chunkTest = new  Chunk("O E-didático certiﬁca que a aluna ",font);
        Chunk chunkTest2 = new  Chunk(studentName,fontBold);
        Chunk chunkTest3 = new  Chunk(" concluiu a Atividade Acadêmica "+ activityName+" do módulo "+courseName, font);
        Chunk nothingText = new  Chunk("", font);
        Chunk dateChunk = new  Chunk(dateText, font);
        Chunk siteChunk = new  Chunk("── edidatico.edu.br ──", fontSite);

        top.add(nothingText);
        certificadoText.add(headerChunk);
        underCertificadoText.add(underHeaderChunk);
        text.add(chunkTest);
        text.add(chunkTest2);
        text.add(chunkTest3);
        date.add(dateChunk);
        site.add(siteChunk);

        text.setSpacingBefore(85);
        certificadoText.setSpacingBefore(183);
        certificadoText.setIndentationLeft(155);
        certificadoText.setIndentationRight(155);
        underCertificadoText.setSpacingBefore(10);
        underCertificadoText.setIndentationLeft(145);
        underCertificadoText.setIndentationRight(145);
        text.setIndentationLeft(50);
        text.setIndentationRight(50);
        date.setSpacingBefore(45);
        date.setIndentationLeft(50);
        date.setIndentationRight(50);
        site.setSpacingBefore(255);
        site.setIndentationLeft(180);
        site.setIndentationRight(180);

        document.add(top);
        document.add(certificadoText);
        document.add(underCertificadoText);
        document.add(text);
        document.add(date);
        document.add(site);

        PdfContentByte canvas = writer.getDirectContentUnder();
        ClassLoader classLoader = getClass().getClassLoader();
        Image image = Image.getInstance(classLoader.getResource(BACKGROUND_IMAGE).getFile());
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);
        document.close();


    }

}