package com.akitoy.proyecto.repository;

import com.akitoy.proyecto.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
