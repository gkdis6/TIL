package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ioc.TV;

@SpringBootApplication
public class HelloAppApplication {

	public static void main(String[] args) {
		//자동으로 DI
		//SpringApplication.run(HelloAppApplication.class, args);
		
		//ioc 컨테이너 생성
		//명시적 룩업
		ApplicationContext context = new AnnotationConfigApplicationContext(TVConfig.class);
		
		//LgTV Bean 가져오기
		TV lg = (TV)context.getBean("lgCreate");
		lg.powerOn();
		lg.volumeDown();
		lg.volumeUp();
		lg.powerOff();
		
		//SamsungTV Bean 가져오기
		TV samsung = (TV)context.getBean("samsung");
		samsung.powerOn();
		samsung.volumeDown();
		samsung.volumeUp();
		samsung.powerOff();
	}

}
