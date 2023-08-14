package com.cibertec.daw1cl3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.daw1cl3.business.ProductoService;
import com.cibertec.daw1cl3.model.Producto;

@Controller
public class ProductoController {


	@Autowired
	private ProductoService service;
	
	///// Implementamos nuestros metodos :
	
	// 1. Muestra la lista de productos
	@GetMapping("/") //en la ruta principal , getMapping 
	public String listadoProductos(Model model) {
		model.addAttribute("listaProductos", service.listaProducto());
		return "index";  //nos devuelve la plantilla index
	}
	
	//2. para un nuevo registro de productos
	@GetMapping("/nuevoProducto") //formulario para registrar nuevo producto
	public String registroProductoFormulario(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "registraProducto";  
	}
	
	//3. la accion del registro de productos, postmapping porque es un envio de datos
		@PostMapping("/guardarProducto") //formulario para registrar nuevo producto
		public String registroProducto(@ModelAttribute("producto") Producto producto) {  //recibe el obj como atributo
			service.registraProducto(producto);
			return "redirect:/";  
			//nos regresa al index
		}
		
	//4. formulario para actualizar producto
		@GetMapping("/actualizarProducto/{id}") //recibe un parametro que es un id 
		public String actualizaProductoFormulario(@PathVariable(value="id") int id, Model model) {
			Producto producto = service.listaProductoPorId(id); //obtengo un obj especifico a partir del service
			model.addAttribute("producto", producto); //coloca sus datos en cada caja de texto
			return "actualizaProducto";  
		}
	
	//5. la accion del eliminar productos, postmapping porque es un envio de datos
		@GetMapping("/eliminarProducto/{id}")
		public String eliminaProducto(@PathVariable(value="id") int id) { 
			service.eliminarProducto(id);
			return "redirect:/";  
			//nos regresa al index
		}
}
