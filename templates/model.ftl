package ${namespace};

import java.util.Map;
import java.util.TreeMap;

import zj.jfinalExt.ZJ_Db;
import zj.utils.ZJ_SqlUtils;
import zj.vo.PageVo;
import zj.vo.ui.EasyuiDatagrid;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

@SuppressWarnings("serial")
public class ${tablePojo.className} extends Model<${tablePojo.className}> {
	Logger logger = Logger.getLogger(Object.class);
	public static final ${tablePojo.className} dao = new ${tablePojo.className}();

	public EasyuiDatagrid datagrid(PageVo page) {
		EasyuiDatagrid dataGrid = new EasyuiDatagrid();
		String sql = "select * from ${tablePojo.tableName} t";
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("name", page.getName());
		String totalSql = ZJ_SqlUtils.getTotalSql(page, sql, map);
		Page<Record> records = Db.paginate(page.getPage(), page.getRows(), ZJ_SqlUtils.getSqlSelect(totalSql), ZJ_SqlUtils.getSqlExceptSelect(totalSql));
		dataGrid.setRows(records.getList());
		dataGrid.setTotal((long) records.getTotalRow());
		return dataGrid;
	}

}