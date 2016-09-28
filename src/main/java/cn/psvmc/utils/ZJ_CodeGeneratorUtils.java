package cn.psvmc.utils;

import java.sql.SQLException;
import java.util.List;

import cn.psvmc.vo.FieldPojo;
import cn.psvmc.vo.TablePojo;

/**
 * @文件名：ZJ_CodeGeneratorUtils.java
 * @作用：代码生成工具类
 * @作者：张剑
 * @创建时间：2014-2-5
 */
public class ZJ_CodeGeneratorUtils {
	private static String database = ZJ_ConfigUtils.getProperty("database");
	private static String tablePrefix = ZJ_ConfigUtils.getProperty("tablePrefix");

	private static String removePrefix(String str, String prefix) {
		if (str.startsWith(prefix)) {
			str = str.replaceFirst(prefix, "");
		}
		return str;
	}

	private static boolean isLowerCase(char c) {
		return c >= 'a';
	}

	private static boolean isUpperCase(char c) {
		return c <= 'Z';
	}

	private static String upperFirst(String str) {
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		return str;
	}

	/**
	 * 把_后的字符大写
	 * 
	 * @param str
	 * @return
	 * @author 张剑
	 * @date 2014年11月13日 下午12:59:54
	 */
	private static String upperMiddle(String str) {
		int length = str.length();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char temp = str.charAt(i);
			if (temp == '_') {
				stringBuffer.append(temp);
				if (i < length - 1) {
					stringBuffer.append(("" + str.charAt(i + 1)).toUpperCase());
				}
				i++;
			} else {
				stringBuffer.append(temp);
			}
		}
		return stringBuffer.toString().replaceAll("_", "");
	}

	private static String lowerFirst(String str) {
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}

	/**
	 * 获取类名
	 * 
	 * @param str
	 * @return
	 * @author 张剑
	 * @date 2014年11月14日 下午12:49:27
	 */
	private static String toClassName(String str) {
		return toClassName(str, tablePrefix);
	}

	private static String toMethodName(String str) {
		if (str.length() > 1 && isLowerCase(str.charAt(0)) && isUpperCase(str.charAt(1))) {
			return str;
		} else {
			return upperFirst(str);
		}
	}

	private static String toClassName(String str, String prefix) {
		str = removePrefix(str, prefix);
		str = upperFirst(str);
		str = upperMiddle(str);
		return str;
	}

	private static String toObjectsName(String str) {
		return toObjectsName(str, tablePrefix);
	}

	private static String toObjectsName(String str, String prefix) {
		str = removePrefix(str, prefix);
		str = lowerFirst(str);
		return str;
	}

	private static String toAttrType(String fieldType) {
		String attrType = "String";
		if (fieldType.equals("bigint")) {
			attrType = "Long";
		} else if (fieldType.contains("int")) {
			attrType = "Integer";
		} else if (fieldType.equals("double")) {
			attrType = "Double";
		} else if (fieldType.equals("float")) {
			attrType = "Float";
		} else if (fieldType.equals("decimal")) {
			attrType = "Double";
		} else if (fieldType.equals("numeric")) {
			attrType = "Doble";
		} else {
			attrType = "String";
		}
		return attrType;
	}

	public static List<TablePojo> getTableList() throws ClassNotFoundException, SQLException {
		String sql = "SELECT table_name tableName,TABLE_COMMENT tableComment FROM INFORMATION_SCHEMA. TABLES WHERE table_schema = '%s'";
		sql = String.format(sql, database);
		List<TablePojo> tableList = new ZJ_DbUtils().queryForList(TablePojo.class, sql);
		for (TablePojo tablePojo : tableList) {
			tablePojo.setObjectsName(toObjectsName(tablePojo.getTableName()));
			tablePojo.setClassName(toClassName(tablePojo.getTableName()));
			tablePojo.setFieldList(getFieldList(tablePojo.getTableName()));
		}
		return tableList;
	}

	public static List<FieldPojo> getFieldList(String tableName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT column_name AS fieldName,CASE WHEN column_comment = NULL OR column_comment = '' THEN column_name ELSE column_comment END AS fieldComment,data_type AS fieldType, CASE WHEN COLUMN_KEY = 'PRI' THEN TRUE ELSE FALSE END AS isKey,CASE WHEN extra = 'auto_increment' THEN TRUE ELSE FALSE END AS isIncrease FROM INFORMATION_SCHEMA. COLUMNS WHERE table_schema = '%s' and table_name = '%s' ";
		sql = String.format(sql, database, tableName);
		List<FieldPojo> fieldList = new ZJ_DbUtils().queryForList(FieldPojo.class, sql);
		for (FieldPojo fieldPojo : fieldList) {
			fieldPojo.setAttributeType(toAttrType(fieldPojo.getFieldType()));
			fieldPojo.setFieldName(lowerFirst(fieldPojo.getFieldName()));
			fieldPojo.setMethodName(toMethodName(fieldPojo.getFieldName()));
		}
		return fieldList;
	}
}
