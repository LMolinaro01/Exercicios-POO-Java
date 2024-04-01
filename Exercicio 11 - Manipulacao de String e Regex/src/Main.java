import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String texto = "Meu nome é Leonardo e gosto de livros";

        try {
            Pattern pattern = Pattern.compile("\\bLeonardo\\b");
            Matcher matcher = pattern.matcher(texto);

            while (matcher.find()) {
                System.out.println("Encontrou a palavra Leonardo a partir do caractere: " + matcher.start());
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Um Erro ocorreu na Manipulação de String");
        }

        String texto2 = "O e-mail do usuário é leo@email.com, seu outro e-mail é invalido@nãoexiste";

        try {
            // Expressão para validar o email
            String regexEmail = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
            // Compilar a expressao regular em um padrão
            Pattern patternEmail = Pattern.compile(regexEmail);
            // Criar um matcher para a expressao regular
            Matcher matcherEmail = patternEmail.matcher(texto2);

            // iterar sobre as correspondencias encontradas
            while (matcherEmail.find()) {
                System.out.println("E-mail encontrado: " + matcherEmail.group());
            }

        } catch (Exception e){
            System.out.println("Um Erro ocorreu na Manipulação de String (E-mail)");
            e.printStackTrace();
        }

        try {
            String regexNome = "\\bleo\\b";
            Pattern patternNome = Pattern.compile(regexNome);
            Matcher matcherNome = patternNome.matcher(texto2);

            while (matcherNome.find()) {
                System.out.println("Nome encontrado: " + matcherNome.group());
            }
        } catch (Exception e){
            System.out.println("Um Erro ocorreu na Manipulação de String (Nome)");
            e.printStackTrace();
        }
    }
}