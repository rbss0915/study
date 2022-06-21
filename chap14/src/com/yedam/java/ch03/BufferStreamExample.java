package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamExample {

	public static void main(String[] args) throws Exception{
		//buffer 스트림X
		String originalFilePath1
		= BufferStreamExample.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "DL/dev/temp/targetFile1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(originalFilePath1);
		
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을때 : " + nonBufferTime + "ns");
		
		fis1.close();
		fos1.close();
		
		
		//buffer 스트림O
		String originalFilePath2
		= BufferStreamExample.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "DL/dev/temp/targetFile2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(originalFilePath2);
		
		BufferedInputStream bis= new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long BufferTime = copy(bis, bos);
		System.out.println("버퍼를 사용 했을 때 : " + BufferTime + "ns");
		
		fis2.close();
		fos2.close();
		

	}
	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		while(true) {
			data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		os.flush();
		long end = System.nanoTime();
		return (end-start);
				
	}

}
