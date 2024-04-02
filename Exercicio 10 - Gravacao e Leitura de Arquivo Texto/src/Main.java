import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileWriter escrever = null;
        try{
            escrever = new FileWriter("arquivo.txt");
            escrever.write("Meu nome é Leonardo");
        } catch (IOException e){
            System.out.println("Erro ao gerar o arquivo.txt");
            e.printStackTrace(); //imprime uma representação textual da pilha de chamadas no momento da exceção, fornecendo informações sobre onde e por que a exceção ocorreu, facilitando a depuração do código
        } finally {
            try {
                escrever.close();
            } catch (IOException e){
                System.out.println("Erro ao gerar o arquivo.txt");
                e.printStackTrace();
            }
        }

        String diretorioAtual = System.getProperty("user.dir") + System.getProperty("file.separator") + "arquivo.txt";
        ler.lerArquivo(diretorioAtual);
    }
}