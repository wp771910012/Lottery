package com.im.lottery.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.github.pagehelper.PageHelper;
@Configuration
@MapperScan(basePackages="com.im.lottery.persistence")
public class MybatisConfiguation {
	
	@Autowired 
	private DataSource dataSource;
	//分页插件
			@Bean
		    public Interceptor pageHelper(){
		    	 //分页插件
		        PageHelper pageHelper = new PageHelper();
		        Properties properties = new Properties();
		        properties.setProperty("reasonable", "false");
		        properties.setProperty("supportMethodsArguments", "true");
		        properties.setProperty("returnPageInfo", "check");
		        properties.setProperty("params", "count=countSql");
		        pageHelper.setProperties(properties);
		        return pageHelper;        
		    }
			@Bean
		    public SqlSessionFactoryBean sqlSessionFactory(){
		        SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
		        sqlSessionFactory.setDataSource(dataSource);
		        sqlSessionFactory.setTypeAliasesPackage("com.im.lottery.entity");
		        
		      	sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		        
		        Interceptor[] interceptors=new Interceptor[1];
		        interceptors[0]=pageHelper();
		        sqlSessionFactory.setPlugins(interceptors);
		        return sqlSessionFactory;
		    }
}
