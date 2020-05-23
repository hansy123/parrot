package com.hsy.parrot.pdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author:hsy
 * @description:
 * @date 2020/2/24 16:47
 */
@Controller
@RequestMapping("/pdf")
public class PdfDownloadController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private PdfServiceImpl pdfServiceImpl;

    @GetMapping("/down")
    @ResponseBody
    public void download(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        //设置响应文件名称
        String fileName = new String("student.pdf".getBytes("UTF-8"), "iso-8859-1");
        //设置文件名称
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        //获取输出流
        OutputStream out = response.getOutputStream();
        pdfService.download(out);
    }

    @GetMapping("/down2")
    public ResponseEntity<byte[]> download2() throws Exception {
        return pdfServiceImpl.download();
    }
}
