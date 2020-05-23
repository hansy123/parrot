package com.hsy.parrot;

import com.hsy.parrot.config.FtpConfigDto;
import com.hsy.parrot.config.FtpConfigRule;
import com.hsy.parrot.config.FtpUtil;
import com.hsy.parrot.utils.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
public class ParrotClazzServerApplicationTests {

    private static final String DIR_SEPARATOR = "/";
    private static final String FILE_EXTENSION_SEPARATOR = ".";

    @Autowired
    private FtpConfigRule ftpConfigRule;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() throws IOException {

        FtpConfigDto ftpConfigDto = ftpConfigRule.getPrivateFtpConfig();
        InputStream in = FtpUtil.readForFTP(ftpConfigDto, getTemplateRemotePath());
        FileOutputStream fos = new FileOutputStream("E:\\a.ftl");
        byte[] by = new byte[1024];
        int len = 0;
        while ((len = in.read(by)) != -1) {
            fos.write(by, 0, len);
        }
        fos.close();
        in.close();
    }

    private String getTemplateRemotePath() {
        String templatePath = "/template";
        return templatePath + DIR_SEPARATOR + "report-person" + FILE_EXTENSION_SEPARATOR
                + ".ftl";
    }

    @Test
    public void test2() {

        System.out.println("--------");
    }
}
