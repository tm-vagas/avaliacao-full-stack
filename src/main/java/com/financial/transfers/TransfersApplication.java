package com.financial.transfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.financial.transfers.entity"})
public class TransfersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransfersApplication.class, args);
	}

}
