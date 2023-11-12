package com.timetracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.*;


@SpringBootApplication
@ComponentScan(basePackages = {"com.timetracker"})
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		System.setProperty("java.naming.provider.url", "dns://8.8.8.8");
		SpringApplication.run(DemoApplication.class, args);
	}

}
