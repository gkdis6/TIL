package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ioc.LgTV;
import ioc.SamsungTV;
import ioc.TV;

@Configuration
public class TVConfig {
	@Bean
	public TV lgCreate() {
		LgTV tv = new LgTV();
		
		return tv;
	}
	
	@Bean(name="samsung")
	public TV SamsungCreate() {
		return new SamsungTV();
	}
	
}
