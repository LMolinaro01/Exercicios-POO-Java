//Não pode ser instanciada, apenas herdada (abstract)
abstract class Funcionario implements Pagamento {

    private String nome;
    private int idade;

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade;
    }

    public double calcularSalario() {
        return 0;
    }

}