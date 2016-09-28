package cn.psvmc.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @文件名：ZJ_ConfigUtils.java
 * @作用：读取修改配置文件
 * @作者：张剑
 * @创建时间：2014-2-5
 */
public class ZJ_ConfigUtils {
	private static String getFilePath(String fileName) {
		return System.getProperty("user.dir") + "/config/" + fileName;
	}

	/**
	 * 加载Properties
	 * @param fileName
	 * @return
	 */
	private static Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try {
			InputStream inStream = new FileInputStream(getFilePath(fileName));
			properties.load(inStream);
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 显示所有的property的值
	 * @param fileName
	 */
	public static void showProperty(String fileName) {
		Properties properties = loadProperties(fileName);
		properties.list(System.out);
	}

	/**
	 * 获取property的值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return getProperty("config.properties", key);
	}

	/**
	 * 获取property的值
	 * @param fileName
	 * @param key
	 * @return
	 */
	public static String getProperty(String fileName, String key) {
		Properties properties = loadProperties(fileName);
		String val = properties.getProperty(key);
		return val;
	}

	/**
	 * 修改property的值
	 * @param key
	 * @param value
	 */
	public static void setProperty(String key, String value) {
		setProperty("config.properties", key, value);
	}

	/**
	 * 修改property的值
	 * @param fileName
	 * @param key
	 * @param value
	 */
	public static void setProperty(String fileName, String key, String value) {
		try {
			Properties properties = loadProperties(fileName);
			Properties properties2 = new Properties();
			OutputStream fos = new FileOutputStream(getFilePath(fileName));
			for (Object oldKey : properties.keySet()) {
				if (oldKey.equals(key)) {
					properties2.put(key, value);
				} else {
					properties2.put(oldKey, properties.getProperty(oldKey + ""));
				}
			}
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			properties2.store(fos, "『comments』Update key：" + key);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		showProperty("config.properties");
	}

}
