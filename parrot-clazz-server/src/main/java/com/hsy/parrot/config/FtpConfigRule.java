package com.hsy.parrot.config;

import org.springframework.stereotype.Component;

@Component
public class FtpConfigRule {

    private final static String FTP_LOCAL_IP = "10.10.200.50";
    private final static int FTP_LOCAL_PORT = 21;
    private final static String FTP_LOCAL_USER = "bhjr";
    private final static String FTP_LOCAL_PASSWORD = "bhjr";

    private final static String FTP_PRIVATE_IP = "10.10.200.50";
    private final static int FTP_PRIVATE_PORT = 21;
    private final static String FTP_PRIVATE_USER = "bhjr";
    private final static String FTP_PRIVATE_PASSWORD = "bhjr";


    /**
     * FTP连接超时时间(秒)
     */
    private final static int FTP_CONNECT_TIMEOUT = 300;

    /**
     * FTP数据传输超时时间(秒)
     */
    private final static int FTP_DATA_TIMEOUT = 300;

    /**
     * FTP保持连接时间(秒)
     */
    private final static int FTP_KEEP_ALIVE_TIMEOUT = 300;

    public FtpConfigDto getLocalFtpConfig() {
        FtpConfigDto config = new FtpConfigDto();
        config.setIp(FTP_LOCAL_IP);
        config.setPort(FTP_LOCAL_PORT);
        config.setUser(FTP_LOCAL_USER);
        config.setPassword(FTP_LOCAL_PASSWORD);
        config.setCharset("UTF-8");
        setTimeout(config);

        return config;
    }

    public FtpConfigDto getPrivateFtpConfig() {
        FtpConfigDto config = new FtpConfigDto();
        config.setIp(FTP_PRIVATE_IP);
        config.setPort(FTP_PRIVATE_PORT);
        config.setUser(FTP_PRIVATE_USER);
        config.setPassword(FTP_PRIVATE_PASSWORD);
        config.setCharset("UTF-8");
        setTimeout(config);

        return config;
    }

    private void setTimeout(FtpConfigDto config) {
        config.setConnectTimeout(FTP_CONNECT_TIMEOUT);
        config.setDataTimeout(FTP_DATA_TIMEOUT);
        config.setKeepAliveTimeout(FTP_KEEP_ALIVE_TIMEOUT);
    }
}
