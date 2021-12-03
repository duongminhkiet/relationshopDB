package com.cpc.permission.pr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cpc.permission.pr1.test.DataTest;

@SpringBootApplication
public class PermissionPr1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PermissionPr1Application.class, args);
	}
	@Autowired
	DataTest dataTest;
	@Override
	public void run(String... args) throws Exception {
		dataTest.createUserDonViChucVuData();
	}

}
