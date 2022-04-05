package co.com.jcd.apirestbooks.backend.response;

import java.util.List;

import co.com.jcd.apirestbooks.backend.model.Categoria;

public class CategoriaResponse {
	
	private List<Categoria> categoria;

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}	
	

}
