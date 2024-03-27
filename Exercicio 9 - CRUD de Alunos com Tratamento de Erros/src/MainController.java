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
        hm.put(2, new Estudante(1062021, "Caroline", 10f, 5f, 7.5f, "Aprovado"));
        hm.put(2, new Estudante(1062021, "João", 1f, 5f, 3f, "Reprovado"));
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
                default:
                    System.out.println("\nOpção inválida, tente novamente!\n");
                    continue;
            }
        } while (opcao != 0);
        view.closeScanner();
    }

    private void exibirAlunos() {
         try {
             System.out.println("\n---------- Exibição dos Alunos ----------\n");
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

         catch(java.lang.Exception e) {
             System.out.println("\n Erro Ocorreu. Reinicie o Programa");
         }
    }

    private void cadastrarAluno() {
     try {
         float nota, nota2;
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n---------- Cadastro do Novo Aluno ----------");
            System.out.println("\nDigite a Matricula: ");
            int matricula = scanner.nextInt();

            scanner.nextLine();
            System.out.println("\nDigite o nome: ");
            String nome = scanner.nextLine();
         do {
             boolean notaTypeCorreto = true; // Variável para controlar se a nota é do tipo correto

             System.out.println("\nDigite a Primeira nota: ");

             if (scanner.hasNextFloat()) { // Verifica se a entrada é um número float
                 nota = scanner.nextFloat();
                 if (nota < 0 || nota > 10) { // Verifica se a nota está dentro do intervalo correto
                     System.out.println("\nErro: Por favor, digite uma nota entre 0 e 10.");
                     notaTypeCorreto = false;
                     continue;
                 }
             } else {
                 System.out.println("\nErro: Por favor, digite um número float válido.");
                 scanner.next(); // Limpa o buffer de entrada
                 notaTypeCorreto = false; // Define a flag para indicar que a entrada é inválida
                 continue; // Volta ao início do loop
             }

             System.out.println("\nDigite a Segunda nota: ");

             if (scanner.hasNextFloat()) { // Verifica se a entrada é um número float
                 nota2 = scanner.nextFloat();
                 if (nota2 < 0 || nota2 > 10) { // Verifica se a nota está dentro do intervalo correto
                     System.out.println("\nErro: Por favor, digite uma nota entre 0 e 10.");
                     notaTypeCorreto = false;
                     continue;
                 }
             } else {
                 System.out.println("\nErro: Por favor, digite um número float válido.");
                 scanner.next();
                 notaTypeCorreto = false;
                 continue;
             }

             // Se ambas as notas forem do tipo correto, sai do loop
             if (notaTypeCorreto) {
                 break;
             }
         } while (true);

            float media = (nota + nota2) / 2;

            String aprovacao;

            if (media >= 6) {
                aprovacao = "Aprovado";
            } else {
                aprovacao = "Reprovado";
            }

            System.out.println("\n(Aluno Cadastrado com Sucesso!): ");

            System.out.println("\nMatricula: " + matricula);
            System.out.println("\nNome: " + nome);
            System.out.println("\nPrimeira Nota: " + nota);
            System.out.println("\nSegunda Nota: " + nota2);
            System.out.println("\nMedia: " + media);
            System.out.println("\nStatus de Aprovação: " + aprovacao);

            hm.put(chave++, new Estudante(matricula, nome, nota, nota2, media, aprovacao));

        }
        catch(java.lang.Exception e) {
            System.out.println("\n Um Erro Ocorreu. Reinicie o Programa");
        }
    }

    private void alterarNota() {
        try {
            Scanner scanner2 = new Scanner(System.in);
            exibirAlunos();

            System.out.println("\n---------- Alteração de Nota ----------\n");
            System.out.println("Digite o ID do aluno que deseja excluir: ");
            int idNota = scanner2.nextInt();

            // Verifica se o aluno existe no HashMap
            Estudante idPesquisa = hm.get(idNota);

            boolean alunoEncontrado = false;

            Estudante alunoEditar = hm.get(idNota);
            if (alunoEditar != null) {
                // Se o aluno existe, solicita confirmação para exclusão
                System.out.println("\nVocê realmente deseja editar as notas do Aluno (" + idNota + "): " + alunoEditar.getNome() + ", Notas: (" + alunoEditar.getNota() + ", " + alunoEditar.getNota2() + ") ?");
                System.out.println("\n(Digite (1) para Confirmar ou (2) para Cancelar)");
                int confirmacao = scanner2.nextInt();

                // Confirmação da exclusão
                for (Estudante estudanteExemplo : hm.values()) {
                    if (confirmacao == 1) {
                        System.out.println("Digite a nova Primeira nota: ");
                        float novaNota = scanner2.nextFloat();
                        estudanteExemplo.setNota(novaNota);

                        System.out.println("Digite a nova Segunda nota: ");
                        float novaNota2 = scanner2.nextFloat();
                        estudanteExemplo.setNota2(novaNota2);

                        float novaMedia = (novaNota2 + novaNota) / 2;
                        estudanteExemplo.setMedia(novaMedia);

                        String novaAprovacao = estudanteExemplo.getAprovacao();
                        estudanteExemplo.setAprovacao(novaAprovacao);

                        alunoEncontrado = true;
                        System.out.println("\n(As Notas foram alteradas com sucesso!)");
                        System.out.println("\nNovas notas do Aluno: (" + estudanteExemplo.getNota() + ", " + estudanteExemplo.getNota2() + ")");
                        break;

                    }
                }

                if (!alunoEncontrado) {
                    System.out.println("\nAluno não encontrado.");
                }

            }
        }
        catch(java.lang.Exception e) {
            System.out.println("\nUm Erro Ocorreu. Reinicie o Programa");
        }
    }


    private void excluirAluno() {
        try {
            Scanner scanner = new Scanner(System.in);
            exibirAlunos();

            System.out.println("\n---------- Exclusão de um Aluno ----------\n");
            System.out.println("Digite o ID do aluno que deseja excluir: ");
            int id = scanner.nextInt();

            // Verifica se o aluno existe no HashMap
            Estudante alunoExcluir = hm.get(id);
            if (alunoExcluir != null) {
                // Se o aluno existe, solicita confirmação para exclusão
                System.out.println("\nVocê realmente deseja excluir o Aluno (" + id + "): " + alunoExcluir.getNome() + " ?");
                System.out.println("\nDigite (1) para Confirmar ou (2) para Cancelar.");
                int confirmacao = scanner.nextInt();

                // Confirmação da exclusão
                if (confirmacao == 1) {
                    // Remove o aluno do HashMap
                    Estudante alunoRemovido = hm.remove(id);
                    System.out.println("\nAluno removido com sucesso:");
                    System.out.println(alunoRemovido);
                } else {
                    System.out.println("\nAluno não removido.");
                }
            } else {
                System.out.println("\nAluno não encontrado.");
            }
        }

        catch(java.lang.Exception e) {
                System.out.println("\nUm Erro Ocorreu. Reinicie o Programa");
            }
        }

}