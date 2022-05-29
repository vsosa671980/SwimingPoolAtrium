package com.piscina.atrium;

import com.piscina.atrium.models.Subscription;
import com.piscina.atrium.resources.Tiempo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piscina.atrium.models.Bonos;

import java.util.ArrayList;
import java.util.Timer;

@SpringBootApplication
public class SwimingApplication {

	public static void main(String[] args) {

		SpringApplication.run(SwimingApplication.class, args);

		Tiempo tiempo = new Tiempo();

		tiempo.exectask();
	}




	

}
