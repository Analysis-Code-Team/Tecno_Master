package com.tecnomaster.Analisysis_Code;

import com.tecnomaster.Analisysis_Code.Entities.Empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class AnalisysisCodeApplication {


	@GetMapping("/Hello")
	public String hello(){
		return "Hola Mundo";
	}

	@GetMapping("/Test")
	public String test(){
		Empresa emp = new Empresa("CartonColombia", "Calle", "123345", "12234");
		emp.setNombre("Carton");
		return emp.getNombre();
	}

	public static void main(String[] args) {

		SpringApplication.run(AnalisysisCodeApplication.class, args);
	}

}
