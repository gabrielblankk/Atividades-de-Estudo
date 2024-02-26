import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TelaCriarProjeto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Construtor da classe TelaCriarProjeto.
	 */
	public TelaCriarProjeto() {
		// Configurações da janela de criação de projeto
		setTitle("Criar Novo Projeto");
		setBounds(700, 300, 450, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Rótulo "Criar Projeto"
		JLabel lblCriarProjeto = new JLabel("Criar Projeto");
		lblCriarProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriarProjeto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCriarProjeto.setBounds(115, 11, 200, 53);
		contentPane.add(lblCriarProjeto);

		// Rótulo e campo de texto para o nome do projeto
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 92, 60, 37);
		contentPane.add(lblNewLabel);
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(126, 99, 231, 27);
		contentPane.add(txtNome);

		// Rótulo e lista de usuários disponíveis
		JLabel lblUsurios = new JLabel("Usuários:");
		lblUsurios.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsurios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurios.setBounds(44, 140, 75, 37);
		contentPane.add(lblUsurios);
		ArrayList<Usuario> usuarios = Sistema.getUsuarios();
		ArrayList<String> nome_usuarios = new ArrayList<String>();
		String[] array = new String[usuarios.size()];
		
		// Preenche a lista de usuários excluindo o usuário logado
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome() != Sistema.getUsuarioLogado().getNome()) {
				nome_usuarios.add(usuarios.get(i).getNome());				
			}
		}
		JList<String> listaUsuarios = new JList<String>(nome_usuarios.toArray(array));
		listaUsuarios.setBorder(new LineBorder(Color.LIGHT_GRAY));
		listaUsuarios.setBounds(126, 151, 231, 181);
		contentPane.add(listaUsuarios);
		
		// Rótulo para exibir mensagem de erro
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setBounds(126, 343, 231, 27);
		contentPane.add(lblMensagem);

		// Botão "Criar" com ação para criar um novo projeto
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();

				if (nome.isBlank()) {
					txtNome.setBorder(new LineBorder(Color.RED));
					lblMensagem.setText("Insira um nome para o projeto.");
				} else {
					txtNome.setBorder(new LineBorder(Color.GRAY));

					// Obtém a lista de usuários selecionados
					ArrayList<String> usuarios_selecionados = new ArrayList<String>(listaUsuarios.getSelectedValuesList());

					// Obtém a data atual
					LocalDate dateObj = LocalDate.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String data_criacao = dateObj.format(format);

					// Cria um novo projeto
					Projeto projeto = new Projeto(nome, data_criacao, Sistema.getUsuarioLogado().getNome(), usuarios_selecionados);

					// Adiciona o projeto ao usuário logado
					Sistema.getUsuarioLogado().adicionarProjetos(projeto);

					// Adiciona o projeto aos usuários selecionados
					if (!usuarios_selecionados.isEmpty()) {
						for (int i = 0; i < usuarios.size(); i++) {
							for (int j = 0; j < usuarios_selecionados.size(); j++) {
								if (usuarios.get(i).getNome().equals(usuarios_selecionados.get(j))) {
									usuarios.get(i).adicionarProjetos(projeto);
								}							
							}
						}
					}

					// Fecha a tela atual e abre a tela de projetos
					TelaCriarProjeto.this.dispose();
					TelaProjetos tp = new TelaProjetos();
					tp.setVisible(true);
				}
			}
		});
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(216, 388, 99, 37);
		contentPane.add(btnCriar);

		// Botão "Voltar" com ação para retornar à tela de projetos
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriarProjeto.this.dispose();
				TelaProjetos tp = new TelaProjetos();
				tp.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(325, 388, 99, 37);
		contentPane.add(btnVoltar);
		
	}
}
