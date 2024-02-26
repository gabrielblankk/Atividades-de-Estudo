import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaProjetos extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da classe TelaProjetos.
	 */
	public TelaProjetos() {
		// Configurações da janela de projetos
		setBounds(700, 300, 558, 412);
		setTitle("Gerenciador de Projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Botão "Sair" com ação para voltar à TelaInicial
		JButton btnVoltar = new JButton("Sair");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProjetos.this.dispose();
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(450, 11, 82, 37);
		getContentPane().add(btnVoltar);

		// Rótulo exibindo o nome do usuário logado
		JLabel lblUsuarioLogado = new JLabel("Usuário: " + Sistema.getUsuarioLogado().getNome());
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuarioLogado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuarioLogado.setBounds(173, 14, 267, 31);
		getContentPane().add(lblUsuarioLogado);

		// Obtém a lista de projetos do usuário logado
		ArrayList<Projeto> projetos = Sistema.getUsuarioLogado().getProjetos();
		ArrayList<String> nome_projetos = new ArrayList<String>();
		String[] arrayProjetos = new String[projetos.size()];

		// Preenche o array de nomes de projetos
		for (int i = 0; i < projetos.size(); i++) {
			nome_projetos.add(projetos.get(i).getNome());
		}

		// Lista de projetos
		JList listaProjetos = new JList(nome_projetos.toArray(arrayProjetos));
		listaProjetos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProjetos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listaProjetos.setBounds(10, 56, 254, 258);
		getContentPane().add(listaProjetos);

		// Botão "Novo" com ação para criar um novo projeto
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProjetos.this.dispose();
				TelaCriarProjeto tcp = new TelaCriarProjeto();
				tcp.setVisible(true);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(10, 325, 99, 37);
		getContentPane().add(btnNovo);

		// Painel de informações do projeto selecionado
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(Color.WHITE);
		panel.setBounds(274, 56, 258, 258);
		getContentPane().add(panel);
		panel.setLayout(null);

		// Rótulos para exibir informações do projeto
		JLabel lblResponsavel = new JLabel("");
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsavel.setBounds(10, 11, 238, 23);
		panel.add(lblResponsavel);

		JLabel lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 45, 238, 23);
		panel.add(lblData);

		JLabel lblQuantTarefas = new JLabel("");
		lblQuantTarefas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantTarefas.setBounds(10, 224, 121, 23);
		panel.add(lblQuantTarefas);

		JLabel lblPessoas = new JLabel("");
		lblPessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPessoas.setBounds(10, 79, 238, 23);
		panel.add(lblPessoas);

		// Rótulo "Projetos"
		JLabel lblNewLabel_1 = new JLabel("Projetos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 15, 87, 29);
		getContentPane().add(lblNewLabel_1);

		// Botão "Ver Tarefas" com ação para abrir a TelaTarefas do projeto selecionado
		JButton btnVerTarefas = new JButton("Ver Tarefas");
		btnVerTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String projeto_selecionado = listaProjetos.getSelectedValue().toString();
				for (int i = 0; i < projetos.size(); i++) {
					if (projeto_selecionado.equals(nome_projetos.get(i))) {
						Sistema.setProjetoAberto(projetos.get(i));
					}
				}

				TelaProjetos.this.dispose();
				TelaTarefas ttf = new TelaTarefas();
				ttf.setVisible(true);
			}
		});
		btnVerTarefas.setEnabled(false);
		btnVerTarefas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerTarefas.setBounds(141, 223, 107, 26);
		panel.add(btnVerTarefas);

		// Lista de pessoas no projeto
		JList listaPessoas = new JList();
		listaPessoas.setBounds(33, 113, 215, 100);
		panel.add(listaPessoas);
		listaPessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// Botão "Editar" com ação para abrir a TelaEditarProjeto do projeto selecionado
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String projeto_selecionado = listaProjetos.getSelectedValue().toString();

				for (int i = 0; i < projetos.size(); i++) {
					if (projeto_selecionado.equals(nome_projetos.get(i))) {
						Sistema.setProjetoAberto(projetos.get(i));

						TelaProjetos.this.dispose();
						TelaEditarProjeto tep = new TelaEditarProjeto();
						tep.setVisible(true);
					}
				}
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(221, 325, 99, 37);
		getContentPane().add(btnEditar);

		// Botão "Excluir" com ação para excluir o projeto selecionado
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String projeto_selecionado = listaProjetos.getSelectedValue().toString();
				for (int i = 0; i < projetos.size(); i++) {
					if (nome_projetos.get(i).equals(projeto_selecionado)) {
						for (int j = 0; j < Sistema.getUsuarios().size(); j++) {
							Sistema.getUsuarios().get(j).removerProjetos(i);
						}
					}
				}
				TelaProjetos.this.dispose();
				TelaProjetos tp = new TelaProjetos();
				tp.setVisible(true);
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(433, 325, 99, 37);
		getContentPane().add(btnExcluir);

		// Listener para atualizar informações do projeto selecionado
		listaProjetos.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String projeto_selecionado = listaProjetos.getSelectedValue().toString();

					for (int i = 0; i < projetos.size(); i++) {
						if (projeto_selecionado.equals(nome_projetos.get(i))) {
							String responsavel = projetos.get(i).getResponsavel();
							String data = projetos.get(i).getData();
							int quantTarefas = projetos.get(i).getQuantTarefas();
							ArrayList<String> pessoas = projetos.get(i).getUsuarios();
							String[] array = new String[pessoas.size()];

							// Atualiza as informações do projeto
							lblResponsavel.setText("Responsável: " + responsavel);
							lblData.setText("Data de Criação: " + data);
							lblQuantTarefas.setText(quantTarefas + " Tarefas");
							lblPessoas.setText("Pessoas:");

							listaPessoas.setListData(pessoas.toArray(array));

							// Habilita ou desabilita botões de acordo com o responsável do projeto
							if (responsavel.equals(Sistema.getUsuarioLogado().getNome())) {
								btnExcluir.setEnabled(true);
								btnEditar.setEnabled(true);
							} else {
								btnExcluir.setEnabled(false);
								btnEditar.setEnabled(false);
							}
							btnVerTarefas.setEnabled(true);
						}
					}
				}
			}
		});
	}
}
