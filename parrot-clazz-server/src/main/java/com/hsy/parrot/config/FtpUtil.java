package com.hsy.parrot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.net.ftp.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class FtpUtil {

    public static final String SPLITTER = "/";
    public static final int BUFFER_SIZE = 1024;
    public static final String POINT = ".";

    public static InputStream readForFTP(FtpConfigDto config, String path) {
        InputStream in;
        InputStream returnIn = null;
        try {
            connect(config);
            String dir = getDir(path);
            String fileName = getFileName(path);
            changeWorkDir(config.getFtpClient(), dir);
            validateRemoteFileExist(config.getFtpClient(), dir, fileName);
            config.getFtpClient().enterLocalPassiveMode();
            in = config.getFtpClient().retrieveFileStream(convertFileName(path));
            if (in != null) {
                returnIn = cloneInputStream(in);
                in.close();
                config.getFtpClient().completePendingCommand();
            }
        } catch (IOException e) {
            log.info("FTP服务器文件读取错误 " + config.getIp(), e);
//            throw new RuleException(ErrorCodeCredit.FTP_FILE_READ_ERROR);
        } finally {
            disConnect(config.getFtpClient());
        }
        return returnIn;
    }

    private static void disConnect(FTPClient ftpClient) {
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            log.info("关闭FTP连接错误", e);
        }
    }

    private static InputStream cloneInputStream(InputStream input) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            InputStream inputStream;
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            inputStream = new ByteArrayInputStream(baos.toByteArray());
            return inputStream;
        } catch (IOException e) {
            log.info("复制inputStream失败", e);
            throw e;
        }
    }

    private static String convertFileName(String fileName) {
        return new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }

    private static void validateRemoteFileExist(FTPClient ftpClient, String dir, String fileName) throws IOException {
        if (!isRemoteFileExist(ftpClient, dir, fileName)) {
            throw new RuntimeException("");
        }
    }

    private static boolean isRemoteFileExist(FTPClient ftpClient, String dir, String fileName) throws IOException {
        FTPFile[] arr = ftpClient.listFiles(dir, new FTPFileFilter() {
            @Override
            public boolean accept(FTPFile ftpFile) {
                return ftpFile.getName().equals(fileName);
            }
        });
        return ArrayUtils.isNotEmpty(arr);
    }

    private static void changeWorkDir(FTPClient ftpClient, String dir) throws IOException {
        if (ftpClient.changeWorkingDirectory(dir)) {
            return;
        }
        StringBuilder pathTemp = new StringBuilder();
        for (String token : dir.split(SPLITTER)) {
            pathTemp.append(SPLITTER).append(token);
            if (!ftpClient.changeWorkingDirectory(pathTemp.toString())) {
                log.debug("目录名称为：" + token);
                boolean isSuccess = ftpClient.makeDirectory(token);
//                Validator.assertTrue(isSuccess, ErrorCodeCredit.FTP_FILE_UPLOAD_ERROR, "创建FTP目录失败");
                changeWorkDirDirect(ftpClient, pathTemp.toString());
            }
        }
    }

    private static void changeWorkDirDirect(FTPClient ftpClient, String path) throws IOException {
        boolean isSuccess = ftpClient.changeWorkingDirectory(path);
//        Validator.assertTrue(isSuccess, ErrorCodeCredit.FTP_FILE_CHECK_ERROR, "工作区跳转失败");
    }

    private static String getFileName(String path) {
        int i = path.lastIndexOf(SPLITTER);
        return path.substring(i + 1);
    }

    public static String getDir(String path) {
        int i = path.lastIndexOf(SPLITTER);
        return path.substring(0, i);
    }

    private static void connect(FtpConfigDto config) throws IOException {
        FTPClient ftpClient = new FTPClient();
        config.setFtpClient(ftpClient);
        ftpClient.connect(config.getIp(), config.getPort());
        if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            boolean isLogin = ftpClient.login(config.getUser(), config.getPassword());
//            Validator.assertTrue(isLogin, ErrorCodeCredit.FTP_LOGIN_ERROR);
            ftpClient.setControlEncoding(config.getCharset());
            if ("UTF-8".equals(config.getCharset())
                    && FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {
                ftpClient.setControlEncoding("UTF-8");
            }
            setConfig(config);
        }
    }

    private static void setConfig(FtpConfigDto config) throws IOException {
        FTPClient ftpClient = config.getFtpClient();
        ftpClient.setBufferSize(BUFFER_SIZE);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
        ftpClient.setConnectTimeout(config.getConnectTimeout() * 1000);
        ftpClient.setDataTimeout(config.getDataTimeout() * 1000);
        ftpClient.setControlKeepAliveTimeout(config.getKeepAliveTimeout() * 1000);
        ftpClient.enterLocalPassiveMode();
    }
}
