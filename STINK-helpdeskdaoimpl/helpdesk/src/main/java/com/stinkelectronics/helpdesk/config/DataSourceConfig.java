package com.stinkelectronics.helpdesk.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:sqlserver://helpdeskstink.cluoanm7zo65.us-east-2.rds.amazonaws.com;database=StinkHelpDeskDB")
				.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.username("admin")
				.password("password")
				.build();
	}
}
