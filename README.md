# Exercícios/Projetos de Orientação a Objeto em Java

## Projetos

* [Registro e Gerenciamento de Pacientes - Fisioterapia (Projeto Extensionista)](https://github.com/LMolinaro01/Registro-e-Gerenciamento-de-Pacientes)

## Exercícios:
* [Getters e Setters](#getset)
* [Criação de Classe (Livro)](#livro)
* [Tratamento de Exceções](#tratamentoexcecoes)
* [Manipulação de String e Regex](#regex)

## Getters e Setters <a name="getset"></a>

### Código de Exemplo
```java
public class Produtos { // Criação da Classe

    private String nome; // Atributo privado
    private String marca;
    private float valor;
    private int qtde;

    // Construtor padrão
    public Produtos() {}

    // Construtor com parâmetros
    public Produtos(String nome, String marca, float valor, int qtde) {
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
        this.qtde = qtde;
    }

    // Métodos setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setQtde(int qtde) {
        if (qtde > 0) {
            this.qtde = qtde;
        } else {
            System.out.println("Erro, quantidade inválida!");
            System.exit(0);
        }
    }

    // Métodos getters
    public String getNome() {
        return this.nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public float getValor() {
        return this.valor;
    }

    public int getQtde() {
        return this.qtde;
    }
}
```

### Explicação
Neste exercício, você irá praticar a criação de métodos getters e setters em uma classe de produtos. Os métodos getters e setters são usados para acessar e modificar os atributos privados de uma classe, encapsulando o estado interno da classe e evitando acessos diretos externos.

---

## Criação de Classe (Livro) <a name="livro"></a>

### Criando a Classe "Livro"
```java
public class Livro {
    private int paginas;
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private String codBarra;
    private String genero;

    // Construtor com parâmetros
    public Livro(int paginas, int id, String titulo, String autor, String editora, String codBarra, String genero) {
        this.paginas = paginas;
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.codBarra = codBarra;
        this.genero = genero;
    }

    // Métodos getters
    public int getPaginas() {
        return paginas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    // Métodos setters
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
```

### Main (Uso dos Construtores)
```java
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

### Explicação
Neste exercício, você irá criar uma classe que representa um livro, incluindo atributos como título, autor, número de páginas, entre outros. Você também irá praticar a criação de métodos construtores, getters e setters, e a utilização destes em uma classe principal.

---

## Tratamento de Exceções <a name="tratamentoexcecoes"></a>

### Código de Exemplo
```java
public class Main {

    public static double divide(double dividendo, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero!"); // Lança uma exceção personalizada
        }
        return dividendo / divisor;
    }

    public static void main(String[] args) {
        double resultado;

        try {
            resultado = divide(10, 0); // Divisor é zero, o que causa uma exceção
            System.out.println("Resultado da Divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Exceção Capturada: " + e.getMessage());
        }
    }
}
```

### Explicação
Neste exercício, você irá aprender sobre o tratamento de exceções em Java. Exceções são usadas para lidar com situações inesperadas que podem ocorrer durante a execução de um programa, como divisão por zero. Você irá usar blocos `try`, `catch`, e `throw` para tratar exceções de forma apropriada.

---

## Manipulação de String e Regex <a name="regex"></a>

### Código de Exemplo
```java
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
        } catch (Exception e) {
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

        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println("Um Erro ocorreu na Manipulação de String (Nome)");
            e.printStackTrace();
        }
    }
}
```

### Explicação
Neste exercício, você irá praticar a manipulação de strings e o uso de expressões regulares (regex) em Java. Você aprenderá a usar a classe `Pattern` para compilar expressões regulares e a classe `Matcher` para encontrar padrões dentro de strings. O exemplo dado mostra como encontrar palavras específicas e validar endereços de e-mail.
