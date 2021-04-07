package br.edu.infnet.appvenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appvenda.dao.ProductsDao;
import br.edu.infnet.appvenda.entity.Products;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	
	@Autowired
	private ProductsDao dao;
	
	 
	@ApiOperation(value = "Lista todos os produtos da base ")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Retorna a lista geral")
			}
			)
	@RequestMapping(
			value = "/produtos",
			method = RequestMethod.GET,
			produces = "application/json"
			)
	public List<Products> listAll(){
		Iterable<Products> prods = dao.findAll();
		return (List<Products>) prods;
	}
	
	@RequestMapping( 
				value = "/produtos/{id}",
				method = RequestMethod.GET,
				produces = "application/json"
			)
	public ResponseEntity<Products> 
			obterPeloId (@PathVariable(value = "id") Integer id){
		 Optional<Products> product = dao.findById(id);
		if(!product.isPresent()) {
			return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Products>(product.get(), HttpStatus.OK);
		}
	}
	

	@ApiOperation(value = "Grava um produto na base ")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Retorna o produto gravado"),
					@ApiResponse(code = 403, message = "Voce não tem permissão para gravar")
			}
			)
	
	@RequestMapping( 
			value = "/produtos",
			method = RequestMethod.POST,
			produces = "application/json",
			consumes = "application/json"
			)
	public Products salvar(@RequestBody Products produto) {
		return dao.save(produto); 
	}
	
	

	@RequestMapping( 
				value = "/produtos/{id}",
				method = RequestMethod.PUT,
				produces = "application/json",
				consumes = "application/json"
				
			)
	public ResponseEntity<Products> 
			alterar(
					@PathVariable(value = "id") Integer id,
					@RequestBody Products produto
					){
		
		if(produto == null) {
			return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
		} else {
			Optional<Products> product = dao.findById(id);
			Products productEditado = dao.save(product.get());
			return new ResponseEntity<Products>(productEditado, HttpStatus.ACCEPTED);
		}
	}
	
	
	
	@RequestMapping( 
			value = "/produtos/{id}",
			method = RequestMethod.DELETE,
			produces  = "application/json"
		)
	public ResponseEntity<Products> 
		deletar(
				@PathVariable(value = "id") Integer id
				){
		dao.deleteById(id);
	
		return new ResponseEntity<Products>(HttpStatus.NO_CONTENT);
	}


	public ProductsDao getDao() {
		return dao;
	}


	public void setDao(ProductsDao dao) {
		this.dao = dao;
	}
}