
/**
 * Representa um medicamento utilizado no manejo de gado.
 * 
 * A classe {@code Medicamentos} contém informações sobre o nome do medicamento e os períodos
 * de carência para leite e para corte. Ela também inclui instâncias estáticas de medicamentos
 * comuns utilizados no manejo de gado de leite e de corte.
 * 
 * A carência para leite é o período após a aplicação do medicamento durante o qual o leite
 * não pode ser utilizado para consumo. A carência para corte é o período após a aplicação
 * do medicamento durante o qual o animal não pode ser abatido para consumo.
 */
public class Medicamentos {

    /**
     * Nome do medicamento.
     * Número de dias de carência para leite.
     * Número de dias de carência para corte.
     */
	public String nome;
	public int diasCarenciaLeite;
	public int diasCarenciaCorte;

    /**
     * Constrói uma nova instância de {@code Medicamentos} com os valores fornecidos.
     * 
     * @param nome o nome do medicamento
     * @param diasCarenciaLeite o número de dias de carência para leite
     * @param diasCarenciaCorte o número de dias de carência para corte
     */
	public Medicamentos(String nome, int diasCarenciaLeite, int diasCarenciaCorte) {
		this.nome = nome;
		this.diasCarenciaLeite = diasCarenciaLeite;
		this.diasCarenciaCorte = diasCarenciaCorte;
	}

    /**
     * Instância do medicamento "Cepravin Dry Cow".
     * Instância do medicamento "Orbenin Dry Cow".
     * Instância do medicamento "Albiotic Dry Cow".
     * Instância do medicamento "Bovimast Dry Cow".
     * Instância do medicamento "Spectrazol Milking Cow".
     */
	public static Medicamentos cepravin = new Medicamentos("Cepravin Dry Cow", 60, 28);
	public static Medicamentos orbenin = new Medicamentos("Orbenin Dry Cow", 48, 30);
	public static Medicamentos albiotic = new Medicamentos("Albiotic Dry Cow", 60, 25);
	public static Medicamentos bovimast = new Medicamentos("Bovimast Dry Cow", 56, 30);
	public static Medicamentos spectrazol = new Medicamentos("Spectrazol Milking Cow", 65, 20);	
	
    /**
     * Retorna uma representação em string do medicamento incluindo o nome e o período
     * de carência para leite.
     * 
     * @return uma string com o nome do medicamento e os dias de carência para leite
     */
	public String toStringLeite() {
		return "MEDICAMENTO: " + nome +
				"\nDIAS DE CARÊNCIA (Leite): " + diasCarenciaLeite;
	}

    /**
     * Retorna uma representação em string do medicamento incluindo o nome e o período
     * de carência para corte.
     * 
     * @return uma string com o nome do medicamento e os dias de carência para corte
     */
	public String toStringCorte() {
		return "MEDICAMENTO: " + nome +
				"\nDIAS DE CARÊNCIA (Corte): " + diasCarenciaCorte;
	}
}
