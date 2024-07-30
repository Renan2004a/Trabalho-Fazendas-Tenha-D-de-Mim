import java.nio.file.spi.FileSystemProvider;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal para o programa de gerenciamento de gado.
 * Classe que serve como ponto de entrada para a aplicação e fornece um menu
 * para gerenciar gado de leite e gado de corte.
 */
public class Main {


	private static ArrayList<GadoDeLeite> listaGadoDeLeite = new ArrayList<>();
	private static ArrayList<GadoDeCorte> listaGadoDeCorte = new ArrayList<>();


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;

		while (escolha != 7) {
			System.out.println("-=-=-=Menu Geral-=-=-=-");
			System.out.print("\n1. Cadastrar Gado");
			System.out.print("\n2. Central de ultrassom");
			System.out.print("\n3. Gerenciar Período Pré-Parto");

			System.out.print("\nEscolha uma das opções: ");

			try {
				escolha = scanner.nextInt();
				scanner.nextLine();

				switch (escolha) {
				
				/**
				 * Cadastro de gado.
				 * Trata do cadastro de gado leiteiro ou de corte.
				 */
				case 1:
					System.out.println("\n-=-=-=Cadastro de Gado-=-=-=-");
					System.out.println("Escolha o tipo de gado que deseja cadastrar: \n[1]GADO LEITEIRO \n[2]GADO DE CORTE");
					int escolhaTipoGado = scanner.nextInt();

					if (escolhaTipoGado == 1) {
						GadoDeLeite gadoLeiteiro = new GadoDeLeite(null, 0, null, null, null, null, null, null, 0);
						gadoLeiteiro.registrarAnimal();
						listaGadoDeLeite.add(gadoLeiteiro);

					} else if (escolhaTipoGado == 2) {
						GadoDeCorte gadoAbate = new GadoDeCorte(null, 0, null, null, null, null, null, null, 0);
						gadoAbate.registrarAnimal();
						listaGadoDeCorte.add(gadoAbate);
					}
					break;

					/**
					 * Central de Ultrassom.
					 * Trata do gerenciamento de ultrassons,
					 * permitindo registrar novos ultrassons para gado de leite ou gado de corte.
					 */
				case 2:

					while (true) {
						System.out.println("\n-=-=-=Central de Ultrassom-=-=-=-");
						System.out.println("Escolha: \n[1]Registrar novo ultrassom \n[2]Voltar ao menu geral");
						int escolhaOpUltrassom = scanner.nextInt();
						scanner.nextLine();

						if (escolhaOpUltrassom == 1) {
							System.out.println("Escolha: \n[1]Gado de leite \n[2]Gado de corte");
							int escolhaTipoGadoUltrassom = scanner.nextInt();
							scanner.nextLine();

							if (escolhaTipoGadoUltrassom == 1) { //ULTRASSOM GADO DE LEITE
								System.out.println("Em qual animal foi realizado o ultrassom: ");
								printListaGadoDeLeite();
								System.out.println("Digite o numero do brinco: ");
								int numeroBrincoGadoLeite = scanner.nextInt();
								scanner.nextLine();

								boolean found = false;
								for (GadoDeLeite gado : listaGadoDeLeite) {
									if (gado.getNumeroBrinco() == numeroBrincoGadoLeite) {
										gado.registroUltrassom();

										found = true;
										break;
									}
								}
								if (!found) {
									System.out.println("Gado não encontrado.");
								}

							} else if (escolhaTipoGadoUltrassom == 2) {
								System.out.println("Em qual animal foi realizado o ultrassom: ");
								printListaGadoDeCorte();
								System.out.println("Digite o numero do brinco: ");
								int numeroBrincoGadoCorte = scanner.nextInt();
								scanner.nextLine();

								boolean found = false;
								for (GadoDeCorte gado : listaGadoDeCorte) {
									if (gado.getNumeroBrinco() == numeroBrincoGadoCorte) {
										gado.registroUltrassom();
										found = true;
										break;
									}
								}
								if (!found) {
									System.out.println("Gado não encontrado.");
								}
							}
						} else if (escolhaOpUltrassom == 2) {
							break; 
						} else {
							System.out.println("Opção inválida.");
						}
					}
					break;

					/**
					 * Gerenciamento do Período Pré-Parto.
					 * Trata do gerenciamento de atividades relacionadas ao período pré-parto,
					 * como a aplicação de bisnaga de vaca seca, o registro de nascimento de bezerros e o teste de qualidade do colostro.
					 */
				case 3:

					System.out.println("-=-=-=Gerenciamento Preíodo Pré-parto");
					int escolhaGerenciamentoPreParto = 0;

					while (escolhaGerenciamentoPreParto != 4) {
						System.out.print("\n1. Registrar Aplicação de Bisnaga de Vaca Seca.");
						System.out.print("\n2. Registrar Nascimento de bezerro.");
						System.out.print("\n3. Teste de Qualidade de Colostro.");
						System.out.println("\n4. Sair. ");
						System.out.println("\nEscolha uma das opções: ");

						try {
							escolhaGerenciamentoPreParto = scanner.nextInt();
							switch (escolhaGerenciamentoPreParto) {


							case 1: //  Aplicação de Bisnaga de Vaca Seca

									
								System.out.println("-=-=-=REGISTRO APLICAÇÃO BISNAGA DE VACA SECA=-=-=-");
								System.out.println("Escolha: \n[1]Gado de leite \n[2]Gado de corte 								"
										+ "\n[3]Voltar ao menu de gerenciamento de parto");
								int escolhaTipoGadoBisnaga = scanner.nextInt();
								scanner.nextLine();

								if (escolhaTipoGadoBisnaga == 1) { //BISNAGA GADO DE LEITE
									System.out.println("Em qual animal foi aplicado a bisnaga de vaca seca: ");
									printListaGadoDeLeite();
									System.out.println("Digite o numero do brinco: ");
									int numeroBrincoGadoLeite = scanner.nextInt();
									scanner.nextLine();

									boolean found = false;
									for (GadoDeLeite gado : listaGadoDeLeite) {
										if (gado.getNumeroBrinco() == numeroBrincoGadoLeite) {
											gado.aplicacaoBisnagaDeVacaSeca();
											found = true;
											break;		
											
										}
									}
								}

								else if (escolhaTipoGadoBisnaga == 2) { //BISNAGA GADO DE CORTE
									System.out.println("Em qual animal foi realizado o ultrassom: ");
									printListaGadoDeCorte();
									System.out.println("Digite o numero do brinco: ");
									int numeroBrincoGadoCorte = scanner.nextInt();
									scanner.nextLine();

									boolean found = false;
									for (GadoDeCorte gado : listaGadoDeCorte) {
										if (gado.getNumeroBrinco() == numeroBrincoGadoCorte) {
											gado.aplicacaoBisnagaDeVacaSeca(); 
											found = true;
											break;
										}
									}
								}
								break;



							case 2: //  Registrar Nascimento de bezerro

								System.out.println("-=-=-=REGISTRO NASCIMENTO DE BEZERRO=-=-=-");
								System.out.println("Escolha: \n[1]Gado de leite \n[2]Gado de corte");
								int escolhaTipoGadoBezerro = scanner.nextInt();
								scanner.nextLine();

								if (escolhaTipoGadoBezerro == 1) { //BISNAGA GADO DE LEITE
									System.out.println("Em qual animal foi aplicado a bisnaga de vaca seca: ");
									printListaGadoDeLeite();
									System.out.println("Digite o numero do brinco: ");
									int numeroBrincoGadoLeite = scanner.nextInt();
									scanner.nextLine();

									boolean found = false;
									for (GadoDeLeite gado : listaGadoDeLeite) {
										if (gado.getNumeroBrinco() == numeroBrincoGadoLeite) {
											gado.registroNascimentoBezerro();
											found = true;
											break;
										}
									}
								}

								else if (escolhaTipoGadoBezerro == 2) { //BISNAGA GADO DE CORTE
									System.out.println("Em qual animal foi realizado o ultrassom: ");
									printListaGadoDeCorte();
									System.out.println("Digite o numero do brinco: ");
									int numeroBrincoGadoCorte = scanner.nextInt();
									scanner.nextLine();

									boolean found = false;
									for (GadoDeCorte gado : listaGadoDeCorte) {
										if (gado.getNumeroBrinco() == numeroBrincoGadoCorte) {
											gado.registroNascimentoBezerro();
											found = true;
											break;
										}
									}
								}
								break;

							case 3: // TESTE QUALIDADE DE COLOSTRO

								System.out.println("-=-=-=TESTE QUALIDADE DE COLOSTRO=-=-=-");
								System.out.println("Escolha: \n[1]Gado de leite \n[2]Gado de corte");
								int escolhaTipoGadoColostro = scanner.nextInt();
								scanner.nextLine();

								if (escolhaTipoGadoColostro == 1) { //COLOSTRO GADO DE LEITE
									System.out.println("Em qual animal foi aplicado a bisnaga de vaca seca: ");
									printListaGadoDeLeite();
									System.out.println("Digite o numero do brinco: ");
									int numeroBrincoGadoLeite = scanner.nextInt();
									scanner.nextLine();

									boolean found = false;
									for (GadoDeLeite gado : listaGadoDeLeite) {
										if (gado.getNumeroBrinco() == numeroBrincoGadoLeite) {
											gado.testeQualidadeColostro();
											found = true;
											break;
										}
									}
								}

								else if (escolhaTipoGadoColostro == 2) { //COLOSTRO GADO DE CORTE
									System.out.println("Em qual animal foi realizado o ultrassom: ");
									printListaGadoDeCorte();
									System.out.println("Digite o numero do brinco: ");
									int numeroBrincoGadoCorte = scanner.nextInt();
									scanner.nextLine();

									boolean found = false;
									for (GadoDeCorte gado : listaGadoDeCorte) {
										if (gado.getNumeroBrinco() == numeroBrincoGadoCorte) {
											gado.testeQualidadeColostro();
											found = true;
											break;
										}
									}
								} 	
								break;
							}
						}catch (InputMismatchException e) {
							System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
							scanner.nextLine(); }
					}
				}

			}catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
				scanner.nextLine(); }
		}
	}


	/**
	 * Imprime a lista de gado de leite.
	 * Este método exibe informações detalhadas sobre cada animal da lista de gado de leite,
	 * incluindo nome, número do brinco, data de ultrassom, previsão de nascimento do bezerro,
	 * início do período seco, regime pré-parto, aplicação de bisnaga de vaca seca e informações do bezerro.
	 */
	public static void printListaGadoDeLeite() {
		System.out.println("\n-=-=-=Lista de Gado de Leite-=-=-=-");
		for (GadoDeLeite gado : listaGadoDeLeite) {
			System.out.println("NOME: " + gado.getNome());
			System.out.println("NUMERO BRINCO: " + gado.getNumeroBrinco());

			if(gado.getDataUltrassom() != null) {
				String dataFormatada = gado.getDataUltrassom().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("DATA DO ULTRASSOM: " + dataFormatada);
			}else
				System.out.println("DATA DO ULTRASSOM: SEM REGISTRO");

			if(gado.getPrevisaoNascimentoBezerro() != null) {
				String dataFormatada = gado.getPrevisaoNascimentoBezerro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("DATA PREVISÃO DE NASCIMENTO DO BEZERRO: " + dataFormatada);
			}else
				System.out.println("DATA PREVISÃO DE NASCIMENTO DO BEZERRO: SEM REGISTRO");

			if(gado.getPeriodoSeco() != null) {
				System.out.println("INICIO DE PERIODO SECO: " + gado.getPeriodoSeco().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}else
				System.out.println("INICIO DE PERIODO SECO: SEM REGISTRO");

			if(gado.getRegimePreParto()!= null) {
				System.out.println("REGIME PRÉ PARTO: " + gado.getRegimePreParto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}
			else 
				System.out.println("REGIME PRÉ PARTO: SEM REGISTRO");

			if(gado.getAplicacaoBisnagaDeVacaSeca() != null) {
				System.out.println("APLICAÇÃO DA BISNAGA DE VACA SECA: " + gado.getAplicacaoBisnagaDeVacaSeca().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				System.out.println("REMÉDIO: " + gado.getMedicamentoAplicado().nome);
				System.out.println("DIAS DE CARENCIA: " + gado.getMedicamentoAplicado().diasCarenciaLeite);
				System.out.println("DATA FINAL DA CARÊNCIA: " + gado.getAplicacaoBisnagaDeVacaSeca().plusDays(gado.getMedicamentoAplicado().diasCarenciaLeite).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}
			else
				System.out.println("APLICAÇÃO DA BISNAGA DE VACA SECA: SEM REGISTRO");


			if(gado.getBezerro() != null) {
				System.out.println("BEZERRO n°: " + gado.getBezerro().getNumeroBrinco());
				System.out.println("DATA DE NASCIMENTO: " + gado.getBezerro().getDataNacimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				System.out.println("PESO: " + gado.getBezerro().getPeso() + "KG");

				if(gado.getBezerro().isSexo() == true) {
					System.out.println("SEXO: MACHO");
				}
				else
					System.out.println("SEXO:FÊMEA");
			}
			else
				System.out.println("BEZERRO: SEM REGISTRO");

			System.out.println("---------------------------------------------------------");

		}


	}

	/**
	 * Imprime a lista de gado de corte.
	 * Este método exibe informações detalhadas sobre cada animal da lista de gado de corte,
	 * incluindo nome, número do brinco, data de ultrassom, previsão de nascimento do bezerro,
	 * regime pré-parto, aplicação de bisnaga de vaca seca e informações do bezerro.
	 */
	public static void printListaGadoDeCorte() {
		System.out.println("\n-=-=-=Lista de Gado de Corte-=-=-=-");
		for (GadoDeCorte gado : listaGadoDeCorte) {
			System.out.println("NOME: " + gado.getNome());
			System.out.println("NUMERO BRINCO: " + gado.getNumeroBrinco());

			if(gado.getDataUltrassom() != null) {
				String dataFormatada = gado.getDataUltrassom().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("DATA DO ULTRASSOM: " + dataFormatada);
			}else
				System.out.println("DATA DO ULTRASSOM: SEM REGISTRO");

			if(gado.getPrevisaoNascimentoBezerro() != null) {
				String dataFormatada = gado.getPrevisaoNascimentoBezerro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("DATA PREVISÃO DE NASCIMENTO DO BEZERRO: " + dataFormatada);
			}else
				System.out.println("DATA PREVISÃO DE NASCIMENTO DO BEZERRO: SEM REGISTRO");

			if(gado.getRegimePreParto()!= null) {
				System.out.println("REGIME PRÉ PARTO: " + gado.getRegimePreParto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}
			else 
				System.out.println("REGIME PRÉ PARTO: SEM REGISTRO");

			if(gado.getAplicacaoBisnagaDeVacaSeca() != null) {
				System.out.println("APLICAÇÃO DA BISNAGA DE VACA SECA: " + gado.getAplicacaoBisnagaDeVacaSeca().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				System.out.println("REMÉDIO: " + gado.getMedicamentoAplicado().nome);
				System.out.println("DIAS DE CARENCIA: " + gado.getMedicamentoAplicado().diasCarenciaCorte);
				System.out.println("DATA FINAL DA CARÊNCIA: " + gado.getAplicacaoBisnagaDeVacaSeca().plusDays(gado.getMedicamentoAplicado().diasCarenciaCorte).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}
			else
				System.out.println("APLICAÇÃO DA BISNAGA DE VACA SECA: SEM REGISTRO");

			if(gado.getBezerro() != null) {
				System.out.println("BEZERRO n°: " + gado.getBezerro().getNumeroBrinco());
				System.out.println("DATA DE NASCIMENTO: " + gado.getBezerro().getDataNacimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				System.out.println("PESO: " + gado.getBezerro().getPeso() + "KG");

				if(gado.getBezerro().isSexo() == true) {
					System.out.println("SEXO: MACHO");
				}
				else
					System.out.println("SEXO:FÊMEA");
			}
			else
				System.out.println("BEZERRO: SEM REGISTRO");

			System.out.println("---------------------------------------------------------");

		}

	}
}
