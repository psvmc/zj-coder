package cn.psvmc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.psvmc.utils.ZJ_CodeGeneratorUtils;
import cn.psvmc.utils.ZJ_ConfigUtils;
import cn.psvmc.vo.TablePojo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CodeCreater {
	private static String database = "";
	private static String selectTableName = "";
	private static String namespace = "";
	private static String fileNameSuffix = "";
	private static String fileSuffix = "";
	private static String fileName = "";
	private static String templateName = "";
	private static String outputPath = "";

	private static void reset() {
		database = ZJ_ConfigUtils.getProperty("database");
		selectTableName = ZJ_ConfigUtils.getProperty("selectTableName");
		namespace = ZJ_ConfigUtils.getProperty("namespace");
		fileNameSuffix = ZJ_ConfigUtils.getProperty("fileNameSuffix");
		fileSuffix = ZJ_ConfigUtils.getProperty("fileSuffix");
		fileName = ZJ_ConfigUtils.getProperty("fileName");
		templateName = ZJ_ConfigUtils.getProperty("templateName");
		outputPath = ZJ_ConfigUtils.getProperty("outputPath");
	}

	public static void tableCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		reset();
		String path = outputPath + "/" + database + "/" + namespace.replaceAll("[.]", "/") + "/";
		// 找目录
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setDirectoryForTemplateLoading(new File("templates"));
		// 设模板
		Template temp1 = cfg.getTemplate(templateName);
		temp1.setEncoding("UTF-8");
		// 加数据
		List<TablePojo> tableList = ZJ_CodeGeneratorUtils.getTableList();
		Map<String, Object> tempData = new HashMap<String, Object>();
		tempData.put("now", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		tempData.put("namespace", namespace);
		tempData.put("fileNameSuffix", fileNameSuffix);
		tempData.put("fileName", fileName);
		tempData.put("fileSuffix", fileSuffix);
		Writer out = null;
		for (TablePojo tablePojo : tableList) {
			if (tablePojo.getTableName().contains(selectTableName)) {
				tempData.put("tablePojo", tablePojo);
				// 去输出
				File outFolder = new File(path);
				outFolder.mkdirs();
				File outFile = new File(path + tablePojo.getClassName() + fileNameSuffix + "." + fileSuffix);

				FileOutputStream fos = new FileOutputStream(outFile);
				OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");// 这个地方对流的编码不可或缺，
				out = new BufferedWriter(oWriter);
				temp1.process(tempData, out);
				out.flush();
				out.close();
				System.out.println(path + tablePojo.getClassName() + fileNameSuffix + "." + fileSuffix);
			}
		}
		System.out.println("*****************************文件生成完毕****************************");
	}

	public static void databaseCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		reset();
		String path = outputPath + "/" + database + "/" + namespace.replaceAll("[.]", "/") + "/";
		// 找目录
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setDirectoryForTemplateLoading(new File("templates"));
		// 设模板
		Template temp1 = cfg.getTemplate(templateName);
		temp1.setEncoding("UTF-8");
		// 加数据
		List<TablePojo> tableList = ZJ_CodeGeneratorUtils.getTableList();
		Map<String, Object> tempData = new HashMap<String, Object>();
		tempData.put("now", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		tempData.put("namespace", namespace);
		tempData.put("fileNameSuffix", fileNameSuffix);
		tempData.put("fileName", fileName);
		tempData.put("fileSuffix", fileSuffix);
		tempData.put("tableList", tableList);
		Writer out = null;

		// 去输出
		File outFolder = new File(path);
		outFolder.mkdirs();
		File outFile = new File(path + "/" + fileName + fileNameSuffix + "." + fileSuffix);
		FileOutputStream fos = new FileOutputStream(outFile);
		OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");// 这个地方对流的编码不可或缺，
		out = new BufferedWriter(oWriter);
		temp1.process(tempData, out);
		out.flush();
		out.close();
		System.out.println(path + fileName + fileNameSuffix + "." + fileSuffix + "生成了");
	}
}
