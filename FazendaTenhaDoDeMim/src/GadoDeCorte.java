import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class GadoDeCorte extends Gado implements GerenciamentoDoGado {

	Scanner scanner = new Scanner(System.in); 

	public GadoDeCorte(String nome, int numeroBrinco, LocalDate dataUltrassom, LocalDate previsaoNascimentoBezerro, LocalDate aplicacaoBisnagaDeVacaSeca, LocalDate regimePreParto, Medicamentos medicamentoAplicado, Bezerros bezerro, double qualidadeColostro) {
		super(nome, numeroBrinco, dataUltrassom, previsaoNascimentoBezerro, aplicacaoBisnagaDeVacaSeca, regimePreParto, medicamentoAplicado, bezerro, qualidadeColostro);
	}

	@Override
	public void registrarAnimal() {

		System.out.println("Digite o nome do animal:");
		String nomeAnimal = scanner.nextLine();

		Random rand = new Random();
		int idBrinco = rand.nextInt(8000) + 1000;

		this.setNome(nomeAnimal);
		this.setNumeroBrinco(idBrinco);

		System.out.println("NOME: " + nomeAnimal);
		System.out.println("N° BRINCO: " + idBrinco);

		System.out.println("Animal registrado com sucesso!");
	}

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

				this.setRegimePreParto(this.getPrevisaoNascimentoBezerro().minusDays(30));
				String regimePrePartoFormat = this.getRegimePreParto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("Inicio do Regime pré parto: " + regimePrePartoFormat);}
			else
				System.out.println("Ja foi gerado um relatório de gerenciamento pré parto para este animal");
			return;
		}
	}

	@Override
	public void aplicacaoBisnagaDeVacaSeca() {
		if (this.getPrevisaoNascimentoBezerro() != null) {

			String dataBisnagaStr = "";
			LocalDate dataApliBisnaga = null;
			boolean dataValida = false;

			scanner.nextLine();
			try {
				while (!dataValida) {
					System.out.println("Digite a data da aplicação da bisnaga de vaca seca (dd/MM/yyyy):");
					dataBisnagaStr = scanner.nextLine();

					if(LocalDate.parse(dataBisnagaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(this.getRegimePreParto())) {

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
						System.out.println("A data da aplicação da bisnaga de vaca seca tem que ser igual a data do inicio do regime pré parto do animal!");
				}

				this.setAplicacaoBisnagaDeVacaSeca(dataApliBisnaga);
				String dataFormatadaBisnaga = dataApliBisnaga.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


				System.out.println("Qual rémedio você deseja aplicar no animal: "
						+ "\n[1] Cepravin"
						+ "\n[2] Orbenin"
						+"\n[3] Orbenin"
						+"\n[4] Bovimast"
						+"\n[5] Spectrazol");

				int escolhaRemedio = scanner.nextInt();

				if (escolhaRemedio == 1) {
					System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
					System.out.println("Medicamento aplicado: " +  Medicamentos.cepravin.nome 
							+"\nDias de carência: " + Medicamentos.cepravin.diasCarenciaCorte + " dias"
							+"\nData minima para abate: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.cepravin.diasCarenciaCorte).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					this.setMedicamentoAplicado(Medicamentos.cepravin);
					return;

				}else if (escolhaRemedio == 2) {
					System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
					System.out.println("Medicamento aplicado: " +  Medicamentos.orbenin.nome 
							+"\nDias de carência: " + Medicamentos.orbenin.diasCarenciaCorte + " dias"
							+"\nData minima para abate: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.orbenin.diasCarenciaCorte).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					this.setMedicamentoAplicado(Medicamentos.orbenin);
					return;

				}else if (escolhaRemedio == 3) {
					System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
					System.out.println("Medicamento aplicado: " +  Medicamentos.albiotic.nome 
							+"\nDias de carência: " + Medicamentos.albiotic.diasCarenciaCorte + " dias"
							+"\nData minima para abate: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.albiotic.diasCarenciaCorte).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					this.setMedicamentoAplicado(Medicamentos.albiotic);
					return;

				}else if (escolhaRemedio == 4) {
					System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
					System.out.println("Medicamento aplicado: " +  Medicamentos.bovimast.nome 
							+"\nDias de carência: " + Medicamentos.bovimast.diasCarenciaCorte + " dias"
							+"\nData minima para abate: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.bovimast.diasCarenciaCorte).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					this.setMedicamentoAplicado(Medicamentos.bovimast);
					return;

				}else if (escolhaRemedio == 5) {
					System.out.println("Aplicação da bisnaga de vaca seca registrada para o animal " + this.getNumeroBrinco() + " na data de " + dataFormatadaBisnaga);
					System.out.println("Medicamento aplicado: " +  Medicamentos.spectrazol.nome 
							+"\nDias de carência: " + Medicamentos.spectrazol.diasCarenciaCorte + " dias"
							+"\nData minima para abate: " + this.getAplicacaoBisnagaDeVacaSeca().plusDays(Medicamentos.spectrazol.diasCarenciaCorte).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					this.setMedicamentoAplicado(Medicamentos.spectrazol);
					return;
				}

				else {
					System.out.println("Ainda não foi registrado ultrassom para este animal.");
				}

			}catch (DateTimeParseException e) {
				System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");
			}catch (NullPointerException e) {
				System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");}
		}
	}


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

				this.setDataUltrassom(null);
				this.setPrevisaoNascimentoBezerro(null);
				this.setRegimePreParto(null);

			} catch (DateTimeParseException e) {
				System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
			}
		} else {
			System.out.println("Nenhum registro de ultrassom para este animal.");
		}

	}


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
