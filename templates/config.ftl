package zj.config;

import zj.interceptor.GlobalInterceptor;
import zj.interceptor.SecurityInterceptor;
import zj.utils.ZJ_PropertyConfig;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.plugin.quartz.QuartzPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.TxByRegex;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;

public class ${fileName} extends JFinalConfig {

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载数据库配置文件
		ZJ_PropertyConfig.me().loadPropertyFile("config.properties");
		// 设定为开发者模式
		me.setDevMode(ZJ_PropertyConfig.me().getPropertyToBoolean("devMode", false));
		me.setViewType(ViewType.FREE_MARKER);
	}

	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add(new HtRoutes()); // 后台路由
		me.add(new QtRoutes()); // 前台路由
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 连接池插件
		ZJ_PropertyConfig config = ZJ_PropertyConfig.me();
		String jdbcUrl = config.getProperty("jdbcUrl");
		String user = config.getProperty("user");
		String password = config.getProperty("password");
		DruidPlugin druid = new DruidPlugin(jdbcUrl, user, password);
		me.add(druid);	
		// 表绑定插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
<#list tableList as field >
		arp.addMapping("${field.tableName}", ${field.className}.class);
</#list>
		me.add(arp);

		// 定时任务插件
		QuartzPlugin quartzPlugin = new QuartzPlugin();
		me.add(quartzPlugin);

	}

	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		me.add(new GlobalInterceptor());
		me.add(new SecurityInterceptor());
		// 配置事务
		me.add(new TxByRegex(".*save.*"));
		me.add(new TxByRegex(".*add.*"));
		me.add(new TxByRegex(".*del.*"));
		me.add(new TxByRegex(".*remove.*"));
		me.add(new TxByRegex(".*edit.*"));
		me.add(new TxByRegex(".*update.*"));

	}

	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
	}

}