package co.com.jcd.apirestbooks.backend.service;


import java.util.List;

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

}
