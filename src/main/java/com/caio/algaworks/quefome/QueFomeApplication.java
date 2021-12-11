package com.caio.algaworks.quefome;

import com.caio.algaworks.quefome.jpa.CadastroCozinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class QueFomeApplication {



	public static void main(String[] args) {
		SpringApplication.run(QueFomeApplication.class, args);
	}

}
