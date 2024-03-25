import java.util.HashMap;
import java.util.Scanner;

//Classe que controla o fluxo principal do programa.
public class MainController {
    private final MainView view; // Instância da classe MainView para interação com o usuário.
    private final HashMap<Integer, Estudante> hm; // HashMap para armazenar os estudantes usando a matrícula como chave.
    private int chave; // Variável para controlar as chaves do HashMap.

    //Construtor da classe MainController. Inicializa a instância da MainView, o HashMap e os dados iniciais.
    public MainController() {

        view = new MainView(); // Inicializa a instância da MainView.
        hm = new HashMap<>(); // Inicializa o HashMap.
        inicializarDados(); // Método para inicializar os dados dos estudantes.
        chave = 3; // Define a chave inicial para inserção de novos estudantes.

    }

    private void inicializarDados() {
        hm.put(1, new Estudante(1062021, "Lucas", 8.5f, 4.5f, 6.5f,"Aprovado"));
        hm.put(2, new Estudante(1062021, "Caroline", 10f, 10f, 10f, "Aprovado"));
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    exibirAlunos();
                    break;
                case 3:
                    alterarNota();
                    break;
                case 4:
                    excluirAluno();
                    break;
            }
        } while (opcao != 0);
        view.closeScanner();
    }

    private void exibirAlunos() {
        if (!hm.isEmpty()) { // Verifica se o HashMap não está vazio.
            hm.forEach((key, value) -> { // Itera sobre cada entrada no HashMap.
                System.out.println("ID: " + key);

                System.out.println("\nMatricula: " + value.getMatricula());

                System.out.println("\nNome: " + value.getNome());

                System.out.println("\nPrimeira Nota: " + value.getNota());

                System.out.println("\nSegunda Nota: " + value.getNota2());

                System.out.println("\nMedia: " + value.getMedia());

                System.out.println("\nStatus de Aprovação: " + value.getAprovacao());

                System.out.println("-----------------------------");
            });
        } else {
            System.out.println("Não há alunos cadastrados.");
        }
    }

    private void cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite a Matricula: ");
        int matricula = scanner.nextInt();

        System.out.println("\nDigite o nome: ");
        String nome = scanner.next();

        System.out.println("\nDigite a Primeira nota: ");
        float nota = scanner.nextFloat();

        System.out.println("\nDigite a Segunda nota: ");
        float nota2 = scanner.nextFloat();

        float media = (nota + nota2)/2;

        String aprovacao;

        if (media >= 6){
            aprovacao = "Aprovado";
        }
        else{
            aprovacao = "Reprovado";
        }

        hm.put(chave++, new Estudante(matricula, nome, nota, nota2, media, aprovacao));


    }

    private void alterarNota() {

        exibirAlunos();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do aluno que deseja alterar a nota: ");

        String nomePesquisa = scanner.next();
        boolean alunoEncontrado = false;

        for (Estudante estudante : hm.values()) {
            if (estudante.getNome().equalsIgnoreCase(nomePesquisa)) {

                    System.out.println("Digite a nova Primeira nota: ");
                    float novaNota = scanner.nextFloat();
                    estudante.setNota(novaNota);

                    System.out.println("Digite a nova Segunda nota: ");
                    float novaNota2 = scanner.nextFloat();
                    estudante.setNota2(novaNota2);

                    alunoEncontrado = true;
                    break;
            }
        }
        if (!alunoEncontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }


    /* private void alterarNota() {
        Scanner scanner = new Scanner(System.in);
        exibirAlunos();

        System.out.println("Digite o ID do Aluno que deseja alterar as Notas: ");
        int idPesquisa = scanner.nextInt();

        boolean alunoEncontrado = false;
        for (Estudante estudante : hm.values()) {
            if (chave == idPesquisa) {

                System.out.println("Digite a nova Primeira nota: ");
                float novaNota = scanner.nextFloat();
                estudante.setNota(novaNota);

                System.out.println("Digite a nova Segunda nota: ");
                float novaNota2 = scanner.nextFloat();
                estudante.setNota2(novaNota2);

                alunoEncontrado = true;
                break;
            }
        }
        if (!alunoEncontrado) {
            System.out.println("Aluno não encontrado.");
        }
    } */

    private void excluirAluno() {
        Scanner scanner = new Scanner(System.in);
        exibirAlunos();

        System.out.println("Digite o ID do aluno que deseja excluir: ");
        int id = scanner.nextInt();

        // Verifica se o aluno existe no HashMap
        Estudante alunoExcluir = hm.get(id);
        if (alunoExcluir != null) {
            // Se o aluno existe, solicita confirmação para exclusão
            System.out.println("Você realmente deseja excluir o Aluno (" + id + "): " + alunoExcluir.getNome() + " ?");
            System.out.println("Digite (1) para Confirmar ou (2) para Cancelar.");
            int confirmacao = scanner.nextInt();

            // Confirmação da exclusão
            if (confirmacao == 1) {
                // Remove o aluno do HashMap
                Estudante alunoRemovido = hm.remove(id);
                System.out.println("Aluno removido com sucesso:");
                System.out.println(alunoRemovido);
            }
            else{
                System.out.println("Aluno não removido.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

}