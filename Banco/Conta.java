import java.util.ArrayList;

/**
 * A classe Conta representa uma conta bancária associada a um cliente.
 *
 * @author gabriel_blank
 */
public class Conta {
    /** O nome do titular da conta. */
    private String titular;
    /** O login de acesso à conta. */
    private String login;
    /** A senha de acesso à conta. */
    private String senha;
    /** O saldo atual da conta. */
    private double saldo;
    /** O tipo de conta, como "Corrente" ou "Poupança". */
    private String tipo;
	/** A agência bancária relacionada com a conta. */
	private Agencia agencia;
    /**
     * Uma lista de operações financeiras associadas a esta conta.
     * Cada operação é representada por um objeto da classe Operacao.
     */
    private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();

    /**
     * Cria uma nova instância de Conta associada a um cliente.
     * Inicializa o saldo com R$ 10.000,00.
     *
     * @param titular O cliente titular da conta.
     */
    public Conta(Cliente titular) {
        this.titular = titular.getNome();
        this.saldo = 10000;
    }

    /**
     * Obtém o nome do titular da conta.
     *
     * @return O nome do titular da conta.
     */
    public String getTitular() {
        return this.titular;
    }

    /**
     * Define o nome de usuário para acessar a conta.
     *
     * @param login O nome de usuário desejado.
     * @return true se o nome de usuário for válido e definido com sucesso, caso contrário, false.
     */
    public boolean setLogin(String login) {
        if (login.matches("[a-zA-Z0-9_]*")) {
            this.login = login;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o nome de usuário para acessar a conta.
     *
     * @return O nome de usuário para acessar a conta.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Define a senha para acessar a conta.
     *
     * @param senha A senha desejada.
     * @return true se a senha tiver pelo menos 10 caracteres e for definida com sucesso, caso contrário, false.
     */
    public boolean setSenha(String senha) {
        if (senha.length() >= 10) {
            this.senha = senha;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém a senha para acessar a conta.
     *
     * @return A senha para acessar a conta.
     */
    public String getSenha() {
        return this.senha;
    }

    /**
     * Define o saldo da conta.
     *
     * @param saldo O novo saldo da conta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtém o saldo atual da conta.
     *
     * @return O saldo atual da conta.
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Define o tipo da conta.
     *
     * @param tipo O tipo da conta.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém o tipo da conta.
     *
     * @return O tipo da conta.
     */
    public String getTipo() {
        return this.tipo;
    }

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getAgencia() {
		return this.agencia.getNome();
	}

    /**
     * Adiciona uma operação à lista de operações da conta.
     *
     * @param operacao A operação a ser adicionada.
     */
    public void adicionarOperacao(Operacao operacao) {
        this.operacoes.add(operacao);
    }

    /**
     * Mostra as operações realizadas na conta.
     */
    public void mostrarOperacoes() {
        for (int i = 0; i < operacoes.size(); i++) {
            if (operacoes.get(i).getOperacao().equals("Transferência") || operacoes.get(i).getOperacao().equals("Pagamento")) {
                System.out.println(operacoes.get(i).getOperacao() + " - " +
                        operacoes.get(i).getValor() + " para " +
                        operacoes.get(i).getDestinatario() + " - " +
                        operacoes.get(i).getData());
            } else {
                System.out.println(operacoes.get(i).getOperacao() + " - " + operacoes.get(i).getValor() + " - " + operacoes.get(i).getData());
            }
        }
    }
}
