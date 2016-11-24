package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
@EnableDiscoveryClient
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkenServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkenServerApplication.class, args);
	}
}
