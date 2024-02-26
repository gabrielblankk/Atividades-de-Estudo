import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class TelaCriarTarefa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;

	/**
	 * Construtor da classe TelaCriarTarefa.
	 */
	public TelaCriarTarefa() {
		// Configurações da janela para criar tarefas
		setBounds(700, 300, 450, 520);
		setTitle("Criar Tarefa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		// Rótulo "Criar Tarefa"
		JLabel lblCriarTarefa = new JLabel("Criar Tarefa");
		lblCriarTarefa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriarTarefa.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCriarTarefa.setBounds(119, 11, 200, 53);
		getContentPane().add(lblCriarTarefa);
		
		// Rótulo e campo de texto para o nome da tarefa
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(63, 92, 60, 37);
		getContentPane().add(lblNome);
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(130, 99, 231, 27);
		getContentPane().add(txtNome);
		
		// Rótulo e combobox para a prioridade da tarefa
		JLabel lblPrioridade = new JLabel("Prioridade:");
		lblPrioridade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrioridade.setBounds(36, 140, 87, 37);
		getContentPane().add(lblPrioridade);
		
		// Rótulo e combobox para o status da tarefa
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(63, 188, 60, 37);
		getContentPane().add(lblStatus);
		
		// Rótulo e campo de texto formatado para o prazo da tarefa
		JLabel lblPrazo = new JLabel("Prazo:");
		lblPrazo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrazo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrazo.setBounds(63, 236, 60, 37);
		getContentPane().add(lblPrazo);
		JFormattedTextField txtPrazo = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		txtPrazo.setBounds(130, 243, 112, 27);
		getContentPane().add(txtPrazo);
		
		// Rótulo e campo de texto para a descrição da tarefa
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescricao.setBounds(36, 284, 87, 37);
		getContentPane().add(lblDescricao);
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDescricao.setColumns(4);
		txtDescricao.setBounds(130, 292, 231, 82);
		getContentPane().add(txtDescricao);
		
		// Combobox para a prioridade da tarefa
		JComboBox cbPrioridade = new JComboBox();
		cbPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbPrioridade.setModel(new DefaultComboBoxModel(new String[] {"Média", "Alta", "Baixa"}));
		cbPrioridade.setBounds(130, 149, 112, 22);
		getContentPane().add(cbPrioridade);
		
		// Combobox para o status da tarefa
		JComboBox cbStatus = new JComboBox();
		cbStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"A fazer", "Em processo", "Pronta", "Revisão"}));
		cbStatus.setBounds(130, 197, 112, 22);
		getContentPane().add(cbStatus);
		
		// Rótulo para exibir mensagens de erro
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setBounds(36, 385, 325, 27);
		getContentPane().add(lblMensagem);

		// Botão "Criar" com ação para criar a nova tarefa
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtém os dados da nova tarefa
				String nome = txtNome.getText();
				String prioridade = cbPrioridade.getSelectedItem().toString();
				String status = cbStatus.getSelectedItem().toString();
				String prazo = txtPrazo.getText();
				String descricao = txtDescricao.getText();
				
				// Valida os campos obrigatórios e adiciona bordas destacadas
				boolean[] valido = {false, false, false};
				
				if (nome.isBlank()) {
					txtNome.setBorder(new LineBorder(Color.RED));
				} else {
					valido[0] = true;
					txtNome.setBorder(new LineBorder(Color.GRAY));
				}
				
				if (prazo.isBlank()) {
					txtPrazo.setBorder(new LineBorder(Color.RED));
				} else {
					valido[1] = true;
					txtPrazo.setBorder(new LineBorder(Color.GRAY));
				}
				
				if (descricao.isBlank()) {
					txtDescricao.setBorder(new LineBorder(Color.RED));
				} else {
					valido[2] = true;
					txtDescricao.setBorder(new LineBorder(Color.GRAY));
				}
				
				// Verificação para exibiçção das mensagens de erro
				if (nome.isBlank() && descricao.isBlank() && prazo.isBlank()) {
					lblMensagem.setText("Preencha os campos.");
				} else if (!valido[0]) {
					lblMensagem.setText("Insira um nome para a tarefa.");
				} else if (!valido[1]) {
					lblMensagem.setText("A data deve estar no formato adequado.");
				} else if (!valido[2]) {
					lblMensagem.setText("Insira uma descrição para a tarefa.");
				}
				
				// Se todos os campos obrigatórios são válidos, cria a tarefa e volta para a tela de tarefas
				if (valido[0] && valido[1] && valido[2]) {
					Sistema.getProjetoAberto().adicionarTarefa(new Tarefa(nome, descricao, prazo, status, prioridade));
					TelaCriarTarefa.this.dispose();
					TelaTarefas ttf = new TelaTarefas();
					ttf.setVisible(true);
				}
			}
		});
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(216, 433, 99, 37);
		getContentPane().add(btnCriar);
		
		// Botão "Voltar" com ação para voltar para a tela de tarefas
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriarTarefa.this.dispose();
				TelaTarefas ttf = new TelaTarefas();
				ttf.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(325, 433, 99, 37);
		getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("dd/mm/aaaa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(252, 242, 92, 24);
		getContentPane().add(lblNewLabel);
		
	}
}
