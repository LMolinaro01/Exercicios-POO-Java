import javax.swing.JOptionPane;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        if (model.adicionarPessoa(pessoa)) {
            JOptionPane.showMessageDialog(view, "Pessoa cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar pessoa.");
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}