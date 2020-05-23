package com.hsy.parrot.pdf;

import com.hsy.parrot.bean.student.Student;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:hsy
 * @description:
 * @date 2020/2/24 18:24
 */
@Slf4j
@Service
public class PdfService {

    private final static String filePath = "D:\\student.pdf";

    public void download(OutputStream out) {
        Student student = new Student();
        student.setName("张三");
        student.setAge(12);
        student.setSex("男");

        Map<String, String> fieldMapping = new HashMap<>();
        fieldMapping.put("name", student.getName());
        fieldMapping.put("age", student.getName());
        fieldMapping.put("sex", student.getName());

//        String filePath;
        byte[] pdfTemplate;
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        try {
            //获取模板文件字节数据
            pdfTemplate = IOUtils.toByteArray(new FileInputStream(filePath));
            //获取渲染数据后pdf字节数组数据
            byte[] pdfByteArray = generatePdfByTemplate(pdfTemplate, fieldMapping);
            pdfOutputStream.write(pdfByteArray);
            pdfOutputStream.writeTo(out);
            pdfOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pdfOutputStream.close();
                out.flush();
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    //itextPdf/AcroFields完成PDF数据渲染
    public byte[] generatePdfByTemplate(byte[] pdfTemplate, Map<String, String> pdfParamMapping) {
        Assert.notNull(pdfTemplate, "template is null");
        if (pdfParamMapping == null || pdfParamMapping.isEmpty()) {
            throw new IllegalArgumentException("pdfParamMapping can't be empty");
        }

        PdfReader pdfReader = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = null;
        try {
            // 读取pdf模板
            pdfReader = new PdfReader(pdfTemplate);
            stamper = new PdfStamper(pdfReader, baos);
            //获取所有表单字段数据
            AcroFields form = stamper.getAcroFields();
            form.setGenerateAppearances(true);

            // 设置
            ArrayList<BaseFont> fontList = new ArrayList<>();
            fontList.add(getMsyhBaseFont());
            form.setSubstitutionFonts(fontList);

            // 填充form
            for (String formKey : form.getFields().keySet()) {
                form.setField(formKey, pdfParamMapping.getOrDefault(formKey, "xxx"));
            }
            // 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.setFormFlattening(true);
            stamper.close();
            return baos.toByteArray();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (stamper != null) {
                try {
                    stamper.close();
                } catch (DocumentException | IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            if (pdfReader != null) {
                pdfReader.close();
            }

        }
        throw new RuntimeException("pdf generate failed");
    }

    /**
     * 默认字体
     *
     * @return
     */
    private BaseFont getDefaultBaseFont() throws IOException, DocumentException {
        return BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    }

    /**
     * 微软宋体字体
     *
     * @return
     */
    //设定字体
    private BaseFont getMsyhBaseFont() throws IOException, DocumentException {
        try {
            return BaseFont.createFont("/font/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException | IOException e) {
            log.error(e.getMessage(), e);
        }
        return getDefaultBaseFont();
    }
}
