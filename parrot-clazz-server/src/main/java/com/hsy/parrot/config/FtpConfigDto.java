package com.hsy.parrot.config;

import lombok.Data;
import org.apache.commons.net.ftp.FTPClient;

@Data
public class FtpConfigDto {
    private String ip;
    private int port;
    private String user;
    private String password;
    private String charset;
    private int connectTimeout;
    private int dataTimeout;
    private int keepAliveTimeout;

    private FTPClient ftpClient;
}
