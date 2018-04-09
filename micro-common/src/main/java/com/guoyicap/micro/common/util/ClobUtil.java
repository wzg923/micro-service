package com.guoyicap.micro.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLException;

/**
 * Clob类型数据转换工具类
 * 
 * @author guang
 *
 */
public class ClobUtil {
	/**
	 * Clob 转换为String
	 * @param clob
	 * @return
	 */
	public static String ClobToString(Clob clob) {
		String clobStr = "";
		Reader is = null;
		try {
			is = clob.getCharacterStream();
			// 得到流
			BufferedReader br = new BufferedReader(is);
			String s = null;
			s = br.readLine();
			StringBuffer sb = new StringBuffer();
			// 执行循环将字符串全部取出赋值给StringBuffer，由StringBuffer转成String
			while (s != null) {
				sb.append(s);
				s = br.readLine();
			}
			clobStr = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clobStr;
	}
	
	
	/**
	 * @param nclob
	 * @return
	 */
	public static String NClobToString(NClob nclob) {
		String nclobStr = "";
		Reader is = null;
		try {
			is = nclob.getCharacterStream();
			// 得到流
			BufferedReader br = new BufferedReader(is);
			String s = null;
			s = br.readLine();
			StringBuffer sb = new StringBuffer();
			// 执行循环将字符串全部取出赋值给StringBuffer，由StringBuffer转成String
			while (s != null) {
				sb.append(s);
				s = br.readLine();
			}
			nclobStr = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nclobStr;
	}
}
