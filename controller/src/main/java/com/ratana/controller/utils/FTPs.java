package com.ratana.controller.utils;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FTPs {

    FTPClient ftp = null;

    public FTPs(String host, String user, String pwd) throws Exception {
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }
    public void uploadFile(String localFileFullName, String fileName, String hostDir) {
        try(InputStream input = new FileInputStream(localFileFullName)){
            this.ftp.storeFile(hostDir + fileName, input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) throws IOException {
        boolean exist = ftp.deleteFile(fileName);
        if (exist) {
            System.out.println("File '"+ fileName + "' deleted...");
        } else
            System.out.println("File '"+ fileName + "' doesn't exist...");
        this.disconnect();
    }

    public FTPFile[] listFile(String path){
        try {
            return ftp.listFiles(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() throws IOException {
        if (this.ftp.isConnected()) {
            this.ftp.logout();
            this.ftp.disconnect();
        }
    }



}