package com.pruebabackenddeveloper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pruebabackenddeveloper.controller.RestCliente;

@SpringBootTest
public class RestClienteTest {
	
	@Autowired
	private RestCliente client;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);

		client = new RestCliente();
	}

	@Test
	public void given_valid_tdoc_When_execute_Then_return_ok_response() {
		assertEquals(client.getCliente("C", "23445322"), createResponse());
	}

	@Test
	public void given_not_valid_tdoc_When_execute_Then_return_ok_response() {
		assertEquals(client.getCliente("D", "23445322"), createWrongResponse());
	}

	private ResponseEntity<Object> createResponse() {
		Map<String, String> response = new HashMap<>();

		response.put("primerNombre", "Cristian");
		response.put("segundooNombre", "Camilo");
		response.put("primerApellido", "Gonzalez");
		response.put("segundoApellido", "Manrique");
		response.put("telefono", "3117852654");
		response.put("direccion", "Calle 4D #78-25");
		response.put("ciudadResidencia", "Bogota");

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	private ResponseEntity<Object> createWrongResponse() {
		Map<String, String> response = new HashMap<>();

		response.put("mensaje", "Tipo de documento o numero no valido");
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}