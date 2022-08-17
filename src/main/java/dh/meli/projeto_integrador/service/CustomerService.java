package dh.meli.projeto_integrador.service;

import dh.meli.projeto_integrador.exception.ResourceNotFoundException;
import dh.meli.projeto_integrador.model.Customer;
import dh.meli.projeto_integrador.model.Warehouse;
import dh.meli.projeto_integrador.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

	/**
	 * Dependency Injection of the Warehouse Repository.
	 */
	@Autowired
	private ICustomerRepository customerRepository;

	/**
	 * Method to find a warehouse by id;
	 * @param id of type long. Warehouse identifier;
	 * @return an object of type Warehouse;
	 */
	@Override
	public Customer findCustomer(long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (customer.isEmpty()) {
			throw new ResourceNotFoundException(String.format("Could not find valid customer for id %d", id));
		}

		return customer.get();
	}
}
