import java.io.IOException;

// Classe ExercicioThrows para demonstrar o uso de throws
public class ExercicioThrows {

    // Método umMetodo que lança IOException ou ArithmeticException
    void umMetodo(int num) throws IOException, ArithmeticException {
        if (num == 1) {
            throw new IOException("IOException");
        } else {
            throw new ArithmeticException("ArithmeticException");
        }
    }

    // Método main para testar o método umMetodo
    public static void main(String[] args) {
        try {
            ExercicioThrows obj = new ExercicioThrows();
            obj.umMetodo(1); // Chamando o método umMetodo
        } catch (IOException | ArithmeticException e) {
            System.out.println(e); // Capturando e imprimindo exceções IOException ou ArithmeticException
        }
    }
}
