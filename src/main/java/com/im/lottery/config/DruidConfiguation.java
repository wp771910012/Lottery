package com.im.lottery.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class DruidConfiguation {
	@Bean(initMethod="init",destroyMethod="close")
	@ConfigurationProperties(prefix="datasource.druid")
	public DataSource dataSource() { 
		DruidDataSource druidDataSource=new DruidDataSource();
		try {
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean srb=new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		srb.addInitParameter("loginUsername","user");// 用户名
		srb.addInitParameter("loginPassword", "1234");// 密码
		srb.addInitParameter("resetEnable", "false");// 禁用HTML页面上的"Reset All"功能
		return srb;
	}
	@Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

}
