package com.bessada;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); //método para criar um contador, será adicionado 1 cada vez que for chamado (com o método incrementAndGet)
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	// Caso seja digitado na url, ?name=Gabriel, irá retornar Hello, Gabriel;
	
	}

//defaultValue é usado para devolver uma resposta quando um paramêtro não for digitado
