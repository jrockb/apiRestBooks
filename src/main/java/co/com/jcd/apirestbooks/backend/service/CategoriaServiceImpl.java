package co.com.jcd.apirestbooks.backend.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.jcd.apirestbooks.backend.model.Categoria;
import co.com.jcd.apirestbooks.backend.model.dao.ICategoriaDao;
import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;

@Service
public class CategoriaServiceImpl  implements ICategoriaService{
	
	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional(readOnly = true) // gestionará las transacciones
	public ResponseEntity<CategoriaResponseRest> buscarCategorias() {
		log.info("inicio metodo buscarCategorias()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		try {
			List<Categoria> categoria = (List<Categoria>) categoriaDao.findAll();
			response.getCategoriaResponse().setCategoria(categoria);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch(Exception e) {
			response.setMetadata("Respuesta no ok", "-1", "Respuesta incorrecta");
			log.error("error al consultar categorias: ", e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); // devuelve 500
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK); // devuelve 200
	}

	@Override
	@Transactional(readOnly = true) // solo lectura
	public ResponseEntity<CategoriaResponseRest> buscarCategoriasPorId(Long id) {
		log.info("inicio metodo buscarCategoriasPorId()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> listCategoria = new ArrayList<Categoria>();
		try {
			// el repositorio necesita un objeto Optional
			Optional<Categoria> categoria = categoriaDao.findById(id);
			if(categoria.isPresent()) { // si la búsqueda devuelve un resultado
				listCategoria.add(categoria.get()); // obtiene el objeto de tipo categoria y lo agrega a la lista
				response.getCategoriaResponse().setCategoria(listCategoria);
				response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			} else {
				response.setMetadata("Respuesta no ok", "-1", "Respuesta incorrecta");
				log.error("error al consultar categoria");
				return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND); // devuelve 404
			
			}
		} catch(Exception e) {
			response.setMetadata("Respuesta no ok", "-1", "Respuesta incorrecta");
			log.error("error al consultar categorias: ", e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

}
