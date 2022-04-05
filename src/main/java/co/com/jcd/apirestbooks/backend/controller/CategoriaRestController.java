package co.com.jcd.apirestbooks.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;
import co.com.jcd.apirestbooks.backend.service.ICategoriaService;

@RestController // controlador Rest
@RequestMapping("/v1") // url raiz
public class CategoriaRestController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categorias") // operacion Rest con metodo GET
	public CategoriaResponseRest consultaCat() {
		CategoriaResponseRest response = service.buscarCategorias();
		return response;		
	}

}
