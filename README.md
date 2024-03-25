# Exercícios/Projetos de Orientação a Objeto em Java

## Exercícios:
* [Getters e Setters](#getset)
* [Criação de Classe (Livro)](#livro)
* Herança (Veículos) + Objetos Vetores
* Herança 2 (Produtos)
* Herança + Interface (Pessoa, Aluno e Professor)
* Interface (Pagamento de Funcionários)
* Agrupamento de Objetos

## Getters e Setters <a name="getset"></a>

```
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
```
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
```
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




