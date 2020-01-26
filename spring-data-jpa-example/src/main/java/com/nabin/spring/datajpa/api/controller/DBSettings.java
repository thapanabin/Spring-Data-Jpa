package com.nabin.spring.datajpa.api.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration// this will create the bean with all the properties set
@ConfigurationProperties("db")//to group all the valuse and made it avaiable to one instance
public class DBSettings {

	private String connection;
	private String host;
	private int port;
}
