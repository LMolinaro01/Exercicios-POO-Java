import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileWriter escrever = null;
        try{
            escrever = new FileWriter("arquivo.txt");
            escrever.write("Meu nome é Leonardo");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                escrever.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        String diretorioAtual = System.getProperty("user.dir") + System.getProperty("file.separator") + "arquivo.txt";
        ler.lerArquivo(diretorioAtual);
    }
}