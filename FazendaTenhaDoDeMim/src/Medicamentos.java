
public class Medicamentos {

	public String nome;
	public int diasCarenciaLeite;
	public int diasCarenciaCorte;

	public Medicamentos(String nome, int diasCarenciaLeite, int diasCarenciaCorte) {
		this.nome = nome;
		this.diasCarenciaLeite = diasCarenciaLeite;
		this.diasCarenciaCorte = diasCarenciaCorte;
	}

	public static Medicamentos cepravin = new Medicamentos("Cepravin Dry Cow", 60, 28);
	public static Medicamentos orbenin = new Medicamentos("Orbenin Dry Cow", 48, 30);
	public static Medicamentos albiotic = new Medicamentos("Albiotic Dry Cow", 60, 25);
	public static Medicamentos bovimast = new Medicamentos("Bovimast Dry Cow", 56, 30);
	public static Medicamentos spectrazol = new Medicamentos("Spectrazol Milking Cow", 65, 20);	

	public String toStringLeite() {
		return "MEDICAMENTO: " + nome +
				"\nDIAS DE CARÊNCIA (Leite): " + diasCarenciaLeite;
	}

	public String toStringCorte() {
		return "MEDICAMENTO: " + nome +
				"\nDIAS DE CARÊNCIA (Corte): " + diasCarenciaCorte;
	}
}
