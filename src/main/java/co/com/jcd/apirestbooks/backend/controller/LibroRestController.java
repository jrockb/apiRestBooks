package co.com.jcd.apirestbooks.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jcd.apirestbooks.backend.model.Libro;
import co.com.jcd.apirestbooks.backend.response.LibroResponseRest;
import co.com.jcd.apirestbooks.backend.service.ILibroService;

@RestController
@RequestMapping("/v1")
public class LibroRestController {
	
	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/libros")
	public ResponseEntity<LibroResponseRest> buscarLibros() {
		return libroService.buscarLibros();
	}
	
	@GetMapping("/libros/{id}")
	public ResponseEntity<LibroResponseRest> buscarLibrosPorId(@PathVariable Long id){
		return libroService.buscarLibrosPorId(id);
	}
	
	@PostMapping("/libros")
	public ResponseEntity<LibroResponseRest> guardarLibros(@RequestBody Libro libro){
		return libroService.guardarLibros(libro);
	}
	
	@PutMapping("/libros/{id}")
	public ResponseEntity<LibroResponseRest> actualizarLibro(@RequestBody Libro request, @PathVariable Long id){
		ResponseEntity<LibroResponseRest> response = libroService.actualizarLibros(request, id);
		return response;
	}
	
	@DeleteMapping("/libros/{id}")
	public ResponseEntity<LibroResponseRest> eliminarLibro(@PathVariable Long id){
		ResponseEntity<LibroResponseRest> response = libroService.eliminarLibros(id);
		return response;
	}
	

}
