package com.cy.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix="page.config") //告诉springboot框架读取配置文件中的指定前缀：page.config
@Configuration//描述此类为配置类，交给Spring去管理
public class PaginationProperties {
	
	private  Integer pageSize = 10;
	
	public Integer getPageStratIndex(Integer pageCurrent) {
		return (pageCurrent-1)*pageSize;
	}

}
