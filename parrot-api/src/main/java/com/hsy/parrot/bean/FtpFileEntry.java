package com.hsy.parrot.bean;

import lombok.Data;

import java.io.File;

@Data
public class FtpFileEntry {
    private String path;
    private File file;

    public FtpFileEntry(String path, File file) {
        super();
        this.path = path;
        this.file = file;
    }
}
