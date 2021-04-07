package br.edu.infnet.appvenda.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.entity.Products;

@Repository
public interface ProductsDao extends CrudRepository<Products, Integer> {
	
	
}