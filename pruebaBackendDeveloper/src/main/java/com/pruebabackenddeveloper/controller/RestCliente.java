package com.pruebabackenddeveloper.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class RestCliente {

	@GetMapping
	public ResponseEntity<Object> getCliente(@RequestParam(name = "tDoc") String tDocumento,
			@RequestParam(name = "nDoc") String nDocumento) {

		Map<String, String> response = new HashMap<>();

		if (validateTipoDoc(tDocumento) || validateNumDoc(nDocumento)) {
			response.put("mensaje", "Tipo de documento o numero no valido");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.put("primerNombre", "Cristian");
			response.put("segundooNombre", "Camilo");
			response.put("primerApellido", "Gonzalez");
			response.put("segundoApellido", "Manrique");
			response.put("telefono", "3117852654");
			response.put("direccion", "Calle 4D #78-25");
			response.put("ciudadResidencia", "Bogota");
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	private boolean validateTipoDoc(String tDocumento) {
		return ((!tDocumento.equalsIgnoreCase("C") && !tDocumento.equalsIgnoreCase("P"))) ? true : false;
	}

	private boolean validateNumDoc(String nDocumento) {
		return (!nDocumento.equalsIgnoreCase("23445322")) ? true : false;
	}

}