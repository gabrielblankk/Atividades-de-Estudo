import java.util.ArrayList;

/**
 * A classe Banco representa uma instituição bancária que pode ter vários clientes.
 *
 * @author luiza
 */
public class Banco {
	/** O nome do banco */
    private String nome;
	/**
     * Uma lista de clientes associados a este banco.
     * Cada cliente é representado por um objeto da classe Cliente.
     */
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Construtor padrão do banco com nome "Futuro".
     */
    public Banco() {
        this.nome = "Futuro";
    }

    /**
     * Adiciona um cliente à lista de clientes do banco.
     *
     * @param cliente O cliente a ser adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    /**
     * Mostra os nomes de todos os clientes do banco.
     */
    public void mostrarClientes() {
        for (int i = 0; i < this.clientes.size(); i++) {
            System.out.println(clientes.get(i).getNome());
        }
    }
}
