package com.shoppingCart;

import com.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingCartApplication.class, args);
	}
	/*@Bean
	CommandLineRunner commandLineRunner(ShoppingCartRepository shoppingCartRepository){
		return args -> {

		};*/


}
