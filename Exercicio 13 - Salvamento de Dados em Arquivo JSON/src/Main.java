import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Pessoa[] pessoas = {
                new Pessoa("João", 30, "São Paulo"),
                new Pessoa("Maria", 25, "Rio de Janeiro")
        };

        salvarEmJson(pessoas);
    }

    public static void salvarEmJson(Pessoa[] pessoas) {
        String nomeArquivo = "dados.json";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (Pessoa pessoa : pessoas) {
                String json = "{"
                        + "\"nome\":\"" + pessoa.getNome() + "\","
                        + "\"idade\":" + pessoa.getIdade() + ","
                        + "\"cidade\":\"" + pessoa.getCidade() + "\""
                        + "}\n";
                writer.write(json);
            }
            System.out.println("Dados das pessoas foram salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados das pessoas: " + e.getMessage());
        }
    }

    static class Pessoa {
        private String nome;
        private int idade;
        private String cidade;

        public Pessoa(String nome, int idade, String cidade) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public String getCidade() {
            return cidade;
        }
    }
}

//public static void salvarEmJson(Pessoa[] pessoas) {
//        String nomeArquivo = "dados.json";
//
//        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
//            for (Pessoa pessoa : pessoas) {
//                JsonObject pessoaJson = Json.createObjectBuilder()
//                    .add("nome", pessoa.getNome())
//                    .add("idade", pessoa.getIdade())
//                    .add("cidade", pessoa.getCidade())
//                    .build();
//                JsonWriter jsonWriter = Json.createWriter(writer);
//                jsonWriter.writeObject(pessoaJson);
//                jsonWriter.close();
//            }
//            System.out.println("Dados das pessoas foram salvos com sucesso no arquivo: " + nomeArquivo);
//        } catch (IOException e) {
//            System.err.println("Erro ao salvar dados das pessoas: " + e.getMessage());
//        }
//    }
// Bibliotecas:
// import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonWriter;
