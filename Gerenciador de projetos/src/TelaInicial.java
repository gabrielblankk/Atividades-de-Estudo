import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Método principal que inicia a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Construtor da classe TelaInicial.
     */
    public TelaInicial() {
        // Configurações da janela principal
        setTitle("ForTech");
        setBounds(700, 300, 450, 259);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // Layout sem gerenciador de layout

        // Botão "Cadastrar" com ação para abrir a tela de cadastro
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual (TelaInicial) e abre a TelaCadastro
                TelaInicial.this.dispose();
                TelaCadastro tc = new TelaCadastro();
                tc.setVisible(true);
            }
        });
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastrar.setBounds(243, 150, 132, 35);
        getContentPane().add(btnCadastrar);

        // Botão "Entrar" com ação para abrir a tela de login
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual (TelaInicial) e abre a TelaLogin
                TelaInicial.this.dispose();
                TelaLogin tl = new TelaLogin();
                tl.setVisible(true);
            }
        });
        btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEntrar.setBounds(52, 150, 132, 35);
        getContentPane().add(btnEntrar);

        // Rótulo "Bem Vindo" com formatação
        JLabel lblNewLabel = new JLabel("Bem Vindo");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(98, 11, 236, 46);
        getContentPane().add(lblNewLabel);

        // Rótulo "ForTech" com formatação
        JLabel lblFortech = new JLabel("ForTech");
        lblFortech.setHorizontalAlignment(SwingConstants.CENTER);
        lblFortech.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblFortech.setBounds(98, 50, 236, 46);
        getContentPane().add(lblFortech);
    }
}
