package co.com.jcd.apirestbooks.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.jcd.apirestbooks.backend.model.Libro;
import co.com.jcd.apirestbooks.backend.model.dao.ILibroDao;
import co.com.jcd.apirestbooks.backend.response.LibroResponseRest;

@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
	private ILibroDao libroDao;	
	
	private LibroResponseRest libroResponse;

	@Override
	@Transactional(readOnly = true) 
	public ResponseEntity<LibroResponseRest> buscarLibros() {	
		libroResponse = new LibroResponseRest();
		try {
			libroResponse.getLibroResponse().setLibro((List<Libro>) libroDao.findAll());
			if(!libroResponse.getLibroResponse().getLibro().isEmpty()) {
				libroResponse.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			} else {
				libroResponse.setMetadata("Respuesta ok", "01", "No se encontraron libros");
			}
		} catch(Exception e) {
			libroResponse.setMetadata("Respuesta no ok", "-1", "Error buscando libros");
			return new ResponseEntity<>(libroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(libroResponse, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<LibroResponseRest> buscarLibrosPorId(Long id) {
		libroResponse = new LibroResponseRest();
		try {
			Optional<Libro> libro= libroDao.findById(id);
			List<Libro> listaLibro  = new ArrayList<>();
			if(libro.isPresent()) {
				listaLibro.add(libro.get());				
				libroResponse.getLibroResponse().setLibro(listaLibro);
				libroResponse.setMetadata("Respuesta ok", "00", "Respuesta exitosa");				
			} else {
				libroResponse.setMetadata("Respuesta ok", "01", "No se encontraron libros para ese ID");
			}
		} catch(Exception e) {
			libroResponse.setMetadata("Respuesta no ok", "-1", "Error buscando libros");
			return new ResponseEntity<>(libroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(libroResponse, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> guardarLibros(Libro libro) {
		libroResponse = new LibroResponseRest();
		List<Libro> listaLibro  = new ArrayList<>();
		try {
			Libro libroGuardado = libroDao.save(libro);
			listaLibro.add(libroGuardado);
			libroResponse.getLibroResponse().setLibro(listaLibro);
			if(!libroResponse.getLibroResponse().getLibro().isEmpty()) {
				libroResponse.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			}
		} catch(Exception e) {
			libroResponse.setMetadata("Respuesta no ok", "-1", "Error buscando libros");
			return new ResponseEntity<>(libroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<>(libroResponse, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> actualizarLibros(Libro libro, Long id) {
		libroResponse = new LibroResponseRest();
		List<Libro> listaLibro  = new ArrayList<>();
		try {
			Optional<Libro> libroBuscado= libroDao.findById(id);
			if(libroBuscado.isPresent()) {
				libroBuscado.get().setDescripcion(libro.getDescripcion());
				libroBuscado.get().setNombre(libro.getNombre());
				libroBuscado.get().setCategoria(libro.getCategoria());
				Libro libroActualizar = libroDao.save(libroBuscado.get());
				if(libroActualizar != null) {
					listaLibro.add(libroActualizar);
					libroResponse.getLibroResponse().setLibro(listaLibro);	
					libroResponse.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
				}
			} else {
				libroResponse.setMetadata("Respuesta no ok", "-1", "Respuesta incorrecta");
				return new ResponseEntity<>(libroResponse, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			libroResponse.setMetadata("Respuesta no ok", "-1", "Error buscando libros");
			return new ResponseEntity<>(libroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(libroResponse, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> eliminarLibros(Long id) {
		libroResponse = new LibroResponseRest();
		try {
			libroDao.deleteById(id);
			libroResponse.setMetadata("Respuesta ok", "00", "libro eliminado");
		} catch(Exception e) {
			libroResponse.setMetadata("Respuesta no ok", "-1", "libro no eliminado");
			e.getStackTrace();
			return new ResponseEntity<LibroResponseRest>(libroResponse, HttpStatus.INTERNAL_SERVER_ERROR);			

		}
		return new ResponseEntity<>(libroResponse, HttpStatus.OK);
	}
	
	

}
