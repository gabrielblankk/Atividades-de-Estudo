import java.util.ArrayList;

/**
 * Esta classe representa um usuário do sistema.
 * 
 * @author gabriel_blank
 */
public class Usuario {
	/** Nome do usuário. */
    private String nome;
    /** Email do usuário. */
    private String email;
    /** Senha do usuário. */
    private String senha;
    /** Lista de projetos associados ao usuário. */
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
    
    /**
     * Construtor da classe Usuario.
     *
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param senha Senha do usuário
     */
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    /**
     * Adiciona um projeto à lista de projetos do usuário.
     *
     * @param projeto O projeto a ser adicionado
     */
    public void adicionarProjetos(Projeto projeto) {
        projetos.add(projeto);
    }
    
    /**
     * Remove um projeto da lista de projetos do usuário com base no índice.
     *
     * @param index O índice do projeto a ser removido
     */
    public void removerProjetos(int index) {
        projetos.remove(index);
    }
    
    /**
     * Obtém a lista de projetos associados ao usuário.
     *
     * @return A lista de projetos do usuário
     */
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }
    
    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário
     */
    public String getSenha() {
        return senha;
    }
}