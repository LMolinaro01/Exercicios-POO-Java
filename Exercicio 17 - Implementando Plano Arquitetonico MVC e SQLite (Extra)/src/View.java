// Pacote 'view'
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame {
    private JTextField campoNome, campoEmail;
    private JButton botaoCadastrar;

    public View() {
        setTitle("Cadastro de Pessoas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        campoNome = new JTextField(20);
        campoEmail = new JTextField(20);
        botaoCadastrar = new JButton("Cadastrar");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Email:"));
        painel.add(campoEmail);
        painel.add(botaoCadastrar);

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();
                Pessoa pessoa = new Pessoa(campoNome.getText(), campoEmail.getText());
                controller.adicionarPessoa(pessoa);
            }
        });

        add(painel);
        setVisible(true);
    }
}
