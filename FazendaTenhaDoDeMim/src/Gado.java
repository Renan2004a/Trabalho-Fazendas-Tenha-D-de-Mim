import java.time.LocalDate;

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


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataUltrassom() {
		return dataUltrassom;
	}
	public void setDataUltrassom(LocalDate dataUltrassom) {
		this.dataUltrassom = dataUltrassom;
	}


	public int getNumeroBrinco() {
		return numeroBrinco;
	}
	public void setNumeroBrinco(int numeroBrinco) {
		this.numeroBrinco = numeroBrinco;
	}


	public LocalDate getPrevisaoNascimentoBezerro() {
		return previsaoNascimentoBezerro;
	}
	public void setPrevisaoNascimentoBezerro(LocalDate previsaoNascimentoBezerro) {
		this.previsaoNascimentoBezerro = previsaoNascimentoBezerro;
	}

	public LocalDate getAplicacaoBisnagaDeVacaSeca() {
		return aplicacaoBisnagaDeVacaSeca;
	}
	public void setAplicacaoBisnagaDeVacaSeca(LocalDate aplicacaoBisnagaDeVacaSeca) {
		this.aplicacaoBisnagaDeVacaSeca = aplicacaoBisnagaDeVacaSeca;
	}


	public LocalDate getRegimePreParto() {
		return regimePreParto;
	}
	public void setRegimePreParto(LocalDate regimePreParto) {
		this.regimePreParto = regimePreParto;
	}


	public Bezerros getBezerro() {
		return bezerro;
	}


	public void setBezerro(Bezerros bezerro) {
		this.bezerro = bezerro;
	}

	public Medicamentos getMedicamentoAplicado() {
		return medicamentoAplicado;
	}


	public void setMedicamentoAplicado(Medicamentos medicamentoAplicado) {
		this.medicamentoAplicado = medicamentoAplicado;
	}


}
