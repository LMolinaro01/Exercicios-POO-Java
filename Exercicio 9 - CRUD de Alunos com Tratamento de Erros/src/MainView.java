import java.util.Scanner;

public class MainView {
    private final Scanner scanner;

    public MainView() {
        scanner = new Scanner(System.in);
    }

    public int exibirMenu() {

        System.out.println("_______________________");
        System.out.println("Escolha a Opção: ");
        System.out.println("Opção 1 - Cadastro do Aluno e suas Notas");
        System.out.println("Opção 2 - Exibir os Alunos");
        System.out.println("Opção 3 - Alterar nota");
        System.out.println("Opção 4 - Excluir alunos");
        System.out.println("Opção 0 - Sair do programa");
        System.out.println("_______________________");
        System.out.print("Digite a opção: ");

        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}