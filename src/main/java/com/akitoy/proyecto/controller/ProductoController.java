package com.akitoy.proyecto.controller;

import com.akitoy.proyecto.model.Producto;
import com.akitoy.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @RequestMapping(value="/lista", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("lista_productos");
        List<Producto> productoList = productoService.getAllProductos();
        model.addObject("productoList" , productoList);

        return model;
    }

    @RequestMapping(value = "/agregarProducto", method = RequestMethod.GET)
    public ModelAndView addProducto(){
        ModelAndView model = new ModelAndView();

        Producto producto = new Producto();
        model.addObject("productoForm", producto);
        model.setViewName("producto_form");

        return model;
    }

    @RequestMapping(value = "/actualizarProducto/{id}", method = RequestMethod.GET)
    public ModelAndView editProducto(@PathVariable long id){
        ModelAndView model = new ModelAndView();

        Producto producto = productoService.getProductoById(id);
        model.addObject("productoForm", producto);
        model.setViewName("producto_form");

        return model;
    }

    @RequestMapping(value="/guardarProducto", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("productoForm") Producto producto){
        productoService.saveOrUpdate(producto);

        return new ModelAndView("redirect:/producto/lista");
    }

    @RequestMapping(value="/borrarProducto/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id){
        productoService.deleteProducto(id);

        return new ModelAndView("redirect:/producto/lista");
    }

}
