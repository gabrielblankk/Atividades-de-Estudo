/**
 * A classe Agencia representa uma agência bancária.
 *
 * @author herick
 */
public class Agencia {
	/** O nome da agência. */
    private String nome;
    /** O número de telefone de contato da agência. */
    private String telefone;
    /** O endereço da agência. */
    private String endereco;
    /** O nome do gerente responsável pela agência. */
    private String gerente;

	/**
	 * Construtor da classe Agencia que inicializa os campos com base no número da agência.
	 *
	 * Este construtor recebe o número da agência como argumento e configura os campos
	 * nome, telefone, endereço e gerente com valores específicos com base no número da agência.
	 * Se o número da agência não corresponder a nenhum caso no switch, nenhum campo é configurado.
	 *
	 * @param agencia O número da agência para a qual os campos serão configurados.
	 */
	public Agencia(int agencia) {
		switch(agencia) {
			case 1:
				this.nome = "Santander";
				this.telefone = "04740043535";
				this.endereco = "Brasil, SC, Jaraguá, Deodoro da Fonseca, 814";
				this.gerente = "Fulano dos Santos";
				break;
			case 2:
				this.nome = "Banco do Brasil";
				this.telefone = "04740033001";
				this.endereco = "Brasil, SC, Jaraguá, Waldemar Grubba, 2800";
				this.gerente = "Pinédson Teixeira";
				break;
			case 3:
				this.nome = "Bradesco";
				this.telefone = "04721066850";
				this.endereco = "Brasil, SC, Jaraguá, Floriano Peixoto, 134";
				this.gerente = "Ciclano da Silva";
				break;
			default:
				break;
		}
	}

	/**
	* Obtém o nome da agência determinada.
	*
	* @return nome O nome da agência.
	*/
	public String getNome() {
		return this.nome;
	}
}