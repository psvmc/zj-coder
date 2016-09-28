package cn.psvmc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.psvmc.vo.TablePojo;

/**
 * @文件名：ZJ_DbUtils.java
 * @作用：对DbUtils的二次封装
 * @作者：张剑
 * @创建时间：2014-2-5
 */
public class ZJ_DbUtils {
	private QueryRunner queryRunner = new QueryRunner();

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClassName = "com.mysql.jdbc.Driver";
		String host = ZJ_ConfigUtils.getProperty("host");
		String port = ZJ_ConfigUtils.getProperty("port");
		String database = ZJ_ConfigUtils.getProperty("database");
		String charset = ZJ_ConfigUtils.getProperty("charset");
		String url = String.format("jdbc:mysql://%s:%s/%s?characterEncoding=%s", host, port, database, charset);
		String username = ZJ_ConfigUtils.getProperty("username");
		String password = ZJ_ConfigUtils.getProperty("password");
		Connection connection = null;
		Class.forName(driverClassName);
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @return 受影响的行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int update(String sql) throws ClassNotFoundException, SQLException {
		return update(sql, null);
	}

	/**
	 * 执行sql语句 <code> 
	 * executeUpdate("update user set username = 'kitty' where username = ?", "hello kitty"); 
	 * </code>
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return 受影响的行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int update(String sql, Object param) throws ClassNotFoundException, SQLException {
		return update(sql, new Object[] { param });
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 受影响的行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int update(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		int affectedRows = 0;

		if (params == null) {
			affectedRows = queryRunner.update(conn, sql);
		} else {
			affectedRows = queryRunner.update(conn, sql, params);
		}
		return affectedRows;
	}

	/**
	 * 执行批量sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            二维参数数组
	 * @return 受影响的行数的数组
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int[] updateBatch(String sql, Object[][] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		int[] affectedRows = new int[0];
		affectedRows = queryRunner.batch(conn, sql, params);
		return affectedRows;
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql
	 *            sql语句
	 * @param columnName
	 *            列名
	 * @return 结果对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Object queryForObject(String sql, String columnName) throws ClassNotFoundException, SQLException {
		return queryForOjbect(sql, columnName, null);
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql
	 *            sql语句
	 * @param columnName
	 *            列名
	 * @param param
	 *            参数
	 * @return 结果对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Object queryForObject(String sql, String columnName, Object param) throws ClassNotFoundException, SQLException {
		return queryForOjbect(sql, columnName, new Object[] { param });
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql
	 *            sql语句
	 * @param columnName
	 *            列名
	 * @param params
	 *            参数数组
	 * @return 结果对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object queryForOjbect(String sql, String columnName, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Object object = null;
		if (params == null) {
			object = queryRunner.query(conn, sql, new ScalarHandler(columnName));
		} else {
			object = queryRunner.query(conn, sql, new ScalarHandler(columnName), params);
		}
		return object;
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql
	 *            sql语句
	 * @param columnIndex
	 *            列索引
	 * @return 结果对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Object queryForObject(String sql, int columnIndex) throws ClassNotFoundException, SQLException {
		return queryForObject(sql, columnIndex, null);
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql
	 *            sql语句
	 * @param columnIndex
	 *            列索引
	 * @param param
	 *            参数
	 * @return 结果对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Object queryForObject(String sql, int columnIndex, Object param) throws ClassNotFoundException, SQLException {
		return queryForObject(sql, columnIndex, new Object[] { param });
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql
	 *            sql语句
	 * @param columnIndex
	 *            列索引
	 * @param params
	 *            参数数组
	 * @return 结果对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object queryForObject(String sql, int columnIndex, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Object object = null;
		if (params == null) {
			object = queryRunner.query(conn, sql, new ScalarHandler(columnIndex));
		} else {
			object = queryRunner.query(conn, sql, new ScalarHandler(columnIndex), params);
		}
		return object;
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成对象
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @return 对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public <T> T queryFirst(Class<T> entityClass, String sql) throws ClassNotFoundException, SQLException {
		return queryFirst(entityClass, sql, null);
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成对象
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return 对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public <T> T queryFirst(Class<T> entityClass, String sql, Object param) throws ClassNotFoundException, SQLException {
		return queryFirst(entityClass, sql, new Object[] { param });
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成对象
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T queryFirst(Class<T> entityClass, String sql, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Object object = null;
		if (params == null) {
			object = queryRunner.query(conn, sql, new BeanHandler(entityClass));
		} else {
			object = queryRunner.query(conn, sql, new BeanHandler(entityClass), params);
		}
		return (T) object;
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成Map对象
	 * 
	 * @param sql
	 *            sql语句
	 * @return 封装为Map的对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Map<String, Object> queryFirst(String sql) throws ClassNotFoundException, SQLException {
		return queryFirst(sql, null);
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成Map对象
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return 封装为Map的对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Map<String, Object> queryFirst(String sql, Object param) throws ClassNotFoundException, SQLException {
		return queryFirst(sql, new Object[] { param });
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成Map对象
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 封装为Map的对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Map<String, Object> queryFirst(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Map<String, Object> map = null;
		if (params == null) {
			map = (Map<String, Object>) queryRunner.query(conn, sql, new MapHandler());
		} else {
			map = (Map<String, Object>) queryRunner.query(conn, sql, new MapHandler(), params);
		}
		return map;
	}

	/**
	 * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
	 * 
	 * @param sql
	 *            sql语句
	 * @return 查询结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Map<String, Object>> queryForList(String sql) throws ClassNotFoundException, SQLException {
		return queryForList(sql, null);
	}

	/**
	 * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return 查询结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Map<String, Object>> queryForList(String sql, Object param) throws ClassNotFoundException, SQLException {
		return queryForList(sql, new Object[] { param });
	}

	/**
	 * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 查询结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Map<String, Object>> queryForList(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (params == null) {
			list = (List<Map<String, Object>>) queryRunner.query(conn, sql, new MapListHandler());
		} else {
			list = (List<Map<String, Object>>) queryRunner.query(conn, sql, new MapListHandler(), params);
		}
		return list;
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @return 查询结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public <T> List<T> queryForList(Class<T> entityClass, String sql) throws ClassNotFoundException, SQLException {
		return queryForList(entityClass, sql, null);
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return 查询结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public <T> List<T> queryForList(Class<T> entityClass, String sql, Object param) throws ClassNotFoundException, SQLException {
		return queryForList(entityClass, sql, new Object[] { param });
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 查询结果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> queryForList(Class<T> entityClass, String sql, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		List<T> list = new ArrayList<T>();
		if (params == null) {
			list = (List<T>) queryRunner.query(conn, sql, new BeanListHandler(entityClass));
		} else {
			list = (List<T>) queryRunner.query(conn, sql, new BeanListHandler(entityClass), params);
		}
		return list;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "SELECT table_name tableName,TABLE_COMMENT tableComment FROM INFORMATION_SCHEMA. TABLES WHERE table_schema = 'yf_ffzx'";
		TablePojo tablePojo = new ZJ_DbUtils().queryFirst(TablePojo.class, sql);
		System.out.println(tablePojo);
	}

}
