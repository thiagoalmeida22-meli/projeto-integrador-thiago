package dh.meli.projeto_integrador.controller;

import dh.meli.projeto_integrador.model.Fidelity;
import dh.meli.projeto_integrador.service.FidelityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/fidelity")
public class FidelityController {
	/**
	 * Dependency Injection of the OrderService.
	 */
	@Autowired
	private FidelityService fidelityService;

	@PostMapping
	public ResponseEntity<Fidelity> save (@RequestBody Fidelity fidelityItem) {
		return ResponseEntity.ok(fidelityService.save(fidelityItem));
	}

	@PostMapping("/{customer}/{bonus}")
	public ResponseEntity<Fidelity> buyBonus (@PathVariable Long customer, @PathVariable Long bonus) {
		return ResponseEntity.ok(fidelityService.buyBonus(customer, bonus));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fidelity> update (@RequestBody Fidelity fidelityItem, @PathVariable Long id) {
		return ResponseEntity.ok(fidelityService.update(fidelityItem, id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fidelity> findById(@PathVariable Long id) {
		return ResponseEntity.ok(fidelityService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Fidelity>> findAll() {
		return ResponseEntity.ok(fidelityService.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return ResponseEntity.ok(fidelityService.deleteById(id));
	}

}
