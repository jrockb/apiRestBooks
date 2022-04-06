package co.com.jcd.apirestbooks.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jcd.apirestbooks.backend.model.Categoria;
import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;
import co.com.jcd.apirestbooks.backend.service.ICategoriaService;

@RestController // controlador Rest
@RequestMapping("/v1") // url raiz (localhost:8080/v1/)
public class CategoriaRestController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categorias") // operacion Rest con metodo GET (localhost:8080/v1/categorias)
	public ResponseEntity<CategoriaResponseRest> consultaCat() { // ResponseEntity permite usar los códigos de status de HTTP
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();
		return response;		
	}
	
	@GetMapping("/categorias/{id}") // {id} es un parámetro variable
	public ResponseEntity<CategoriaResponseRest> consultaPorId(@PathVariable Long id){ //@PathVariable indica la variable que viene por la URI
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategoriasPorId(id);
		return response;
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> crear(@RequestBody Categoria request){ // por el cueerpo de la petición vendra un objeto de tipo Categoria
		ResponseEntity<CategoriaResponseRest> response = service.crear(request);
		return response;
	}
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> actualizar(@RequestBody Categoria request, @PathVariable Long id){
		ResponseEntity<CategoriaResponseRest> response = service.actualizar(request, id);
		return response;
	}
	
}
