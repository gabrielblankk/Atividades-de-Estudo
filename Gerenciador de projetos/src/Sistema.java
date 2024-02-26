import java.util.ArrayList;

/**
 * Esta classe representa o sistema principal,
 * responsável pelas informações durante o uso do programa.
 * 
 * @author gabriel_blank
 */
public class Sistema {
	/** Usuário atualmante jogado no sistema. */
    private static Usuario usuario_logado;
    /** Lista dos usuários esxistentes no sistema. */
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    /** Projeto atualmente aberto no sistema. */
    private static Projeto projeto_aberto;
    /** Tarefa atualmente aberta no sistema. */
    private static Tarefa tarefa_aberta;
    
    /**
     * Obtém o usuário atualmente logado no sistema.
     *
     * @return O usuário logado no sistema
     */
    public static Usuario getUsuarioLogado() {
        return usuario_logado;
    }
    
    /**
     * Adiciona um novo usuário ao sistema e o define como usuário logado.
     *
     * @param usuario O novo usuário a ser adicionado e logado
     */
    public static void adicionarUsuario(Usuario usuario) {
        usuario_logado = usuario;
        usuarios.add(usuario);
    }
    
    /**
     * Obtém a lista de usuários registrados no sistema.
     *
     * @return A lista de usuários registrados
     */
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    /**
     * Valida o usuário com o nome e senha fornecidos e, se válido, define-o como usuário logado.
     *
     * @param nome Nome do usuário a ser validado
     * @param senha Senha do usuário a ser validado
     * @return Verdadeiro se a validação for bem-sucedida, falso caso contrário
     */
    public static boolean validaUsuario(String nome, String senha) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNome().equals(nome)) {
                if (usuarios.get(i).getSenha().equals(senha)) {
                    usuario_logado = usuarios.get(i);
                    return true;
                }
            } 
        }
        return false;
    }
    
    /**
     * Define o projeto atualmente aberto no sistema.
     *
     * @param projeto O projeto a ser definido como projeto aberto
     */
    public static void setProjetoAberto(Projeto projeto) {
        projeto_aberto = projeto;
    }
    
    /**
     * Obtém o projeto atualmente aberto no sistema.
     *
     * @return O projeto atualmente aberto
     */
    public static Projeto getProjetoAberto() {
        return projeto_aberto;
    }

    /**
     * Define a tarefa atualmente aberta no sistema.
     *
     * @param tarefa A tarefa a ser definida como tarefa aberta
     */
    public static void setTarefaAberta(Tarefa tarefa) {
        tarefa_aberta = tarefa;
    }
    
    /**
     * Obtém a tarefa atualmente aberta no sistema.
     *
     * @return A tarefa atualmente aberta
     */
    public static Tarefa getTarefaAberta() {
        return tarefa_aberta;
    }
}