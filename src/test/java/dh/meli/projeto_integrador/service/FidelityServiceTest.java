package dh.meli.projeto_integrador.service;

import dh.meli.projeto_integrador.exception.ResourceNotFoundException;
import dh.meli.projeto_integrador.model.Fidelity;
import dh.meli.projeto_integrador.repository.IFidelityRepository;
import dh.meli.projeto_integrador.utils.GenerateFidelity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FidelityServiceTest {

	@InjectMocks
	FidelityService fidelityService;

	@Mock
	IFidelityRepository fidelityRepository;

	@BeforeEach
	void setup() {
		BDDMockito.when(fidelityRepository.save(ArgumentMatchers.any(Fidelity.class)))
				.thenReturn(GenerateFidelity.newFidelity1());
		BDDMockito.when(fidelityRepository.findById(ArgumentMatchers.anyLong()))
				.thenReturn(Optional.of(GenerateFidelity.newFidelity1()));
	}

	@Test
	void findFidelityTest() {
		long id = 0;
		Fidelity foundFidelity = fidelityService.findById(id);
		Fidelity fidelity = GenerateFidelity.newFidelity1();

		assertThat(foundFidelity.getId()).isEqualTo(fidelity.getId());
		assertThat(foundFidelity.getName()).isEqualTo(fidelity.getName());
		assertThat(foundFidelity.getCost()).isEqualTo(fidelity.getCost());

		verify(fidelityRepository, atLeastOnce()).findById(id);
	}

	@Test
	void findFidelity_WhenFidelityDontExistsTest() throws Exception {
		BDDMockito.when(fidelityRepository.findById(ArgumentMatchers.anyLong()))
				.thenReturn(Optional.empty());

		Long id = 9999L;

		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			Fidelity fidelity = fidelityService.findById(id);
		});

		assertThat(exception.getMessage()).isEqualTo(String.format("Could not find valid fidelityItem for id %d", id));

		verify(fidelityRepository, atLeastOnce()).findById(id);
	}

	@Test
	void getAllFidelities() {
		BDDMockito.when(fidelityRepository.findAll())
				.thenReturn(GenerateFidelity.fidelityList());

		List<Fidelity> allFidelityItems = fidelityService.findAll();


		assertThat(allFidelityItems).isNotNull();
		assertThat((allFidelityItems.size())).isEqualTo(2);
	}

	@Test
	void saveFidelityTest() {
		BDDMockito.when(fidelityRepository.save(ArgumentMatchers.any(Fidelity.class)))
				.thenReturn(GenerateFidelity.newFidelity1());

		Fidelity fidelity = GenerateFidelity.newFidelity1();
		Fidelity responseFidelity = fidelityService.save(fidelity);

		assertThat(responseFidelity.getId()).isEqualTo(fidelity.getId());
		assertThat(responseFidelity.getName()).isEqualTo(fidelity.getName());
		assertThat(responseFidelity.getCost()).isEqualTo(fidelity.getCost());

		verify(fidelityRepository, atLeastOnce()).save(fidelity);
	}

	@Test
	public void deleteFidelity_whenIdExist() {
		long fidelityId = GenerateFidelity.newFidelity1().getId();

		BDDMockito.willDoNothing().given(fidelityRepository).deleteById(ArgumentMatchers.anyLong());

		fidelityService.deleteById(fidelityId);

		verify(fidelityRepository, atLeastOnce()).findById(fidelityId);
		verify(fidelityRepository, atLeastOnce()).deleteById(fidelityId);
	}

	@Test
	public void updateFidelity_whenIdExist() {
		Fidelity fidelity = GenerateFidelity.newFidelity1();
		Fidelity fidelity2 = GenerateFidelity.atualizedFidelity();

		BDDMockito.when(fidelityRepository.save(fidelity))
				.thenReturn(fidelity);
		BDDMockito.when(fidelityRepository.findById(anyLong()))
				.thenReturn(Optional.of(fidelity));

		Fidelity atualizedFidelity = fidelityService.update(fidelity2, fidelity.getId());

		assertThat(atualizedFidelity).isNotNull();
		assertThat(atualizedFidelity.getId()).isEqualTo(fidelity.getId());
		assertThat(atualizedFidelity.getName()).isEqualTo(fidelity2.getName());
		assertThat(atualizedFidelity.getCost()).isEqualTo(fidelity2.getCost());
	}
}
