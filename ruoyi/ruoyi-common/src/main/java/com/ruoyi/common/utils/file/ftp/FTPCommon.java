package com.ruoyi.common.utils.file.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.util.TimeZone;


public class FTPCommon {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private FTPClient ftpClient;

    private FTPModel ftpModel;

    public FTPCommon(FTPModel ftp) {
        //从配置文件中读取初始化信息
        this.ftpClient = new FTPClient();
        this.ftpModel = ftp;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public FTPModel getFtpModel() {
        return ftpModel;
    }

    public void setFtpModel(FTPModel ftpModel) {
        this.ftpModel = ftpModel;
    }


    /**
     * 连接并登录FTP服务器
     */
    public boolean ftpLogin() {
        boolean isLogin = false;
        FTPClientConfig ftpClientConfig = new FTPClientConfig(
                FTPClientConfig.SYST_NT);
        ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
        this.ftpClient.setControlEncoding("GBK");
        this.ftpClient.configure(ftpClientConfig);
        try {
            if (this.ftpModel.getPort() > 0) {
                this.ftpClient.connect(ftpModel.getUrl(), ftpModel.getPort());
            } else {
                this.ftpClient.connect(ftpModel.getUrl());
            }
            // FTP服务器连接回答
            int reply = this.ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.ftpClient.disconnect();
                return isLogin;
            }
            this.ftpClient.login(this.ftpModel.getUsername(),
                    this.ftpModel.getPassword());
            this.ftpClient.changeWorkingDirectory(this.ftpModel.getRemoteDir());
            this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            isLogin = true;
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.ftpClient.getBufferSize());
        this.ftpClient.setBufferSize(1024 * 2);
        this.ftpClient.setDataTimeout(2000);
        return isLogin;
    }

    /**
     * 退出并关闭FTP连接
     */
    public void close() {
        if (null != this.ftpClient && this.ftpClient.isConnected()) {
            try {
                // 退出FTP服务器
                boolean reuslt = this.ftpClient.logout();
                if (reuslt) {
                    logger.info("退出FTP服务器 成功!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    this.ftpClient.disconnect();// 关闭FTP服务器的连接
                } catch (IOException e) {
                    logger.warn("退出FTP服务器出错!", e);
                }
            }
        }
    }

    /**
     * 检查FTP服务器是否关闭 ，如果关闭接则连接登录FTP
     * @return
     */
    public boolean isOpenFTPConnection() {
        boolean isOpen = false;
        if (null == this.ftpClient) {
            return false;
        }
        try {
            // 没有连接
            if (!this.ftpClient.isConnected()) {
                isOpen = this.ftpLogin();
            }
        } catch (Exception e) {
            e.printStackTrace();
            isOpen = false;
        }
        return isOpen;
    }

    /**
     * 设置传输文件的类型[文本文件或者二进制文件]
     * @param fileType --FTPClient.BINARY_FILE_TYPE,FTPClient.ASCII_FILE_TYPE
     */
    public void setFileType(int fileType) {
        try {
            this.ftpClient.setFileType(fileType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     * @param localFilePath  本地文件名及路径
     * @param remoteFileName 远程文件名称
     * @return
     */
    public boolean downloadFile(String localFilePath, String remoteFileName) {
        BufferedOutputStream outStream = null;
        boolean success = false;
        try {
            outStream = new BufferedOutputStream(new FileOutputStream(
                    localFilePath));
            success = this.ftpClient.retrieveFile(remoteFileName, outStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) {
                try {
                    outStream.flush();
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    /**
     * 下载文件
     * @param localFile
     * @param remoteFileName
     * @return
     */
    public boolean downloadFile(File localFile, String remoteFileName) {
        BufferedOutputStream outStream = null;
        FileOutputStream outStr = null;
        boolean success = false;
        try {
            outStr = new FileOutputStream(localFile);
            outStream = new BufferedOutputStream(outStr);
            success = this.ftpClient.retrieveFile(remoteFileName, outStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outStream) {
                    try {
                        outStream.flush();
                        outStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != outStr) {
                    try {
                        outStr.flush();
                        outStr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return success;
    }

    /**
     * 上传文件
     * @param localFilePath  本地文件路径及名称
     * @param remoteFileName FTP 服务器文件名称
     * @return
     */
    public boolean uploadFile(String localFilePath, String remoteFileName) {
        BufferedInputStream inStream = null;
        boolean success = false;
        try {
            inStream = new BufferedInputStream(new FileInputStream(
                    localFilePath));
            success = this.ftpClient.storeFile(remoteFileName, inStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    /**
     * 上传文件
     * @param localFile
     * @param remoteFileName
     * @return
     */
    public boolean uploadFile(File localFile, String remoteFileName) {
        BufferedInputStream inStream = null;
        boolean success = false;
        try {
            inStream = new BufferedInputStream(new FileInputStream(localFile));
            success = this.ftpClient.storeFile(remoteFileName, inStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    /**
     * 当前目录
     * @return
     */
    public String pwd() {
        try {
            return this.ftpClient.printWorkingDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 变更工作目录
     * @param remoteDir --目录路径
     */
    public void changeDir(String remoteDir) {
        try {
            this.ftpClient.changeWorkingDirectory(remoteDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 变更工作目录
     * @param remoteDirs
     */
    public void changeDir(String[] remoteDirs) {
        String dir = "";
        try {
            for (int i = 0; i < remoteDirs.length; i++) {
                this.ftpClient.changeWorkingDirectory(remoteDirs[i]);
                dir = dir + remoteDirs[i] + "/";
            }
            logger.info("变更工作目录为:" + dir);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 返回上级目录
     * @param remoteDirs
     */
    public void toParentDir(String[] remoteDirs) {
        try {
            for (int i = 0; i < remoteDirs.length; i++) {
                this.ftpClient.changeToParentDirectory();
            }
            logger.info("返回上级目录");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createDir(String pathname) {
        try {
            return this.ftpClient.makeDirectory(pathname);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createDir(String[] remoteDirs) {
        int deep = -1;
        try {
            for (int i = 0; i < remoteDirs.length; i++) {
                String node = remoteDirs[i];
                System.out.println("check dir node is " + node);
                if (!this.ftpClient.changeWorkingDirectory(node)) {
                    System.out.println("pwd is " + this.pwd());
                    System.out.println("make dir node is " + node);
                    if (this.ftpClient.makeDirectory(node)) {
                        this.ftpClient.changeWorkingDirectory(node);
                        continue;
                    }
                    System.out.println("make dir node error ");
                }
                break;
            }
            for (int i = 0; i <= deep; i++) {
                toParentDir();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return remoteDirs.length == deep;
    }

    /**
     * 返回上级目录
     */
    public void toParentDir() {
        try {
            this.ftpClient.changeToParentDirectory();
            logger.info("返回上级目录");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得FTP 服务器下所有的文件名列表
     * @return
     */
    public String[] getListFiels() {
        String files[] = null;
        try {
            files = this.ftpClient.listNames();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}