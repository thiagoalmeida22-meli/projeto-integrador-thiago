package dh.meli.projeto_integrador.repository;

import dh.meli.projeto_integrador.model.Warehouse;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface IWarehouseRepository will manage data persistence for Warehouse object instances.
 * Will read, save, update and delete data through the GET, POST, PUT and DELETE requests.
 * @author Diovana Valim
 * @version 0.0.1
 */
public interface IWarehouseRepository extends CrudRepository<Warehouse, Long> {}
