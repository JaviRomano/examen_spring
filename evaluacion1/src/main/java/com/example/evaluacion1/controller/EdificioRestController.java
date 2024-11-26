package com.example.evaluacion1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluacion1.entity.Edificio;
import com.example.evaluacion1.service.IEdificioService;

@RestController
@RequestMapping("/api/edificios")
public class EdificioRestController {
	
	@Autowired
	private IEdificioService edificioService;
	
	// Listar todos los edificios
	@GetMapping
	public List<Edificio> listarEdificios(){
		return edificioService.getAllEdificios();
	}
	
	// Buscar un edificio por ID
	@GetMapping("/{id}")
	public ResponseEntity<Edificio> obtenerEdificioPorId(@PathVariable Long id) {
		Optional<Edificio> edificio = edificioService.findById(id);
		return edificio.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Actualizar un edificio
	@PutMapping("/{id}")
	public ResponseEntity<Edificio> actualizarEdificio(@PathVariable Long id, @RequestBody Edificio DetallesEdificio) {
		Optional<Edificio> edificioExistente = edificioService.findById(id);
		if (edificioExistente.isPresent()) {
			Edificio edificio = edificioExistente.get();
			edificio.setDenominacion(DetallesEdificio.getDenominacion());
			edificio.setnPlantas(DetallesEdificio.getnPlantas());
			edificio.setCalle(DetallesEdificio.getCalle());
			edificio.setHabitable(DetallesEdificio.isHabitable());
			edificio.setTipo(DetallesEdificio.getTipo());
			Edificio actualizado = edificioService.save(edificio);
			return ResponseEntity.ok(actualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//	2. Configuración para Probarlo en Postman
//	a. Listar todos los edificios
//
//	    URL: GET http://localhost:8080/api/edificios
//	    Método HTTP: GET
//	    Resultado esperado: Una lista de edificios en formato JSON.


	
//	b. Buscar un edificio por ID
//
//    URL: GET http://localhost:8080/api/edificios/{id}
//    Reemplaza {id} por un valor válido, como 1:
//        Ejemplo: GET http://localhost:8080/api/edificios/1
//    Método HTTP: GET
//    Resultado esperado:
//        Si el edificio existe, devuelve los detalles del edificio.
//        Si no existe, devuelve un código HTTP 404 Not Found.
	
	
	
//	2. Configura una Nueva Solicitud en Postman
//
//    Abre Postman.
//    Haz clic en el botón "New" y selecciona "Request".
//    Nombra tu solicitud (por ejemplo: "Actualizar Edificio") y selecciona una colección para guardarla (opcional).
//
//3. Selecciona el Método HTTP PUT
//
//    En el selector de métodos, elige PUT.
//
//4. Especifica la URL del Endpoint
//
//    La URL del endpoint para actualizar un edificio es:
//
//http://localhost:8080/api/edificios/{id}
//
//Reemplaza {id} con el ID del edificio que deseas actualizar. Por ejemplo:
//
//    http://localhost:8080/api/edificios/1
//
//5. Añade el Cuerpo de la Solicitud
//
//    Cambia a la pestaña Body en Postman.
//    Selecciona la opción raw.
//    En el menú desplegable al lado de Text, selecciona JSON.
//    Introduce el cuerpo de la solicitud en formato JSON. Por ejemplo:
//
//{
//    "denominacion": "Edificio Renovado",
//    "nPlantas": 3,
//    "calle": "Calle Actualizada",
//    "habitable": true,
//    "tipo": "v"
//}
	
}
