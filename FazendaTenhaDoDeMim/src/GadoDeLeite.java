import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

import java.time.LocalDate;
;
public class GadoDeLeite extends Gado implements GerenciamentoDoGado {

	/**
	 * Scanner para entrada de dados do usuário.
	 */
	Scanner scanner = new Scanner(System.in);

	private LocalDate periodoSeco;

	/**
	 * Construtor para a classe GadoDeLeite.
	 *
	 * @param nome O nome do gado.
	 * @param numeroBrinco O número do brinco do gado.
	 * @param dataUltrassom A data do último ultrassom do gado.
	 * @param previsaoNascimentoBezerro A previsão de nascimento do bezerro.
	 * @param aplicacaoBisnagaDeVacaSeca A data de aplicação da bisnaga de vaca seca.
	 * @param regimePreParto A data de início do regime pré-parto (30 dias antes do parto).
	 * @param medicamentoAplicado O medicamento aplicado ao gado.
	 * @param bezerro O bezerro associado ao gado.
	 * @param qualidadeColostro A qualidade do colostro.
	 */
	public GadoDeLeite(String nome, int numeroBrinco, LocalDate dataUltrassom, LocalDate previsaoNascimentoBezerro, LocalDate aplicacaoBisnagaDeVacaSeca, LocalDate regimePreParto, Medicamentos medicamentoAplicado, Bezerros bezerro, double qualidadeColostro) {
		super(nome, numeroBrinco, dataUltrassom, previsaoNascimentoBezerro, aplicacaoBisnagaDeVacaSeca, regimePreParto, medicamentoAplicado, bezerro, qualidadeColostro);
		this.periodoSeco = periodoSeco;;
	}

	/**
	 * Retorna o período seco do animal.
	 * 
	 * @return O período seco do animal, representado como um objeto {@code LocalDate}.
	 */
	public LocalDate getPeriodoSeco() {
		return periodoSeco;
	}
	/**
	 * Define o período seco do animal.
	 * 
	 * @param periodoSeco O período seco a ser definido, representado como um objeto {@code LocalDate}.
	 * 
	 * @throws IllegalArgumentException Se o período seco fornecido for nulo ou inválido.
	 */
	public void setPeriodoSeco(LocalDate periodoSeco) {
		this.periodoSeco = periodoSeco;
	}

	/**
	 * Registra um novo animal com um nome fornecido pelo usuário e gera um número de brinco aleatório.
	 * O nome e o número do brinco são então atribuídos ao animal.
	 * Exibe uma mensagem de confirmação de sucesso ao final do registro.
	 */
	@Override
	public void registrarAnimal() {

		System.out.println("Digite o nome do animal:");
		String nomeAnimal = scanner.nextLine();

		Random rand = new Random();
		int idBrinco = rand.nextInt(4000) + 1000;

		this.setNome(nomeAnimal);
		this.setNumeroBrinco(idBrinco);

		System.out.println("NOME: " + nomeAnimal);
		System.out.println("N° BRINCO: " + idBrinco);

		System.out.println("Animal registrado com sucesso!");
	}

	/**
	 * Registra a data do ultrassom para o animal. Se o animal já possui um ultrassom cadastrado, 
	 * uma mensagem é exibida e o método retorna. Caso contrário, solicita ao usuário a data do ultrassom
	 * no formato "dd/MM/yyyy". Após a entrada válida da data, ela é armazenada e um relatório de 
	 * gerenciamento pré-parto é gerado.
	 * 
	 * @throws DateTimeParseException Se a data fornecida não estiver no formato "dd/MM/yyyy".
	 */
	@Override
	public void registroUltrassom(){

		if(this.getDataUltrassom() != null) {
			System.out.println("O animal ja possui um ultrassom cadastrado");
			return;
		}else
			try {
				System.out.println("Digite a data do ultrassom (dd/MM/yyyy):");
				String dataStr = scanner.nextLine();
				LocalDate dataUltrassom = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				this.setDataUltrassom(dataUltrassom);
				String dataFormatada = dataUltrassom.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("\nUltrassom registrado para o animal com brinco " + this.getNumeroBrinco() + " na data " + dataFormatada);

				this.gerenciamentoPreParto();
			}catch (DateTimeParseException e) {
				System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");}

	}

	/**
	 * Gera um relatório de gerenciamento pré-parto para o animal. 
	 * O relatório inclui a previsão de nascimento do bezerro e a data de início do regime pré-parto.
	 * 
	 * Primeiro, verifica se o ultrassom foi registrado para o animal. Se não, exibe uma mensagem informando que o ultrassom não está cadastrado e encerra o método.
	 * Caso contrário, solicita ao usuário a idade do bezerro em meses e calcula a previsão de nascimento do bezerro com base na data do ultrassom e na idade informada.
	 * Também calcula a data de início do regime pré-parto (30 dias antes da previsão de nascimento do bezerro) e exibe essas informações formatadas.
	 * 
	 * Se o relatório de gerenciamento pré-parto já tiver sido gerado anteriormente, exibe uma mensagem informando que o relatório já foi gerado.
	 */
	@Override
	public void gerenciamentoPreParto() {

		if(this.getDataUltrassom() == null) {
			System.out.println("O animal não possui nenhum ultrassom cadastrado");
			return;	
		}else {
			if(this.getDataUltrassom() != null) {

				System.out.println("\nDigite quantos meses o bezerro ja tem: ");
				int idadeBezerro = scanner.nextInt();

				System.out.println("-=-=-=RELATÓRIO DE PERIODO PRÉ PARTO=-=-=-");
				System.out.println("NOME: " + this.getNome());
				System.out.println("N° BRINCO: " + this.getNumeroBrinco());

				this.setPrevisaoNascimentoBezerro(this.getDataUltrassom().minusMonths(idadeBezerro).plusMonths(9));
				System.out.println("Previsão de nascimento do bezerro: " + this.getPrevisaoNascimentoBezerro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

				this.setPeriodoSeco(this.getPrevisaoNascimentoBezerro().minusDays(60));
				String periodoSecoFormat = this.getPeriodoSeco().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("Inicio do Periodo Seco: " + periodoSecoFormat);

				this.setRegimePreParto(this.getPrevisaoNascimentoBezerro().minusDays(30));
				String regimePrePartoFormat = this.getRegimePreParto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("Inicio do Regime pré parto: " + regimePrePartoFormat);}
			else
				System.out.println("Ja foi gerado um relatório de gerenciamento pré parto para este animal");
			return;
		}
	}

	/**
	 * Registra a aplicação da bisnaga de vaca seca para o animal e o medicamento aplicado.
	 * 
	 * Primeiro, verifica se a previsão de nascimento do bezerro foi definida. Se não, a aplicação não pode ser registrada e o método termina.
	 * Caso a previsão esteja definida, solicita ao usuário a data da aplicação da bisnaga de vaca seca. A data deve ser igual à data de início do regime pré-parto.
	 * O usuário é solicitado a fornecer a data no formato "dd/MM/yyyy". Se a data não for válida ou não corresponder ao início do regime pré-parto, solicita a entrada novamente.
	 * Após a entrada válida da data, o método exibe uma lista de medicamentos disponíveis e solicita ao usuário para escolher um.
	 * Com base na escolha do usuário, o medicamento é registrado e os detalhes da aplicação (incluindo a data mínima para abate) são exibidos.
	 * 
	 * @throws DateTimeParseException Se a data fornecida não estiver no formato "dd/MM/yyyy".
	 * @throws NullPointerException Se a previsão de nascimento do bezerro não estiver definida, o método não prossegue com o registro da aplicação.
	 */
	@Override
	public void aplicacaoBisnagaDeVacaSeca() {
		if (this.getPrevisaoNascimentoBezerro() != null) {

			String dataBisnagaStr = "";
			LocalDate dataApliBisnaga = null;
			boolean dataValida = false;

			scanner.nextLine();

			while (!dataValida) {
				try {
					System.out.println("Digite a data da aplicação da bisnaga de vaca seca (dd/MM/yyyy):");
					dataBisnagaStr = scanner.nextLine();

					if(LocalDate.parse(dataBisnagaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(this.getPeriodoSeco())) {

						if (dataBisnagaStr.isEmpty()) {
							System.out.println("A data não pode estar vazia. Por favor, tente novamente.");
						} else {
							try {
								dataApliBisnaga = LocalDate.parse(dataBisnagaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
								dataValida = true;
							} catch (DateTimeParseException e) {
								System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");
							}
						}
					}else 
						System.out.println("A data da aplicação da bisnaga de vaca seca tem que ser igual a data do inicio do periodo seco do animal!");


					this.setAplicacaoBisnagaDeVacaSeca(dataApliBisnaga);
					String dataFormatadaBisnaga = dataApliBisnaga.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


					System.out.println("Qual rémedio você deseja aplicar no animal: "
							+ "\n[1] Cepravin"
							+ "\n[2] Orbenin"
							+"\n[3] Albiotic"
							+"\n[4] Bovimast"
							+"\n[5] Spectrazol");

					int escolhaRemedio = scanner.nextInt();

					if (escolhaRemedio == 1) {
						System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
						System.out.println("Medicamento aplicado: " +  Medicamentos.cepravin.nome 
								+"\nDias de carência: " + Medicamentos.cepravin.diasCarenciaLeite + " dias"
								+"\nData da primeira ordenha pós aplicação: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.cepravin.diasCarenciaLeite).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						this.setMedicamentoAplicado(Medicamentos.cepravin);
						return;

					}else if (escolhaRemedio == 2) {
						System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
						System.out.println("Medicamento aplicado: " +  Medicamentos.orbenin.nome 
								+"\nDias de carência: " + Medicamentos.orbenin.diasCarenciaLeite + " dias"
								+"\nData da primeira ordenha pós aplicação: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.orbenin.diasCarenciaLeite).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						this.setMedicamentoAplicado(Medicamentos.orbenin);
						return;

					}else if (escolhaRemedio == 3) {
						System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
						System.out.println("Medicamento aplicado: " +  Medicamentos.albiotic.nome 
								+"\nDias de carência: " + Medicamentos.albiotic.diasCarenciaLeite + " dias"
								+"\nData da primeira ordenha pós aplicação: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.albiotic.diasCarenciaLeite).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						this.setMedicamentoAplicado(Medicamentos.albiotic);
						return;

					}else if (escolhaRemedio == 4) {
						System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
						System.out.println("Medicamento aplicado: " +  Medicamentos.bovimast.nome 
								+"\nDias de carência: " + Medicamentos.bovimast.diasCarenciaLeite + " dias"
								+"\nData da primeira ordenha pós aplicação: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.bovimast.diasCarenciaLeite).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						this.setMedicamentoAplicado(Medicamentos.bovimast);
						return;

					}else if (escolhaRemedio == 5) {
						System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
						System.out.println("Medicamento aplicado: " +  Medicamentos.spectrazol.nome 
								+"\nDias de carência: " + Medicamentos.spectrazol.diasCarenciaLeite + " dias"
								+"\nData da primeira ordenha pós aplicação: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.spectrazol.diasCarenciaLeite).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						this.setMedicamentoAplicado(Medicamentos.spectrazol);
						return;
					}

					else {
						System.out.println("Ainda não foi registrado ultrassom para este animal.");
						return;
					}

				}catch (DateTimeParseException e) {
					System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");
				}catch (NullPointerException e) {
					System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");}
			}
		}
	}


	/**
	 * Registra o nascimento de um bezerro para o animal.
	 * 
	 * O método realiza as seguintes etapas:
	 * <ol>
	 * <li>Verifica se há uma previsão de nascimento do bezerro registrada. Se não houver, o método exibe uma mensagem e termina.</li>
	 * <li>Solicita ao usuário a data de nascimento do bezerro no formato "dd/MM/yyyy". Se a data estiver vazia, exibe uma mensagem de erro e termina.</li>
	 * <li>Se a data for válida, solicita o peso do bezerro. O usuário deve fornecer um valor numérico. Se o valor não for numérico, solicita a entrada novamente.</li>
	 * <li>Solicita ao usuário o sexo do bezerro, com opções para macho ou fêmea. Se a opção for inválida, exibe uma mensagem de erro e termina.</li>
	 * <li>Cria um objeto `Bezerros` com as informações fornecidas e gera um número de brinco para o bezerro. Se o sexo do bezerro for macho, define o parâmetro apropriado. Caso contrário, define-o como fêmea.</li>
	 * <li>Exibe uma mensagem confirmando o cadastro do bezerro com seu número de brinco.</li>
	 * <li>Define o objeto `Bezerros` criado no animal e limpa as informações de ultrassom, previsão de nascimento e regime pré-parto.</li>
	 * </ol>
	 * 
	 * @throws DateTimeParseException Se a data de nascimento fornecida não estiver no formato "dd/MM/yyyy".
	 * @throws InputMismatchException Se o valor do peso fornecido não for um número válido.
	 */
	@Override
	public void registroNascimentoBezerro() {
		scanner.nextLine();
		if (this.getPrevisaoNascimentoBezerro() != null) {
			System.out.println("Digite a data de nascimento do bezerro (dd/MM/yyyy):");
			String dataStr = scanner.nextLine().trim(); 


			if (dataStr.isEmpty()) {
				System.out.println("Data de nascimento não pode estar vazia.");
				return;
			}

			try {
				LocalDate dataNascimento = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				System.out.println("Digite o peso do bezerro: ");
				double pesoBezerro = 0.0;


				while (true) {
					try {
						pesoBezerro = scanner.nextDouble();
						break; 
					} catch (InputMismatchException e) {
						System.out.println("Digite um valor numérico válido para o peso.");
						scanner.nextLine(); 
					}
				}

				System.out.println("Qual o sexo do bezerro: \n[1]Macho \n[2]Fêmea");
				int sexoBezerro = scanner.nextInt();
				scanner.nextLine(); 

				Bezerros bezerro;
				if (sexoBezerro == 1) {
					bezerro = new Bezerros(dataNascimento, 0, pesoBezerro, true);
					bezerro.numeroBrincoBezerro();
				} else if (sexoBezerro == 2) {
					bezerro = new Bezerros(dataNascimento, 0, pesoBezerro, false);
					bezerro.numeroBrincoBezerro();
				} else {
					System.out.println("Opção inválida para sexo do bezerro.");
					return;
				}

				System.out.println("Bezerro n° " + bezerro.getNumeroBrinco() + " cadastrado com sucesso!");
				this.setBezerro(bezerro);

				if(this.getBezerro().getDataNacimento().isAfter(this.getAplicacaoBisnagaDeVacaSeca())) {
					this.setAplicacaoBisnagaDeVacaSeca(null);
					this.setMedicamentoAplicado(null);
				}

				this.setDataUltrassom(null);
				this.setPrevisaoNascimentoBezerro(null);
				this.setRegimePreParto(null);
				this.setPeriodoSeco(null);

			} catch (DateTimeParseException e) {
				System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
			}
		} else {
			System.out.println("Nenhum registro de ultrassom para este animal.");
		}

	}

	/**
	 * Realiza o teste de qualidade do colostro coletado para o bezerro do animal.
	 * 
	 * O método executa as seguintes etapas:
	 * <ol>
	 * <li>Verifica se há um bezerro registrado para o animal. Se não houver, exibe uma mensagem de erro e termina.</li>
	 * <li>Solicita ao usuário o valor da qualidade do colostro coletado em um valor numérico.</li>
	 * <li>Se o valor da qualidade do colostro for maior ou igual a 21, considera o teste como aprovado e exibe uma mensagem de sucesso com o resultado "APROVADO".</li>
	 * <li>Se o valor da qualidade do colostro for menor que 21, considera o teste como reprovado, exibe uma mensagem de sucesso com o resultado "REPROVADO", e orienta a retirar colostro adequado no banco de colostro.</li>
	 * </ol>
	 * 
	 * @throws InputMismatchException Se o valor da qualidade do colostro fornecido não for um número válido.
	 */
	@Override
	public void testeQualidadeColostro() {

		if(this.getBezerro() != null) {

			System.out.println("Digite o valor da qualidade do colostro coletado: ");
			double colostroColetado = scanner.nextDouble();

			if(colostroColetado >= 21) {
				System.out.println("Teste de qualidade do colostro realizado com sucesso!");
				System.out.println("RESULTADO: APROVADO" + " \u2714");
			}else {
				System.out.println("Teste de qualidade do colostro realizado com sucesso!");
				System.out.println("RESULTADO: REPROVADO" + " \u2716");
				System.out.println("RETIRAR COLOSTRO ADEQUADO NO BANCO DE COLOSTRO");
			}

		}
		else {
			System.out.println("Nenhum nascimento de bezerro registrado para este animal!");
			return;
		}
		return;
	}

}