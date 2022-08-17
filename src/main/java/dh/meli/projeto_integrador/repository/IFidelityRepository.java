package dh.meli.projeto_integrador.repository;

import dh.meli.projeto_integrador.model.Fidelity;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface IFidelityRepository will manage data persistence for Fidelity object instances.
 * Will read, save, update and delete data through the GET, POST, PUT and DELETE requests.
 * @author Thiago Almeida
 * @version 0.0.1
 */
public interface IFidelityRepository extends CrudRepository<Fidelity, Long> {
}
