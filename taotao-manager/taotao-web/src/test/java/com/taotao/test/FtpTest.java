package com.taotao.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FtpTest {

	@Test
	public void test() throws Exception {
		FileInputStream inputStream = new FileInputStream("C:\\Users\\jiang\\Desktop\\github.jpg");
		FtpUtil.uploadFile("192.168.4.142", 21, "ftp", "123456","/" , "/image", "github.jpg", inputStream);
	}

}
