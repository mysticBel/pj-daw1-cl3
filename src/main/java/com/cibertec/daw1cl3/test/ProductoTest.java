package com.cibertec.daw1cl3.test;

import com.cibertec.daw1cl3.model.Producto;

public class ProductoTest {

	public static void main(String[] args) {
		
		Producto prod1 = new Producto();
		prod1.setId(2);
		prod1.setNombre("Pastel de Chocolate");
		prod1.setPrecio(35.50);
		prod1.setCantidad(10);
		
		System.out.println("Datos del producto -> " + prod1);
	}

}
