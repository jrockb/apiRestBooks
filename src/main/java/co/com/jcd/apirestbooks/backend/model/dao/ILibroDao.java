package co.com.jcd.apirestbooks.backend.model.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.jcd.apirestbooks.backend.model.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long>{

}
