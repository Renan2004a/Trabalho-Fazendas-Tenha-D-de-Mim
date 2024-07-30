import java.time.LocalDate;


/**
 * Classe abstrata que representa um gado.
 */
public abstract class Gado {

	private String nome;
	private int numeroBrinco;
	private LocalDate dataUltrassom;
	private LocalDate previsaoNascimentoBezerro;
	private LocalDate aplicacaoBisnagaDeVacaSeca;
	private LocalDate regimePreParto; // 30 dias antes
	private Medicamentos medicamentoAplicado;
	private Bezerros bezerro;
	private double qualidadeColostro;
	
	
    /**
     * Construtor para a classe Gado.
     *
     * @param nome O nome do gado.
     * @param numeroBrinco O número do brinco do gado.
     * @param dataUltrassom A data do último ultrassom do gado.
     * @param previsaoNascimentoBezerro A previsão de nascimento do bezerro.
     * @param aplicacaoBisnagaDeVacaSeca A data de aplicação da bisnaga de vaca seca.
     * @param regimePreParto A data de início do regime pré-parto (30 dias antes do parto).
     * @param medicamentoAplicado O medicamento aplicado ao gado.
     * @param bezerro O bezerro associado a este gado.
     * @param qualidadeColostro A qualidade do colostro do gado.
     */
	public Gado(String nome, int numeroBrinco, LocalDate dataUltrassom, LocalDate previsaoNascimentoBezerro, LocalDate aplicacaoBisnagaDeVacaSeca, LocalDate regimePreParto, Medicamentos medicamentoAplicado, Bezerros bezerro, double qualidadeColostro) {
		super();
		this.nome = nome;
		this.numeroBrinco = numeroBrinco;
		this.dataUltrassom = dataUltrassom;
		this.previsaoNascimentoBezerro = previsaoNascimentoBezerro;
		this.aplicacaoBisnagaDeVacaSeca = aplicacaoBisnagaDeVacaSeca;
		this.regimePreParto = regimePreParto;
		this.medicamentoAplicado = medicamentoAplicado;
		this.bezerro = bezerro;
		this.qualidadeColostro = qualidadeColostro;
	}

    /**
     * Obtém o nome do gado.
     *
     * @return O nome do gado.
     */
	public String getNome() {
		return nome;
	}
    /**
     * Define o nome do gado.
     *
     * @param nome O novo nome do gado.
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

    /**
     * Obtém a data do último ultrassom do gado.
     *
     * @return A data do último ultrassom do gado.
     */
	public LocalDate getDataUltrassom() {
		return dataUltrassom;
	}	
    /**
     * Define a data do último ultrassom do gado.
     *
     * @param dataUltrassom A nova data do último ultrassom do gado.
     */
	public void setDataUltrassom(LocalDate dataUltrassom) {
		this.dataUltrassom = dataUltrassom;
	}


    /**
     * Obtém o número do brinco do gado.
     *
     * @return O número do brinco do gado.
     */
	public int getNumeroBrinco() {
		return numeroBrinco;
	}
    /**
     * Define o número do brinco do gado.
     *
     * @param numeroBrinco O novo número do brinco do gado.
     */
	public void setNumeroBrinco(int numeroBrinco) {
		this.numeroBrinco = numeroBrinco;
	}

    /**
     * Obtém a previsão de nascimento do bezerro.
     *
     * @return A previsão de nascimento do bezerro.
     */
	public LocalDate getPrevisaoNascimentoBezerro() {
		return previsaoNascimentoBezerro;
	}	
    /**
     * Define a previsão de nascimento do bezerro.
     *
     * @param previsaoNascimentoBezerro A nova previsão de nascimento do bezerro.
     */
	public void setPrevisaoNascimentoBezerro(LocalDate previsaoNascimentoBezerro) {
		this.previsaoNascimentoBezerro = previsaoNascimentoBezerro;
	}

    /**
     * Obtém a data de aplicação da bisnaga de vaca seca.
     *
     * @return A data de aplicação da bisnaga de vaca seca.
     */
	public LocalDate getAplicacaoBisnagaDeVacaSeca() {
		return aplicacaoBisnagaDeVacaSeca;
	}
    /**
     * Define a data de aplicação da bisnaga de vaca seca.
     *
     * @param aplicacaoBisnagaDeVacaSeca A nova data de aplicação da bisnaga de vaca seca.
     */
	public void setAplicacaoBisnagaDeVacaSeca(LocalDate aplicacaoBisnagaDeVacaSeca) {
		this.aplicacaoBisnagaDeVacaSeca = aplicacaoBisnagaDeVacaSeca;
	}

    /**
     * Obtém a data de início do regime pré-parto.
     *
     * @return A data de início do regime pré-parto.
     */
	public LocalDate getRegimePreParto() {
		return regimePreParto;
	}
    /**
     * Define a data de início do regime pré-parto.
     *
     * @param regimePreParto A nova data de início do regime pré-parto.
     */
	public void setRegimePreParto(LocalDate regimePreParto) {
		this.regimePreParto = regimePreParto;
	}

    /**
     * Obtém o bezerro associado a este gado.
     *
     * @return O bezerro associado a este gado.
     */
	public Bezerros getBezerro() {
		return bezerro;
	}
    /**
     * Define o bezerro associado a este gado.
     *
     * @param bezerro O novo bezerro associado a este gado.
     */
	public void setBezerro(Bezerros bezerro) {
		this.bezerro = bezerro;
	}

    /**
     * Obtém o medicamento aplicado ao gado.
     *
     * @return O medicamento aplicado ao gado.
     */
	public Medicamentos getMedicamentoAplicado() {
		return medicamentoAplicado;
	}

    /**
     * Define o medicamento aplicado ao gado.
     *
     * @param medicamentoAplicado O novo medicamento aplicado ao gado.
     */
	public void setMedicamentoAplicado(Medicamentos medicamentoAplicado) {
		this.medicamentoAplicado = medicamentoAplicado;
	}


}