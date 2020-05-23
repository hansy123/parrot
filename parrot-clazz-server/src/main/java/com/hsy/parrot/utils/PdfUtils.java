package com.hsy.parrot.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:hsy
 * @description:
 * @date 2020/2/24 17:17
 */
public class PdfUtils {
    /**
     * description 读取pdf文件，输出pdf模板
     * param:
     * return
     */
    public static String readPdf(String path) {
        String textFromPage = "";
        PdfReader reader = null;
        try {
            reader = new PdfReader(path);
            reader.getNumberOfPages();
            /* 模板对象 */
            textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromPage;
    }

    /**
     * description： 处理返回值
     * param:
     * return
     */
    public static Map<String, String> ProcessField(String toString) {

        String s1 = StringUtils.substringAfter(toString, "(");
        String s2 = StringUtils.substringBefore(s1, ")");
        Map<String, String> keyvalMaps = new HashMap<>();
        String[] split = s2.split(", ");
        for (String split1 : split) {
            String[] split2 = split1.split("=");
            if (split2.length == 2) {
                keyvalMaps.put(split2[0], split2[1]);
            }
        }
        return keyvalMaps;
    }

    /**
     * description 循环遍历文件夹下的文件
     * param:
     * return
     *
     * @return
     */
    public static List<String> findDir(String path) {
        File dir = new File(path);
        File[] fileList = dir.listFiles();
        List<String> strList = new ArrayList<String>();
        for (File f : fileList) {
            if ((f.isFile())) {
                strList.add(f.getAbsolutePath());
            }
        }
        return strList;
    }

    //暂时不用
    public static boolean mergePdfFiles(String[] files, String newfile) throws Exception {
        boolean retValue = false;
        Document document = null;
        try {
            document = new Document(new PdfReader(files[0]).getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
            document.open();
            for (int i = 0; i < files.length; i++) {

                PdfReader reader = new PdfReader(files[i]);
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {

                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
            retValue = true;
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return retValue;
    }


    private static String[] getFiles(String folder) throws IOException {
        File _folder = new File(folder);
        String[] filesInFolder;

        if (_folder.isDirectory()) {
            filesInFolder = _folder.list();
            return filesInFolder;
        } else {
            throw new IOException("Path is not a directory");
        }
    }

    /**
     * description: 多个pdf合成一个pdf
     * param:
     * return
     */
//    public static void mergePdf(String filePath,String savePath) throws IOException, COSVisitorException {
//
//        //pdf合并工具
//        PDFMergerUtility mergePdf = new PDFMergerUtility();
//        String destinationFileName = "message.pdf";
//        String[] filesInFolder = getFiles(filePath);
//        for(int i = 0; i < filesInFolder.length; i++){
//            //循环添加要合并的pdf存放的路径
//            mergePdf.addSource(filePath + File.separator + filesInFolder[i]);
//        }
//        mergePdf.setDestinationFileName(savePath+ File.separator + destinationFileName);
//        //合并pdf
//        mergePdf.mergeDocuments();
//    }

    /**
     * description:创建文件
     * param:
     * return
     */
    public static File createFile(File file) {
        if (!file.exists()) {
            file = new File("");
        }
        return file;
    }

    /**
     * description 删除文件
     * param:
     * return
     */
    public static void delFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /**
     * description 弹出文件
     * param:
     * return
     */
    public static void writerResponse(String fileName, HttpServletResponse response, String exportPath) {
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8") + ".pdf");
            response.setContentType("application/octet-stream");
            FileInputStream fis = new FileInputStream(exportPath);
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();

            ServletOutputStream sos = response.getOutputStream();
            sos.write(content);
            sos.flush();
            sos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getReflect(Object model) throws Exception {
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Map<String, Object> map = new HashMap<>();
            map.put(field.getName(), field.get(model));

        }
    }
}
