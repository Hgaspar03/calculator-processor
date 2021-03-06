package com.hgaspar.CalculatorProcessor;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hgaspar.calculator.consumer.CalculatorConsumer;



@SpringBootApplication
@EnableScheduling
public class CalculatorProcessorApplication {
	
	
	 @Profile("usage_message")
	    @Bean
	    public CommandLineRunner usage() {
	        return args -> {
	        	
	            System.out.println(
	            	"This app uses Spring Profiles to control its behavior");
	            System.out.println("Sample usage: java -jar"
	            		+ "  CalculatorProcessor.0.0.1.SNAPSHOT.jar"
	            		+ " --spring.profiles.active=calculator_exchange,server");
	        };
	    }

	    @Profile("!usage_message")
	    @Bean
	    public CommandLineRunner tutorial() {
	        return new CalculatorConsumer();
	    }

	    @Bean
	    public Jackson2JsonMessageConverter converter() {
	        return new Jackson2JsonMessageConverter();
	    }

	public static void main(String[] args) {
		SpringApplication.run(CalculatorProcessorApplication.class, args);
		
		System.out.println("Iniciando o processador de calculo...");
	

	}

}
