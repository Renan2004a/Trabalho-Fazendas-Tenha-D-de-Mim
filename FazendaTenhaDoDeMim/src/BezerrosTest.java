import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class BezerrosTest {

	@Test
	void testNumeroBrincoBezerro() {
		// Dados para o teste
		LocalDate dataNascimento = LocalDate.of(2024, 7, 15);
		double peso = 50.0;
		boolean sexo = true; // true para macho, false para fêmea

		// Cria um objeto Bezerros com o número de brinco inicial como 0
		Bezerros bezerro = new Bezerros(dataNascimento, 0, peso, sexo);

		// Armazena o estado original dos atributos
		int numeroBrincoOriginal = bezerro.getNumeroBrinco();

		// Gera um novo número de brinco
		bezerro.numeroBrincoBezerro();
		int numeroBrincoGerado = bezerro.getNumeroBrinco();

		// Verifica que o número de brinco gerado está no intervalo correto
		assertTrue(numeroBrincoGerado >= 1000 && numeroBrincoGerado < 7000, "Número de brinco fora do intervalo esperado");

		// Verifica que o número de brinco foi alterado (se a classe permitir)
		assertNotEquals(numeroBrincoOriginal, numeroBrincoGerado, "O número de brinco não foi alterado.");
	}
}