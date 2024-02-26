import java.util.ArrayList;

/**
 * Esta classe representa uma tarefa de algum projeto.
 * 
 * @author gabriel_blank
 */
public class Tarefa {
	/** Nome da tarefa. */
    private String nome;
    /** Descrição da tarefa. */
    private String descricao;
    /** Data do prazo de entrega da tarefa. */
    private String prazo;
    /** Situação atual da tarefa. */
    private String status;
    /** Nível de prioridade da tarefa. */
    private String prioridade;
    /** Lista de comentários dos usuários da tarefa. */
    private ArrayList<String> comentarios = new ArrayList<String>();
    
    /**
     * Construtor da classe Tarefa.
     *
     * @param nome Nome da tarefa
     * @param descricao Descrição da tarefa
     * @param prazo Prazo de conclusão da tarefa
     * @param status Status da tarefa
     * @param prioridade Prioridade da tarefa
     */
    public Tarefa(String nome, String descricao, String prazo, String status, String prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.status = status;
        this.prioridade = prioridade;
    }

    /**
     * Define o nome da tarefa.
     *
     * @param nome O novo nome da tarefa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém o nome da tarefa.
     *
     * @return O nome da tarefa
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define a descrição da tarefa.
     *
     * @param descricao A nova descrição da tarefa
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Obtém a descrição da tarefa.
     *
     * @return A descrição da tarefa
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a prioridade da tarefa.
     *
     * @param prioridade A nova prioridade da tarefa
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * Obtém a prioridade da tarefa.
     *
     * @return A prioridade da tarefa
     */
    public String getPrioridade() {
        return prioridade;
    }
    
    /**
     * Define o status da tarefa.
     *
     * @param status O novo status da tarefa
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Obtém o status da tarefa.
     *
     * @return O status da tarefa
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Define o prazo de conclusão da tarefa.
     *
     * @param prazo O novo prazo de conclusão da tarefa
     */
    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }
    
    /**
     * Obtém o prazo de conclusão da tarefa.
     *
     * @return O prazo de conclusão da tarefa
     */
    public String getPrazo() {
        return prazo;
    }
    
    /**
     * Adiciona um comentário à lista de comentários da tarefa.
     *
     * @param comentario O comentário a ser adicionado
     */
    public void adicionarComentario(String comentario) {
        comentarios.add(comentario);
    }
    
    /**
     * Obtém a lista de comentários associados à tarefa.
     *
     * @return A lista de comentários da tarefa
     */
    public ArrayList<String> getComentarios() {
        return comentarios;
    }
}
