import java.util.Random;
import java.time.LocalDate;

public class Bezerros {

    private LocalDate dataNacimento;
    private int numeroBrinco;
    private double peso;
    private boolean sexo;

    /**
     * Construtor para a classe Bezerros.
     *
     * @param dataNacimento A data de nascimento do bezerro.
     * @param numeroBrinco O número do brinco do bezerro.
     * @param peso O peso do bezerro.
     * @param sexo O sexo do bezerro (true para macho, false para fêmea).
     */  
    public Bezerros(LocalDate dataNacimento, int numeroBrinco, double peso, boolean sexo) {
        this.dataNacimento = dataNacimento;
        this.numeroBrinco = numeroBrinco;
        this.peso = peso;
        this.sexo = sexo;
    }

    /**
     * Obtém a data de nascimento do bezerro.
     *
     * @return A data de nascimento do bezerro.
     */   
    public LocalDate getDataNacimento() {
        return dataNacimento;
    }

    /**
     * Define a data de nascimento do bezerro.
     *
     * @param dataNacimento A nova data de nascimento do bezerro.
     */  
    public void setDataNacimento(LocalDate dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    /**
     * Obtém o número do brinco do bezerro.
     *
     * @return O número do brinco do bezerro.
     */   
    public int getNumeroBrinco() {
        return numeroBrinco;
    }

    /**
     * Define o número do brinco do bezerro.
     *
     * @param numeroBrinco O novo número do brinco do bezerro.
     */
    public void setNumeroBrinco(int numeroBrinco) {
        this.numeroBrinco = numeroBrinco;
    }

    /**
     * Obtém o peso do bezerro.
     *
     * @return O peso do bezerro.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Define o peso do bezerro.
     *
     * @param peso O novo peso do bezerro.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtém o sexo do bezerro.
     *
     * @return true se o bezerro for macho, false se for fêmea.
     */
    public boolean isSexo() {
        return sexo;
    }

    /**
     * Define o sexo do bezerro.
     *
     * @param sexo O novo sexo do bezerro (true para macho, false para fêmea).
     */
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    /**
     * Gera e define um novo número de brinco aleatório para o bezerro.
     */
    public void numeroBrincoBezerro() {
        Random rand = new Random();
        int idBrinco = rand.nextInt(6000) + 1000;
        this.setNumeroBrinco(idBrinco);
    }
}