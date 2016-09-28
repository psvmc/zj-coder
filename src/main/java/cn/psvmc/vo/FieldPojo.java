/**
 * 
 */
package cn.psvmc.vo;

/**
 * @文件名：FieldPojo.java
 * @作者：张剑
 * @创建时间：2014-1-24
 */
public class FieldPojo {
	private String fieldName;// 表中字段名
	private String methodName;// 对应的方法名
	private String fieldComment;// 表中字段的描述
	private String fieldType;// 表中字段的类型
	private String attributeType;// 对应实体类的类型
	private int isKey;// 是否为主键
	private int isIncrease;// 是否自增长

	public String getFieldName() {
		return fieldName;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldComment() {
		return fieldComment;
	}

	public void setFieldComment(String fieldComment) {
		this.fieldComment = fieldComment;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getIsKey() {
		return isKey;
	}

	public void setIsKey(int isKey) {
		this.isKey = isKey;
	}

	public int getIsIncrease() {
		return isIncrease;
	}

	public void setIsIncrease(int isIncrease) {
		this.isIncrease = isIncrease;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public String toString() {
		return "FieldPojo [fieldName=" + fieldName + ", methodName=" + methodName + ", fieldComment=" + fieldComment + ", fieldType=" + fieldType + ", attributeType=" + attributeType + ", isKey=" + isKey + ", isIncrease=" + isIncrease + "]";
	}

}
