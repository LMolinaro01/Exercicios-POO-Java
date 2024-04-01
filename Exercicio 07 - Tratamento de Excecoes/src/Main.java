public class Main {
    public static double divide(double dividendo, double divisor) throws ArithmeticException { //throws exception (cria uma exceção do erro do tipo aritmético)
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero!"); //criei minha própria exceção (Obs: exceção não é validação)
        }
        return dividendo / divisor;
    }

    public static void main(String[] args) {

        double resultado;

        try {
            resultado = divide(10, 0); //Divisor, Dividendo que é zero (tem que dar erro)
            System.out.println("Resultado da Divisão: " + resultado);
        }

        //Descrever a ação que ocorrerá quando ocorrer um erro 'catch (tipo_do_erro)'
        catch (ArithmeticException e) {
            System.out.println("Exceção Capturada: " + e.getMessage());
        }

        /* Tipos de Exceção:

        - Implícitas: Exceções que não precisam de tratamento e demonstram serem contornáveis
        - Explícitas: Exceções que não precisam de tratamento e demonstram serem contornáveis

         */

        /* Tipos de Classe de Exceção:

        - Não recebe argumentos e passa uma String: Mensagem de Erro Padrão
        - Recebe uma String: Mensagem de Erro Personalizada e/ou um objeto Throwable para o encadeamento de exceções
        - Recebe um objeto Throwable: Encadeamento de Exceções

        */

        /* Conceitos:

        - Throw: lança a exceção explicitamente
        - Throws: declara uma exceção
        - Finally: sempre será chamado (um código importante que sempre deverá ser executado)

         */


    }
}