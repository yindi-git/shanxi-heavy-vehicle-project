package com.ruoyi.common.utils.file.ftp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FTPModel {

	@Value("${ftp.userName}")
	private String username;

	@Value("${ftp.password}")
	private String password;

	@Value("${ftp.host}")
	private String url;

	@Value("${ftp.port}")
	private int port;

	@Value("${ftp.remoteDir}")
	private String remoteDir;

	public FTPModel() {

	}

	public FTPModel(String username, String password, String url, int port,
			String remoteDir) {
		this.username = username;
		this.password = password;
		this.url = url;
		this.port = port;
		this.remoteDir = remoteDir;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getRemoteDir() {
		return remoteDir;
	}

	public void setRemoteDir(String remoteDir) {
		this.remoteDir = remoteDir;
	}

}