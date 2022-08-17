package dh.meli.projeto_integrador.service;

import dh.meli.projeto_integrador.model.Fidelity;

import java.util.List;

public interface IFidelityService {
	Fidelity save(Fidelity fidelityItem);
	Fidelity findById(Long id);
	List<Fidelity> findAll();
	String deleteById(Long id);
	Fidelity update(Fidelity fidelity, Long id);
}
