package com.hsy.parrot.pdf;

import com.hsy.parrot.bean.clazz.Clazz;
import com.hsy.parrot.bean.student.Student;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.PDFEncryption;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:hsy
 * @description:
 * @date 2020/2/25 15:02
 */
@Service
@Slf4j
public class PdfServiceImpl {

    String templatePath = "D:\\student.ftl";
    String fontPath = "D:\\simsun.ttf";
    String waterMarkPath = "D:\\waterMark.png";

    static Map<String, Object> dataMap = new HashMap<>();

    static {
        Clazz clazz = new Clazz();
        clazz.setName("三年级二班");
        List<Student> studentList = new ArrayList<>(1000);
        for (int i = 1; i <= 1000; i++) {
            Student student = new Student();
            student.setName("张三" + i);
            student.setSex("男");
            student.setAge(25 + i);
            studentList.add(student);
        }
        dataMap.put("stus", studentList);
        dataMap.put("clazz", clazz);
    }

    public ResponseEntity<byte[]> download() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(templatePath)), "UTF-8"));
        // 水印
        InputStream fileInputStream = new FileInputStream(new File(waterMarkPath));
        String htmlContent = freeMarkerRender(dataMap, "ss.pdf", in, "UTF-8");
        System.out.println(htmlContent);
        ByteArrayOutputStream output = htmlToPdf(htmlContent, fontPath);
        ByteArrayOutputStream outputStream = addWaterImage(output, IOUtils.toByteArray(fileInputStream), fontPath);
        ResponseEntity<byte[]> res = buildRes(outputStream.toByteArray(), "ss.pdf");
        return res;
    }

    private static ByteArrayOutputStream htmlToPdf(String htmlContent, String fontPath
    ) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ITextRenderer render = new ITextRenderer();
            ITextFontResolver fontResolver = render.getFontResolver();
//            setPDFEncryption(haveWaterMarker, password, adminPassword, render);
            fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            render.setDocumentFromString(htmlContent);
            render.getSharedContext().setBaseURL("file:///");
            render.layout();
            render.createPDF(output);
            return output;
        } catch (Exception e) {
            log.debug("html转换pdf失败!", e);
            throw new RuntimeException("html转换pdf失败");
        }
    }

    private static String freeMarkerRender(Map<String, Object> data, String fileName, BufferedReader inputStream,
                                           String charSet) {
        try (Writer out = new StringWriter();
        ) {
            Configuration configuration = new Configuration();
            Template template = new Template(fileName, inputStream, configuration);
            template.setEncoding(charSet);
            template.process(data, out);
            out.flush();
            return out.toString();
        } catch (Exception e) {
//            log.debug("HTML加载数据失败!", e);
            throw new RuntimeException(e);
        }
    }

    private static void setPDFEncryption(boolean haveWaterMarker, String password, String adminPassword,
                                         ITextRenderer render) {
        if (!haveWaterMarker) {
            PDFEncryption pdfEncryption = new PDFEncryption();
            pdfEncryption.setUserPassword(password.getBytes());
            pdfEncryption.setOwnerPassword(adminPassword.getBytes());
            pdfEncryption.setAllowedPrivileges(PdfWriter.ALLOW_PRINTING);
            pdfEncryption.setEncryptionType(PdfWriter.STANDARD_ENCRYPTION_128);
            render.setPDFEncryption(pdfEncryption);
        }
    }

    private static ByteArrayOutputStream addWaterImage(ByteArrayOutputStream outputStream, byte[] waterMarkByteArray,
                                                       String fontPath) {
        if (waterMarkByteArray == null || waterMarkByteArray.length == 0) {
            return outputStream;
        }
        com.lowagie.text.pdf.BaseFont baseFont = createFont(fontPath);
        try (InputStream input = new ByteArrayInputStream(outputStream.toByteArray())) {
            Image logo = Image.getInstance(waterMarkByteArray);
            return addWaterImage2(baseFont, input, logo);
        } catch (Exception e) {
            log.debug("添加水印和页码失败", e);
            throw new RuntimeException("");
        }
    }

    private static com.lowagie.text.pdf.BaseFont createFont(String fontPath) {
        try {
            return com.lowagie.text.pdf.BaseFont.createFont(fontPath, com.lowagie.text.pdf.BaseFont.IDENTITY_H, com.lowagie.text.pdf.BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            log.debug("字符集读取失败," + fontPath, e);
            throw new RuntimeException("");
        }
    }

    private static ByteArrayOutputStream addWaterImage2(com.lowagie.text.pdf.BaseFont baseFont, InputStream input, Image logo) throws IOException, DocumentException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PdfReader reader = new PdfReader(input);
        PdfStamper stamp = new PdfStamper(reader, output);
//        stamp.setEncryption(password.getBytes(), adminPassword.getBytes(), PERMIT, ENCRYPTION_TYPE);
        PdfContentByte contentByte = null;
        int n = reader.getNumberOfPages();
        for (int i = 1; i <= n; i++) {
            contentByte = stamp.getUnderContent(i);
            Rectangle rectangle = reader.getPageSize(i);
            float width = rectangle.getWidth();
            float height = rectangle.getHeight();
            if (true) {
                logo.setAbsolutePosition(width / 2 - logo.getWidth() / 2, height / 2);
            } else {
                logo.setAbsolutePosition(0, 0);
            }
            contentByte.addImage(logo);
            contentByte.saveState();
            String text = "第 " + i + " 页 /共 " + n + " 页";
            contentByte.beginText();
            contentByte.setFontAndSize(baseFont, 12);
            contentByte.showTextAligned(Element.ALIGN_CENTER, text, (width / 2) - 6, 15, 0);
            contentByte.endText();
        }
        reader.close();
        stamp.close();
        return output;
    }

    public static ResponseEntity<byte[]> buildRes(byte[] fileBytes, String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity(fileBytes, headers, HttpStatus.OK);
    }


}
