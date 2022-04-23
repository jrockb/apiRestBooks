package co.com.jcd.apirestbooks.backend.service;

import org.springframework.http.ResponseEntity;

import co.com.jcd.apirestbooks.backend.model.Libro;
import co.com.jcd.apirestbooks.backend.response.LibroResponseRest;

public interface ILibroService {
	
	public ResponseEntity<LibroResponseRest> buscarLibros();
	
	public ResponseEntity<LibroResponseRest> buscarLibrosPorId(Long id);
	
	public ResponseEntity<LibroResponseRest> guardarLibros(Libro libro);
	
	public ResponseEntity<LibroResponseRest> actualizarLibros(Libro libro, Long id);
	
	public ResponseEntity<LibroResponseRest> eliminarLibros(Long id);	
	
	
}
