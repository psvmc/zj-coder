/**
 * 
 */
package cn.psvmc.vo;

import java.util.List;

/**
 * @文件名：TablePojo.java
 * @作者：张剑
 * @创建时间：2014-1-24
 */
public class TablePojo {
	private String tableName;
	private String className;
	private String objectsName;
	private String tableComment;
	private List<FieldPojo> fieldList;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getObjectsName() {
		return objectsName;
	}

	public void setObjectsName(String objectsName) {
		this.objectsName = objectsName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public List<FieldPojo> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldPojo> fieldList) {
		this.fieldList = fieldList;
	}

}
