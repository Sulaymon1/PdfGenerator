package ru.itis.Generator;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.*;

public class QrCodeGenerator {
    private static final String QR_CODE_PATH ="src/main/resources/qr_codes/qr-code.jpg";
    public static void createStaticQR(String url){
        ByteArrayOutputStream bout =
                QRCode.from(url)
                        .withSize(100, 100)
                        .to(ImageType.PNG)
                        .stream();

        try {
            File file = new File(QR_CODE_PATH);
            file.getParentFile().mkdirs();
            OutputStream out = new FileOutputStream(file);
            bout.writeTo(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
