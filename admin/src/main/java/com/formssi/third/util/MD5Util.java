package com.formssi.third.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String encryptStr(String msg) {
		byte[] bytes = encrypt(msg);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < bytes.length; i++)
		{
			int v =bytes[i]& 0xFF;
			String string =Integer.toHexString(v);
			if (string.length()<2)
			{
				builder.append(0);
			}
			builder.append(string);

		}
		
		return builder.toString();
	}
	public static byte[] encrypt(String msg) {
		try {
			// 根据MD5算法生成MessageDigest对象
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] srcBytes = msg.getBytes("GBK");
			// 使用srcBytes更新摘要
			md5.update(srcBytes);
			// 完成哈希计算,得到result
			byte[] resultBytes = md5.digest();
			return resultBytes;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(MD5Util.encryptStr("北12333345"));
	}
}
