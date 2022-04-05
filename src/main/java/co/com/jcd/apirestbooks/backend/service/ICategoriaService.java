package co.com.jcd.apirestbooks.backend.service;

import org.springframework.http.ResponseEntity;

import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;

public interface ICategoriaService {
	
	public ResponseEntity<CategoriaResponseRest> buscarCategorias();
	

}
