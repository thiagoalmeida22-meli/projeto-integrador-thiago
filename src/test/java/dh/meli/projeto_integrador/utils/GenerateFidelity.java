package dh.meli.projeto_integrador.utils;

import dh.meli.projeto_integrador.model.Fidelity;
import dh.meli.projeto_integrador.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GenerateFidelity {
	public static Fidelity newFidelity1() {
		return Fidelity.builder()
				.id(1L)
				.name("Conta Premium (1 mês)")
				.cost(100L)
				.build();
	}

	public static Fidelity newFidelity2() {
		return Fidelity.builder()
				.id(2L)
				.name("2Kg de açai com banana")
				.cost(10L)
				.build();
	}

	public static List<Fidelity> fidelityList() {
		List<Fidelity> fidelityList = new ArrayList<>();
		fidelityList.add(newFidelity1());
		fidelityList.add(newFidelity2());

		return fidelityList;
	}

	public static Fidelity atualizedFidelity() {
		return Fidelity.builder()
				.id(1L)
				.name("Beneficio atualizado")
				.cost(200L)
				.build();
	}
}
