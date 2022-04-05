package co.com.jcd.apirestbooks.backend.model.dao;

import org.springframework.data.repository.CrudRepository; // clase que permite implementar los métodos CRUD

import co.com.jcd.apirestbooks.backend.model.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long>{ // los parametros son: clase entidad y tipo de dato que devuelve la llave primaria

}
