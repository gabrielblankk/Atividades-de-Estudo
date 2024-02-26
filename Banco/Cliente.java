import java.util.ArrayList;

/**
 * A classe Cliente representa um cliente de um banco.
 *
 * @author murilo
 */
public class Cliente {
    /** O nome completo do cliente. */
    private String nome;
    /** O CPF (Cadastro de Pessoas Físicas) do cliente. */
    private String cpf;
    /** O número de telefone de contato do cliente. */
    private String telefone;
    /** O endereço do cliente, representado como um objeto da classe Endereco. */
    private Endereco endereco;
    /**
     * Uma lista de contas bancárias associadas a este cliente.
     * Cada conta é representada por um objeto da classe Conta.
     */
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    /**
     * Define o nome do cliente.
     *
     * @param nome O nome do cliente.
     * @return true se o nome for válido e definido com sucesso, caso contrário, false.
     */
    public boolean setNome(String nome) {
        if (nome.matches("[a-zA-ZçÇáéíóúÁÉÍÓÚãÃõÕ ]*")) {
            this.nome = nome;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return O nome do cliente.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define o CPF do cliente.
     *
     * @param cpf O CPF do cliente.
     * @return true se o CPF for válido (11 dígitos numéricos) e definido com sucesso, caso contrário, false.
     */
    public boolean setCpf(String cpf) {
        if (cpf.length() == 11 && cpf.matches("[0-9]*")) {
            this.cpf = cpf;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o CPF do cliente.
     *
     * @return O CPF do cliente.
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Define o número de telefone do cliente.
     *
     * @param telefone O número de telefone do cliente.
     * @return true se o número de telefone for válido (11 dígitos numéricos) e definido com sucesso, caso contrário, false.
     */
    public boolean setTelefone(String telefone) {
        if (telefone.length() == 11 && telefone.matches("[0-9]*")) {
            this.telefone = telefone;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o número de telefone do cliente.
     *
     * @return O número de telefone do cliente.
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param endereco O endereço do cliente.
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o endereço completo do cliente no formato "País - Estado, Cidade, Rua - Número".
     *
     * @return O endereço completo do cliente.
     */
    public String getEndereco() {
        return this.endereco.getPais() + " , " +
                this.endereco.getEstado() + ", " +
                this.endereco.getCidade() + ", " +
                this.endereco.getRua() + " , " +
                this.endereco.getNumero();
    }

    /**
     * Adiciona uma conta à lista de contas associadas ao cliente.
     *
     * @param conta A conta a ser adicionada.
     */
    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

	public ArrayList<Conta> getContas() {
		return this.contas;
	}
}

