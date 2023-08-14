package com.cibertec.daw1cl3.business.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.cibertec.daw1cl3.business.ProductoService;
import com.cibertec.daw1cl3.dao.ProductoRepository;
import com.cibertec.daw1cl3.model.Producto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{

	private ProductoRepository repository;
	
	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public void registraProducto(Producto producto) {
		repository.save(producto);	
		
	}

	@Override
	public Producto listaProductoPorId(int id) {
		// 
				Optional<Producto> objeto=repository.findById(id);  // if(objeto == null) --> Optional
				Producto producto=null;
				//
				if(objeto.isPresent()) {   //if(objeto != null) --> isPresent
					producto=objeto.get();
				}else {
					// Manda un mensaje como excepciones - java lang
					throw new RuntimeException("Producto con el id "+ id+ " no fue encontrado.");
				}
				return producto;
	}

	@Override
	public void eliminarProducto(int id) {
		repository.deleteById(id);
		
	}

}
