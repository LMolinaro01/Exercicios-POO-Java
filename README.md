# Exercícios/Projetos de Orientação a Objeto em Java

## Exercícios:
* [Getters e Setters](#getset)
* [Criação de Classe (Livro)](#livro)
* Herança (Veículos) + Objetos Vetores
* Herança 2 (Produtos)
* Herança + Interface (Pessoa, Aluno e Professor)
* Interface (Pagamento de Funcionários)
* Agrupamento de Objetos
* [Tratamento de Exceções](#tratamentoexcecoes)

## Getters e Setters <a name="getset"></a>

``` java
public class Produtos { //Criação da Classe

    private String nome; // quando está private, só é possivel passar os atributos do objeto atrvés de parâmetros e usando o método set

    private String marca;
    private float valor;
    private int qtde;

    /*Atributos Privados: Acessíveis apenas dentro da própria classe Produtos. Isso, encapsula o estado interno da classe e evita acessos diretos externos */

    public Produtos() {
    } // Ao instanciar o objeto, será necessário usar o set para passar os atributos necessários

    public Produtos(String nome, String marca, float valor, int qtde) {
        this.nome = nome;
        this.marca = marca; // utiliza-se o this para igualar a variavel do parâmetro com a variável declarada na linha 4

        this.valor = valor;
        this.qtde = qtde;
        // Construtor que usa parâmetros ao instanciar o objeto
    }


    public void setNome(String nome) {
        this.nome = nome; // permite passar os atributos, antes era apenas por parâmetro, visto que a variável era privada.

    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setQtde(int qtde){
        if (qtde > 0){
            this.qtde = qtde; //(continuação da linha 19) Além disso, dá pra colocar condições do que pode entrar na variável (Ex: Limite de qtde)
        }

        else {
            System.out.println("Erro, quantidade inválida!");
            System.exit(0);
        }

    }

    //Método Get: é fornecido para permitir que outras classes obtenham esses valores de forma controlada. Isso é uma comum prática de encapsulamento para fornecer acesso controlado aos atributos privados.

    public String getNome() {
        return this.nome; // Retorna a variável nome, ela não é retornável ao privar a variável nome da linha 3

    }

    public String getMarca() {
        return this.marca;
    }

(...)
```

## Criação de Classe (Livro) <a name="livro"></a>

### Criando a Classe "Livro":
``` java
public class Livro {
    private int paginas;
    private int id;
    private String titulo;

    (...)

    public Livro(int paginas,int id,String titulo,String autor,String editora,String codBarra, String genero) {
        this.paginas = paginas;
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.codBarra = codBarra;
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

   (...)

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

  (...)
}
```

### Main (Uso dos Construtores)
``` java
public class Main {
    public static void main(String[] args) {

        Livro[] livro = new Livro[4];

        livro[0] = new Livro(231, 1, "Vagabond Vol. 8", "Takehiko Inoe","Panini","20032-12312", "Histórico/Samurai");
        livro[1] = new Livro(198, 2, "One Piece Vol. 106", "Eichiro Oda", "Panini", "20032-12313", "Aventura");
        livro[2] = new Livro(278, 3, "Boa noite Punpun Vol. 7", "Inio Asano", "JBC", "20003-1232", "Drama");
        livro[3] = new Livro(348, 4, "Ashita no Joe: Em busca pelo Amanhã Vol. 1", "Tetsuya Chiba e Ikki Kajiwara", "New Pop","230203-12334", "Drama/Esporte");

        System.out.println(livro[0].toString() + livro[1].toString() + livro[2].toString() + livro[3].toString());

        System.out.println("\nMelhor de Todos: " + livro[3].getTitulo());
        System.out.println("\nMelhor Autor: " + livro[1].getAutor());

    }
}
```

## Herança (Veículos) + Objetos Vetores

## Herança 2 (Produtos)

## Herança + Interface (Pessoa, Aluno e Professor)

## Interface (Pagamento de Funcionários)

## Agrupamento de Objetos

## Tratamento de Exceções <a name = "tratamentoexcecoes"> </a>

``` java
public class Main {

    public static double divide(double dividendo, double divisor) throws ArithmeticException { //throws exception (cria uma exceção do erro do tipo aritmético) {

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
    }
}

```    

   - Try: É usado para envolver o código que pode gerar uma exceção. Se uma exceção ocorrer dentro do bloco 'try', o controle do programa é transferido para o bloco 'catch' correspondente.
   
   - Catch: É usado para lidar com a exceção que foi lançada dentro do bloco 'try'. O código dentro do bloco 'catch' especifica o que fazer quando uma exceção de um tipo específico é capturada.
   
   - Finally: É usado para executar o código que precisa ser executado independentemente de ocorrer ou não uma exceção dentro do bloco 'try'. Por exemplo, é comumente usado para liberar recursos, como fechar conexões com bancos de dados ou arquivos.

   - Throw : A palavra-chave 'throw' é usada para explicitamente lançar uma exceção. Isso é útil quando você detecta um erro em seu código e deseja notificar o chamador do método sobre isso.
     
   ``` java

   try {
       // Código que pode gerar uma exceção
   } catch (TipoDeExcecao e) {
       // Tratamento da exceção
   } finally {
       // Código a ser executado independentemente de exceções
   }

   throw new TipoDeExcecao("Mensagem de erro");

   ```

 ### Diferença entre Tratamento de Exceção e Validação:

   - Tratamento de Exceção: O tratamento de exceção é usado para lidar com situações excepcionais ou inesperadas que podem ocorrer durante a execução de um programa. Por exemplo, divisão por zero, acesso a um arquivo que não existe, etc. O tratamento de exceção permite que o programa continue executando, mesmo após encontrar uma exceção.

   - Validação: A validação é usada para verificar se os dados fornecidos estão corretos ou satisfazem certas condições antes de serem processados. Por exemplo, verificar se um número está dentro de um intervalo aceitável, se uma entrada de usuário é válida, etc. A validação é uma parte normal do fluxo de controle do programa e não está relacionada a situações excepcionais. Ela ajuda a garantir a integridade dos dados e a prevenir erros antes mesmo de ocorrerem.

   Em resumo, o tratamento de exceção é usado para lidar com erros que ocorrem durante a execução do programa, enquanto a validação é usada para garantir que os dados fornecidos sejam válidos antes de serem processados. Os dois podem ser utilizados simultâneamente, e podem acabar servindo para a mesma função.



