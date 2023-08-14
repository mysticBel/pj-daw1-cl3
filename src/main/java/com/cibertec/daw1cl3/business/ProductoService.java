package com.cibertec.daw1cl3.business;

import java.util.List;

import com.cibertec.daw1cl3.model.Producto;

public interface ProductoService {
	
	List<Producto> listaProducto();
	void registraProducto(Producto producto);
	Producto listaProductoPorId(int id);
	void eliminarProducto(int id);
}
