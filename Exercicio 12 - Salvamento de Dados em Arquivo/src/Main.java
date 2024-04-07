import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("João", 30));
        pessoas.add(new Pessoa("Maria", 25));
        pessoas.add(new Pessoa("Carlos", 40));

        salvarPessoas(pessoas);
    }

    public static void salvarPessoas(List<Pessoa> pessoas) {
        String nomeArquivo = "pessoas.txt";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (Pessoa pessoa : pessoas) {
                writer.write(pessoa.getNome() + "," + pessoa.getIdade() + "\n");
            }
            System.out.println("Dados das pessoas foram salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados das pessoas: " + e.getMessage());
        }
    }
}
