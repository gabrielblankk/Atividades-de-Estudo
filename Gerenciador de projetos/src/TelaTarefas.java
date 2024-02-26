import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaTarefas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Construtor da classe TelaTarefas.
	 */
	public TelaTarefas() {
		// Configurações da janela de tarefas
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 696, 512);
		setTitle("Tarefas");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Botão "Voltar" com ação para retornar à tela de projetos
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTarefas.this.dispose();
				TelaProjetos tp = new TelaProjetos();
				tp.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(571, 8, 99, 37);
		contentPane.add(btnVoltar);
		
		// Rótulo indicando o projeto aberto
		JLabel lblProjetoAberto = new JLabel("Projeto: " + Sistema.getProjetoAberto().getNome());
		lblProjetoAberto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblProjetoAberto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProjetoAberto.setBounds(139, 11, 422, 31);
		contentPane.add(lblProjetoAberto);
		
		// Lista de tarefas disponíveis no projeto aberto
		ArrayList<Tarefa> tarefas = Sistema.getProjetoAberto().getTarefas();
		ArrayList<String> nome_tarefas = new ArrayList<String>();
		String[] arrayTarefas = new String[tarefas.size()];
		
		for (int i = 0; i < tarefas.size(); i++) {
			nome_tarefas.add(tarefas.get(i).getNome());
		}
		JList listaTarefas = new JList(nome_tarefas.toArray(arrayTarefas));
		listaTarefas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listaTarefas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTarefas.setBounds(10, 56, 319, 358);
		contentPane.add(listaTarefas);
		
		// Rótulo indicando o título "Tarefas"
		JLabel lblNewLabel = new JLabel("Tarefas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 77, 31);
		contentPane.add(lblNewLabel);
		
		// Painel de exibição dos detalhes da tarefa selecionada
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(Color.WHITE);
		panel.setBounds(339, 56, 331, 406);
		contentPane.add(panel);
		
		// Rótulos e campos para exibir informações da tarefa
		JLabel lblPrioridade = new JLabel("");
		lblPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrioridade.setBounds(10, 11, 311, 23);
		panel.add(lblPrioridade);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(10, 45, 311, 23);
		panel.add(lblStatus);
		
		JLabel lblPrazo = new JLabel("");
		lblPrazo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrazo.setBounds(10, 79, 311, 23);
		panel.add(lblPrazo);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(10, 147, 311, 100);
		panel.add(txtDescricao);
		
		JLabel lblDescricao = new JLabel("");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(10, 113, 311, 23);
		panel.add(lblDescricao);
		
		// Rótulo "Comentários"
		JLabel lblComentarios = new JLabel("Comentários");
		lblComentarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComentarios.setBounds(10, 261, 154, 23);
		panel.add(lblComentarios);
		
		// Lista de comentários
		JList listaComentarios = new JList();
		listaComentarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listaComentarios.setBorder(new LineBorder(Color.LIGHT_GRAY));
		listaComentarios.setBounds(10, 295, 311, 100);
		panel.add(listaComentarios);
		
		// Botão "Comentar" com ação para adicionar um comentário à tarefa
		JButton btnComentar = new JButton("Comentar");
		btnComentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarefa_selecionada = listaTarefas.getSelectedValue().toString();
				
				for (int i = 0; i < tarefas.size(); i++) {
					if (tarefa_selecionada.equals(nome_tarefas.get(i))) {
						Sistema.setTarefaAberta(tarefas.get(i));
					}
				}
				
				TelaTarefas.this.dispose();
				TelaComentar tc = new TelaComentar();
				tc.setVisible(true);
			}
		});
		btnComentar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnComentar.setEnabled(false);
		btnComentar.setBounds(226, 260, 95, 26);
		panel.add(btnComentar);
		
		// Botão "Nova Tarefa" com ação para criar uma nova tarefa
		JButton btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTarefas.this.dispose();
				TelaCriarTarefa tct = new TelaCriarTarefa();
				tct.setVisible(true);
			}
		});
		btnNovaTarefa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovaTarefa.setBounds(10, 425, 119, 37);
		contentPane.add(btnNovaTarefa);
		
		// Botão "Excluir" com ação para excluir a tarefa selecionada
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarefa_selecionada = listaTarefas.getSelectedValue().toString();
				
				for (int i = 0; i < tarefas.size(); i++) {
					if (tarefa_selecionada.equals(nome_tarefas.get(i))) {
						Sistema.getProjetoAberto().removerTarefa(i);
					}
				}
				TelaTarefas.this.dispose();
				TelaTarefas ttf = new TelaTarefas();
				ttf.setVisible(true);
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(239, 425, 90, 37);
		contentPane.add(btnExcluir);
		
		// Botão "Editar" com ação para editar a tarefa selecionada
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarefa_selecionada = listaTarefas.getSelectedValue().toString();
				
				for (int i = 0; i < tarefas.size(); i++) {
					if (tarefa_selecionada.equals(nome_tarefas.get(i))) {
						Sistema.setTarefaAberta(tarefas.get(i));
						
						TelaTarefas.this.dispose();
						TelaEditarTarefa tet = new TelaEditarTarefa();
						tet.setVisible(true);
					}
				}
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(139, 425, 90, 37);
		contentPane.add(btnEditar);
		
		// Adiciona um ouvinte de seleção à lista de tarefas para exibir detalhes da tarefa selecionada
		listaTarefas.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
					String tarefa_selecionada = listaTarefas.getSelectedValue().toString();
					
					for (int i = 0; i < tarefas.size(); i++) {
						if (tarefa_selecionada.equals(nome_tarefas.get(i))) {
							String descricao = tarefas.get(i).getDescricao();
							String prazo = tarefas.get(i).getPrazo();
							String prioridade = tarefas.get(i).getPrioridade();
							String status = tarefas.get(i).getStatus();
							
							// Configura os rótulos com informações da tarefa
							lblDescricao.setText("Descrição:");
							txtDescricao.setText(descricao);
							lblPrazo.setText("Prazo: " + prazo);
							lblPrioridade.setText("Prioridade: " + prioridade);
							lblStatus.setText("Status: " + status);
							ArrayList<String> comentarios = new ArrayList<String>();
							String[] arrayComentarios = new String[comentarios.size()];
							
							// Obtém os comentários da tarefa
							for (int j = 0; j < tarefas.size(); j++) {
								if (tarefa_selecionada.equals(nome_tarefas.get(j))) {
									comentarios = (tarefas.get(j).getComentarios());
								}
							}
							
							// Atualiza a lista de comentários
							listaComentarios.setListData(comentarios.toArray(arrayComentarios));
							
							// Habilita os botões de edição, exclusão e comentário
							btnEditar.setEnabled(true);
							btnExcluir.setEnabled(true);
							btnComentar.setEnabled(true);
						}
					}
				}
			}
		});
	}
}
