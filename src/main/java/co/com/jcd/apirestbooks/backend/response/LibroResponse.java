package co.com.jcd.apirestbooks.backend.response;

import java.util.List;

import co.com.jcd.apirestbooks.backend.model.Libro;

public class LibroResponse {
	
	private List<Libro> libro;

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}	
	

}
