import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.List;


public class UsuarioGUI extends JFrame {
    private JTable usuariosTable;
    private JButton adicionarButton, editarButton, excluirButton;

    public static void iniciarGUI(){
        SwingUtilities.invokeLater(()->{
            new UsuarioGUI().setVisible(true);
        });
    }

    public UsuarioGUI(){
        setTitle("Gerenciador de Usuários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);

        usuariosTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(usuariosTable);

        adicionarButton = new JButton("Adicionar");
        editarButton = new JButton("Editar");
        excluirButton = new JButton("Excluir");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(adicionarButton);
        buttonPanel.add(editarButton);
        buttonPanel.add(excluirButton);

        //adicionarButton.addActionListener(e -> UsuarioDAO.adicionarUsuario(usuario));
        //editarButton.addActionListener(e -> UsuarioDAO.atualizarUsuario(Usuario usuario));
        //excluirButton.addActionListener(e -> UsuarioDAO.excluirUsuario(Usuario usuario));

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        atualizarTabelaContatos();

    }
    private void atualizarTabelaContatos() {
        List<Usuario> usuarios = UsuarioDAO.listarUsuarios();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email"}, 0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[]{usuario.getId(), usuario.getNome(), usuario.getEmail()});
        }
        usuariosTable.setModel(tableModel);
    }

}


