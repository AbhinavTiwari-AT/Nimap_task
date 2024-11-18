package com.abhinav.nimap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NimapTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapTaskApplication.class, args);
	}
	

	//Using ModelMapper
    @Bean   
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
