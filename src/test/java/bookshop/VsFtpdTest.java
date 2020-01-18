package bookshop;/*
package edu.gdpu.bookshop;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class VsFtpdTest {

    @Test
    public void FtpUpload() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.142.128");
        ftpClient.login("ftpuser","123");
        FileInputStream inputStream = new FileInputStream(new File("D:\\img\\1.jpg"));
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.storeFile("01.jpg",inputStream);
        inputStream.close();
        ftpClient.logout();
    }
}
*/
