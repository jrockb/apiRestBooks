package co.com.jcd.apirestbooks.backend.service;

import org.springframework.http.ResponseEntity;

import co.com.jcd.apirestbooks.backend.model.Categoria;
import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;

public interface ICategoriaService {
	
	public ResponseEntity<CategoriaResponseRest> buscarCategorias();

	public ResponseEntity<CategoriaResponseRest> buscarCategoriasPorId(Long id);

	public ResponseEntity<CategoriaResponseRest> crear(Categoria request);
	
	public ResponseEntity<CategoriaResponseRest> actualizar(Categoria categoria, Long id);
	

}
