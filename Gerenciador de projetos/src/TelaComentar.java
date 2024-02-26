import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaComentar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Construtor da classe TelaComentar.
	 */
	public TelaComentar() {
		// Configurações da janela de comentários
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Comentar");
		setBounds(700, 300, 419, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Área de texto para inserir o comentário
		JTextArea txtComentario = new JTextArea();
		txtComentario.setDropMode(DropMode.INSERT);
		txtComentario.setBounds(54, 11, 294, 83);
		contentPane.add(txtComentario);
		
		// Rótulo para exibir mensagem de erro
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setBounds(54, 105, 294, 27);
		contentPane.add(lblMensagem);
		
		// Botão para enviar o comentário
		JButton btnEnviarComentario = new JButton("Enviar Comentário");
		btnEnviarComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se o campo de comentário está em branco e exibe mensagem
				if (txtComentario.getText().isBlank()) {
					txtComentario.setBorder(new LineBorder(Color.RED));
					lblMensagem.setText("Escreva alguma coisa.");
				} else {
					// Se não estiver em branco, remove a borda vermelha
					txtComentario.setBorder(new LineBorder(Color.GRAY));
			
					// Obtém a data e hora atual
					LocalDateTime dateObj = LocalDateTime.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					String hora = dateObj.format(format);
					
					// Cria o formato do comentário com data, nome do usuário e conteúdo
					String comentario = "(" + hora + ") " + Sistema.getUsuarioLogado().getNome() + " - " + txtComentario.getText();
					
					// Adiciona o comentário à tarefa atual
					Sistema.getTarefaAberta().adicionarComentario(comentario);
					
					// Fecha a janela de comentários e volta para a tela de tarefas
					TelaComentar.this.dispose();
					TelaTarefas ttf = new TelaTarefas();
					ttf.setVisible(true);
				}
			}
		});
		btnEnviarComentario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnviarComentario.setBounds(120, 151, 164, 37);
		contentPane.add(btnEnviarComentario);
		
		// Botão para voltar para a tela de tarefas sem enviar o comentário
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComentar.this.dispose();
				TelaTarefas ttf = new TelaTarefas();
				ttf.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(294, 151, 99, 37);
		contentPane.add(btnVoltar);
		
	}

}
