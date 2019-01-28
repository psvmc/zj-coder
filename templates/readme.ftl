<style>
    table {
        border-collapse: collapse;
    }

    td {
        border: 1px grey solid;
    }
</style>
<#list tableList as table >

    <h2>表名：${table.tableName}</h2>
    <h3>说明：${table.tableComment}</h3>
    <table>
        <tr>
            <th>字段</th>
            <th>类型</th>
            <th>说明</th>
        </tr>
        <#list table.fieldList as field >
            <tr>
                <td> ${field.fieldName} </td>
                <td> ${field.fieldType} </td>
                <td> ${field.fieldComment} </td>
            </tr>
        </#list>
    </table>
</#list>
