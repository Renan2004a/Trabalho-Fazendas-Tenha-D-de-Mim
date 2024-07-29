import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class GadoDeLeiteTest {

	@Test
	void testRegistrarAnimal() {
		GadoDeLeite gadoDeLeite = new GadoDeLeite("Test Animal", 1234, null, null, null, null, null, null, 20.0);

		// Simulando a entrada do usuário
		Scanner scanner = new Scanner("Test Animal\n");
		gadoDeLeite.scanner = scanner; 

		gadoDeLeite.registrarAnimal();

		// Verificando os resultados
		assertEquals("Test Animal", gadoDeLeite.getNome());
		assertNotEquals(0, gadoDeLeite.getNumeroBrinco()); // Verifica se o número do brinco foi definido
	}


	@Test
	void testRegistroUltrassom() {
		GadoDeLeite gadoDeLeite = new GadoDeLeite("Test Animal", 1234, null, null, null, null, null, null, 20.0);

		// Simulando a entrada do usuário
		Scanner scanner = new Scanner("15/01/2024\n3\n");
		gadoDeLeite.scanner = scanner; 

		gadoDeLeite.registroUltrassom();

		// Verificando os resultados
		assertNotNull(gadoDeLeite.getDataUltrassom());
		LocalDate expectedPrevisaoNascimento = LocalDate.of(2024, 10, 15);
		assertEquals(expectedPrevisaoNascimento, gadoDeLeite.getPrevisaoNascimentoBezerro());
	}

	@Test
	void testGerenciamentoPreParto() {
		GadoDeLeite gadoDeLeite = new GadoDeLeite("Test Animal", 1234, LocalDate.of(2024, 1, 15), null, null, null, null, null, 20.0);

		// Simulando a entrada do usuário
		Scanner scanner = new Scanner("3\n");
		gadoDeLeite.scanner = scanner; 

		gadoDeLeite.gerenciamentoPreParto();

		// Verificando os resultados
		LocalDate expectedPrevisaoNascimento = LocalDate.of(2024, 10, 15);
		assertEquals(expectedPrevisaoNascimento, gadoDeLeite.getPrevisaoNascimentoBezerro());

		LocalDate expectedPeriodoSeco = LocalDate.of(2024, 3, 15);
		assertEquals(expectedPeriodoSeco, gadoDeLeite.getPeriodoSeco());
	}

	@Test
	void testAplicacaoBisnagaDeVacaSeca() {
		GadoDeLeite gadoDeLeite = new GadoDeLeite("Test Animal", 1234, null, null, null, LocalDate.of(2024, 3, 15), null, null, 20.0);

		// Simulando a entrada do usuário
		Scanner scanner = new Scanner("15/03/2024\n1\n");
		gadoDeLeite.scanner = scanner; 

		gadoDeLeite.aplicacaoBisnagaDeVacaSeca();

		// Verificando os resultados
		assertNotNull(gadoDeLeite.getAplicacaoBisnagaDeVacaSeca());
		assertEquals(Medicamentos.cepravin, gadoDeLeite.getMedicamentoAplicado());
	}
}