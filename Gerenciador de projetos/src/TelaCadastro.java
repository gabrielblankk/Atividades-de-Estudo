import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JTextField txtEmail;
	private JPasswordField txtConfirmar;

	/**
	 * Construtor da classe TelaCadastro.
	 */
	public TelaCadastro() {
		// Configurações da janela de cadastro
		setTitle("Cadastrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 527, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Rótulo "Cadastro" com formatação
		JLabel lblCadastrar = new JLabel("Cadastro");
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCadastrar.setBounds(172, 11, 174, 59);
		contentPane.add(lblCadastrar);

		// Rótulo "Nome" e campo de texto para o nome
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, 105, 60, 37);
		contentPane.add(lblNewLabel);
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(130, 112, 312, 27);
		contentPane.add(txtNome);

		// Rótulo "Email" e campo de texto para o email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(60, 153, 60, 37);
		contentPane.add(lblEmail);
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(130, 160, 312, 27);
		contentPane.add(txtEmail);
		
		// Rótulo "Senha" e campo de senha
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(71, 201, 49, 37);
		contentPane.add(lblSenha);
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("");
		txtSenha.setBounds(130, 208, 312, 27);
		contentPane.add(txtSenha);
		
		// Rótulo "Confirmar" e campo de senha para a confirmação
		JLabel lblConfirmarSenha = new JLabel("Confirmar:");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmarSenha.setBounds(33, 249, 87, 37);
		contentPane.add(lblConfirmarSenha);
		txtConfirmar = new JPasswordField();
		txtConfirmar.setBounds(130, 256, 312, 27);
		contentPane.add(txtConfirmar);
		
		// Rótulo para exibir mensagens de erro
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setBounds(43, 294, 399, 27);
		contentPane.add(lblMensagem);

		// Botão "Cadastrar" com ação para verificar os campos e adicionar o usuário
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Array para validar todos os campos do cadastro
				boolean[] valido = {false, false, false, false};

				// Obter e validar o nome
				String nome = txtNome.getText();
				if (!nome.matches("[a-zA-ZçáéíóúÁÉÍÓÚ ]*") || nome.isBlank()) {
					txtNome.setBorder(new LineBorder(Color.RED));
				} else {
					valido[0] = true;
					txtNome.setBorder(new LineBorder(Color.GRAY));
				}

				// Obter e validar o email
				String email = txtEmail.getText();
				Pattern emailRegex = Pattern.compile("^\\S+@\\S+\\.\\S+$");
				if (!emailRegex.matcher(email).find()) {
					txtEmail.setBorder(new LineBorder(Color.RED));
				} else {
					valido[1] = true;
					txtEmail.setBorder(new LineBorder(Color.GRAY));
				}

				// Obter e validar a senha
				String senha = String.valueOf(txtSenha.getPassword());
				if (!senha.matches("[a-zA-Z0-9]*") || senha.isBlank() || senha.length() < 10) {
					txtSenha.setBorder(new LineBorder(Color.RED));
				} else {
					valido[2] = true;
					txtSenha.setBorder(new LineBorder(Color.GRAY));
				}

				// Obter e validar a confirmação de senha
				String confirmar = String.valueOf(txtConfirmar.getPassword());
				if (!confirmar.equals(senha) || confirmar.isBlank() || !valido[2]) {
					txtConfirmar.setBorder(new LineBorder(Color.RED));
				} else {
					valido[3] = true;
					txtConfirmar.setBorder(new LineBorder(Color.GRAY));
				}

				// Verificação para exibir mensagens de erro
				if (nome.isBlank() && email.isBlank() && senha.isBlank() && confirmar.isBlank()) {
					lblMensagem.setText("Preencha os campos.");
				} else if (!valido[0]) {
					lblMensagem.setText("Insira um nome válido.");					
				} else if (!valido[1]) {
					lblMensagem.setText("Insira um email válido. (exemplo@endereço.com)");					
				} else if (!valido[2]) {
					lblMensagem.setText("A senha deve conter no mínimo 10 caracteres com números e letras.");					
				} else if (!valido[3]) {
					lblMensagem.setText("Confirme sua senha.");					
				}
				
				// Se todos os campos estiverem válidos, adicione o usuário e redirecione para TelaProjetos
				if (valido[0] && valido[1] && valido[2] && valido[3]) {
					Sistema.adicionarUsuario(new Usuario(nome, email, senha));
					TelaCadastro.this.dispose();
					TelaProjetos tp = new TelaProjetos();
					tp.setVisible(true);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(260, 356, 99, 37);
		contentPane.add(btnCadastrar);



		// Botão "Voltar" com ação para retornar à TelaInicial
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro.this.dispose();
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(151, 356, 99, 37);
		contentPane.add(btnVoltar);
		
	}
}
