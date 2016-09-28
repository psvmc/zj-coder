package ${namespace};

import java.io.Serializable;

/**
 * @文件名：${tablePojo.className}${fileNameSuffix}.${fileSuffix}
 * @作用：${tablePojo.tableComment}
 * @作者：张剑
 * @创建时间：${now}
 */

//${tablePojo.tableComment}
public class ${tablePojo.className}${fileNameSuffix} implements Serializable {
	private static final long serialVersionUID = 1L;
	//属性
<#list tablePojo.fieldList as field >
	private ${field.attributeType} ${field.fieldName};//${field.fieldComment}
</#list>
	//构造方法
	public ${tablePojo.className}${fileNameSuffix}() {}
	public ${tablePojo.className}${fileNameSuffix}(<#list tablePojo.fieldList as field >${field.attributeType} ${field.fieldName}<#if field_has_next>,</#if></#list>) {
		<#list tablePojo.fieldList as field >
		this.${field.fieldName}=${field.fieldName};
		</#list>
	}
	//get-set方法
<#list tablePojo.fieldList as field >
	public ${field.attributeType} get${field.methodName}() {
		return ${field.fieldName}; 
	}

	public void set${field.methodName}(${field.attributeType} ${field.fieldName}) {
		this.${field.fieldName} = ${field.fieldName};
	}
	
	<#if ('${field.methodName}'!='${field.methodName?cap_first}')>
	public ${field.attributeType} get${field.methodName?cap_first}() {
		return ${field.fieldName}; 
	}

	public void set${field.methodName?cap_first}(${field.attributeType} ${field.fieldName}) {
		this.${field.fieldName} = ${field.fieldName};
	}
	</#if>
</#list>
	//toString方法
	@Override
	public String toString() {
		return "${tablePojo.className}${fileSuffix} [<#list tablePojo.fieldList as field >${field.fieldName}="+${field.fieldName}+"<#if field_has_next>,</#if></#list>]";
	}

}
