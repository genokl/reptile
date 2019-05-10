package cn.zgyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
public class ReptileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReptileApplication.class, args);
	}

}

