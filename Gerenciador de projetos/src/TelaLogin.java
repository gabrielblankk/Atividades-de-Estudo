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
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;

	/**
	 * Construtor da classe TelaLogin.
	 */
	public TelaLogin() {
		// Configurações da janela de login
		setTitle("Entrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 505, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Rótulo "Login" com formatação
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(181, 11, 119, 53);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblLogin);

		// Rótulo "Nome" e campo de texto para o nome
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 119, 60, 37);
		contentPane.add(lblNewLabel);
		txtNome = new JTextField();
		txtNome.setBounds(119, 126, 294, 27);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		// Rótulo "Senha" e campo de senha
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(52, 167, 60, 37);
		contentPane.add(lblSenha);
		txtSenha = new JPasswordField();
		txtSenha.setBounds(119, 174, 294, 27);
		contentPane.add(txtSenha);
		
		// Rótulo para exibir mensagens de erro
		JLabel lblMensagem =new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setBounds(119, 212, 294, 27);
		contentPane.add(lblMensagem);

		// Botão "Entrar" com ação para verificar credenciais e redirecionar
		JButton btnLogar = new JButton("Entrar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obter nome e senha
				String nome = txtNome.getText();
				String senha = String.valueOf(txtSenha.getPassword());

				// Valida as credenciais e exibe mensagens de erro
				if (nome.isBlank()) {
					txtNome.setBorder(new LineBorder(Color.RED));
					lblMensagem.setText("Insira o nome.");
				} else if (senha.isBlank()) {
					txtSenha.setBorder(new LineBorder(Color.RED));
					lblMensagem.setText("Insira a senha.");
				} else if (!Sistema.validaUsuario(nome, senha)) {
					txtNome.setBorder(new LineBorder(Color.RED));
					txtSenha.setBorder(new LineBorder(Color.RED));
					lblMensagem.setText("Nome de usuário ou senha inválidos.");
				} else {
					// Se as credenciais forem válidas, redirecionar para a TelaProjetos
					TelaLogin.this.dispose();
					TelaProjetos tp = new TelaProjetos();
					tp.setVisible(true);
				}
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogar.setBounds(242, 273, 99, 37);
		contentPane.add(btnLogar);

		// Botão "Voltar" com ação para retornar à TelaInicial
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin.this.dispose();
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(133, 273, 99, 37);
		contentPane.add(btnVoltar);
		
	}
}
