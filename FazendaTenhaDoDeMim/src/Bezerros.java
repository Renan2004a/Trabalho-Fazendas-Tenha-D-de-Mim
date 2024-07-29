import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;

public class Bezerros {

	private LocalDate dataNacimento;
	private int numeroBrinco;
	private double peso;
	private boolean sexo;


	public Bezerros(LocalDate dataNacimento, int numeroBrinco, double peso, boolean sexo) {
		this.dataNacimento = dataNacimento;
		this.numeroBrinco = numeroBrinco;
		this.peso = peso;
		this.sexo = sexo;
	}


	public LocalDate getDataNacimento() {
		return dataNacimento;
	}



	public void setDataNacimento(LocalDate dataNacimento) {
		this.dataNacimento = dataNacimento;
	}



	public int getNumeroBrinco() {
		return numeroBrinco;
	}


	public void setNumeroBrinco(int numeroBrinco) {
		this.numeroBrinco = numeroBrinco;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public boolean isSexo() {
		return sexo;
	}


	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}



	public void numeroBrincoBezerro() {

		Random rand = new Random();
		int idBrinco = rand.nextInt(6000) + 1000;
		this.setNumeroBrinco(idBrinco);

	}




}
