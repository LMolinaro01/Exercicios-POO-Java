public class Produtos {

    private String nome; // quando está private, só é possivel passar os atributos do objeto atrvés de parâmetros e usando o método set

    private String marca;
    private float valor;
    private int qtde;

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

    public String getNome() {
        return this.nome; // Retorna a variável nome, ela não é retornável ao privar a variável nome da linha 3

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

    @Override
    public String toString() {

        return "\nNome do Produto: " + nome + "\n\nMarca: " + marca + "\n\nValor: " + valor + "\n\nQuantidade: " + qtde
                + "\n\n---------------------";
    }
}
