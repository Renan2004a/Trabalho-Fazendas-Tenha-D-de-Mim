/**
 * Interface que define os métodos para o gerenciamento de gado.
 * 
 * Esta interface declara os métodos necessários para realizar operações relacionadas ao
 * registro e ao acompanhamento de gado, incluindo o registro de animais, o gerenciamento
 * do período pré-parto, a aplicação de medicamentos e o teste de qualidade do colostro.
 * 
 * As classes que implementam esta interface devem fornecer implementações concretas
 * para cada um desses métodos, de acordo com a lógica específica do sistema de gerenciamento
 * de gado.
 */
public interface GerenciamentoDoGado {
	
    /**
     * Registra um novo animal no sistema. 
     * O método deve solicitar e processar as informações necessárias para o registro,
     * como nome e número de brinco.
     */
	void registrarAnimal();
	
    /**
     * Registra a data do ultrassom para o animal.
     * O método deve solicitar a data do ultrassom e atualizar o registro do animal
     * com essa informação.
     */
	void registroUltrassom();
	
    /**
     * Realiza o gerenciamento do período pré-parto para o animal.
     * O método deve calcular e exibir a previsão de nascimento do bezerro e o início do
     * regime pré-parto com base na data do ultrassom e na idade do bezerro.
     */
	void gerenciamentoPreParto();
	
    /**
     * Registra a aplicação de bisnaga de vaca seca no animal.
     * O método deve solicitar a data da aplicação e o tipo de medicamento utilizado,
     * e atualizar o registro do animal com essas informações.
     */
	void aplicacaoBisnagaDeVacaSeca();
	
	/**
     * Registra o nascimento do bezerro.
     * O método deve solicitar e processar a data de nascimento, o peso e o sexo do bezerro,
     * e atualizar o registro com essas informações.
     */
	void registroNascimentoBezerro();
	
	/**
     * Realiza o teste de qualidade do colostro coletado.
     * O método deve solicitar o valor da qualidade do colostro e informar se o resultado
     * do teste foi aprovado ou reprovado com base no valor informado.
     */
	void testeQualidadeColostro();
}