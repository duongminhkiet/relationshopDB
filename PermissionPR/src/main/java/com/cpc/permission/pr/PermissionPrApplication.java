package com.cpc.permission.pr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cpc.permission.pr.test.DataTest;

@SpringBootApplication
public class PermissionPrApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PermissionPrApplication.class, args);
	}
	@Autowired
	DataTest dataTest;
	@Override
	public void run(String... args) throws Exception {
		dataTest.createUserDonViChucVuData();
	}

}
