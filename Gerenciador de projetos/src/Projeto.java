import java.util.ArrayList;

/**
 * Esta classe representa um projeto associado ao usuario.
 * 
 * @author gabriel_blank
 */
public class Projeto {
	/** Nome do projeto. */
    private String nome;
    /** Data de  criação do projeto. */
    private String data_criacao;
    /** Nome do responsável pelo projeto. */
    private String responsavel;
    /** Lista dos nomes dos usuários envolvidos no projeto. */
    private ArrayList<String> usuarios_envolvidos = new ArrayList<String>();
    /** Lista de tarefas atribuídas ao projeto. */
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    
    /**
     * Construtor da classe Projeto.
     *
     * @param nome Nome do projeto
     * @param data_criacao Data de criação do projeto
     * @param responsavel Responsável pelo projeto
     * @param usuarios_envolvidos Lista de usuários envolvidos no projeto
     */
    public Projeto(String nome, String data_criacao, String responsavel, ArrayList<String> usuarios_envolvidos) {
        this.nome = nome;
        this.data_criacao = data_criacao;
        this.responsavel = responsavel;
        this.usuarios_envolvidos = usuarios_envolvidos;
    }
    
    /**
     * Obtém o nome do projeto.
     *
     * @return O nome do projeto
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome do projeto.
     *
     * @param nome O novo nome do projeto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém a data de criação do projeto.
     *
     * @return A data de criação do projeto
     */
    public String getData() {
        return data_criacao;
    }
    
    /**
     * Obtém o responsável pelo projeto.
     *
     * @return O responsável pelo projeto
     */
    public String getResponsavel() {
        return responsavel;
    }
    
    /**
     * Obtém o número de tarefas associadas ao projeto.
     *
     * @return O número de tarefas no projeto
     */
    public int getQuantTarefas() {
        return tarefas.size();
    }
    
    /**
     * Obtém a lista de tarefas associadas ao projeto.
     *
     * @return A lista de tarefas no projeto
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    
    /**
     * Obtém a lista de usuários envolvidos no projeto.
     *
     * @return A lista de usuários envolvidos no projeto
     */
    public ArrayList<String> getUsuarios() {
        return usuarios_envolvidos;
    }
    
    /**
     * Define a lista de usuários envolvidos no projeto.
     *
     * @param usuarios A nova lista de usuários envolvidos no projeto
     */
    public void setusuarios(ArrayList<String> usuarios) {
        usuarios_envolvidos = usuarios;
    }
    
    /**
     * Adiciona uma tarefa à lista de tarefas do projeto.
     *
     * @param tarefa A tarefa a ser adicionada
     */
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }
    
    /**
     * Remove uma tarefa da lista de tarefas do projeto com base no índice.
     *
     * @param index O índice da tarefa a ser removida
     */
    public void removerTarefa(int index) {
        tarefas.remove(index);
    }
}
