package dh.meli.projeto_integrador.service;

import dh.meli.projeto_integrador.exception.ForbiddenException;
import dh.meli.projeto_integrador.exception.ResourceNotFoundException;
import dh.meli.projeto_integrador.model.Customer;
import dh.meli.projeto_integrador.model.Fidelity;
import dh.meli.projeto_integrador.repository.IFidelityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FidelityService implements IFidelityService{

	@Autowired
	private IFidelityRepository fidelityRepository;

	@Autowired
	private CustomerService customerService;

	@Override
	public Fidelity save(Fidelity fidelityItem) {
		return fidelityRepository.save(fidelityItem);
	}

	@Override
	public Fidelity findById(Long id) {
		Optional<Fidelity> fidelity = fidelityRepository.findById(id);

		if (fidelity.isEmpty()) {
			throw new ResourceNotFoundException(String.format("Could not find valid fidelityItem for id %d", id));
		}

		return fidelity.get();
	}

	@Override
	public List<Fidelity> findAll() {
        List<Fidelity> list = new ArrayList<>();
        Iterable<Fidelity> resp = fidelityRepository.findAll();
        resp.forEach(list::add);
        return list ;
	}

	@Override
	public String deleteById(Long id) {
		Optional<Fidelity> fidelity = fidelityRepository.findById(id);
		fidelityRepository.deleteById(id);
		return "Item de fidelidade removido com sucesso!";
	}

	@Override
	@Transactional
	public Fidelity update(Fidelity fidelityItem, Long id) {
		Fidelity foundFidelity = findById(id);
		foundFidelity.setName(fidelityItem.getName());
		foundFidelity.setCost(fidelityItem.getCost());
		return foundFidelity;
	}

	@Transactional
	public Fidelity buyBonus(Long customerId, Long bonusId) {
		Customer foundCustomer = customerService.findCustomer(customerId);
		Fidelity foundFidelity = findById(bonusId);

		if (foundFidelity.getCost() > foundCustomer.getPontos()) {
			throw new ForbiddenException(String.format("You only got %d out of %d points needed to buy the reward", foundFidelity.getCost(), foundCustomer.getPontos()));
		}

		foundCustomer.setPontos(foundCustomer.getPontos() - foundFidelity.getCost());
		return  foundFidelity;
	}
}
