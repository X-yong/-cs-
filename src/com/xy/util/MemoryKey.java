package com.xy.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.xy.entity.Admin;

public class MemoryKey {
     Properties prop = new Properties();
     File file;
     //读取TXT内的用户名与密码
	public Admin readMemoryKey() {
		   Admin memory = new Admin();
		try {
			FileReader fr = new FileReader("jdbc/Key.abc");
			prop.load(fr);
			fr.close();
			memory.setEname(prop.getProperty("userName"));
			memory.setKey(prop.getProperty("key"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memory;
	}
	//将用户名与密码写入文档
	public Admin writeMemoryKey(Admin memorykey) {
		   file  = new  File("jdbc/Key.abc");
		  try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("userName="+memorykey.getEname());
			bw.newLine();
			bw.write("key="+memorykey.getKey());
			bw.newLine();
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memorykey;  	 
	}
}
