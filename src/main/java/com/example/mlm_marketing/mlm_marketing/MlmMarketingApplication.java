package com.example.mlm_marketing.mlm_marketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.mlm_marketing.mlm_marketing.controller.SalesController;

@SpringBootApplication
@Configuration
@ComponentScan({"com.example.mlm_marketing.mlm_marketing"})
public class MlmMarketingApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MlmMarketingApplication.class, args);
		
		/*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.mlm_marketing.mlm_marketing.controller");
		SalesController controller = (SalesController)applicationContext.getBean("salesController");
		*/
		//Object obj = applicationContext.getAttribute("SalesPerson");
		System.out.println("Hello World");
	}
	
}
