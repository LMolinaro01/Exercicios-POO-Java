class Pessoa implements Apresentavel {

  private String nome;

  private int idade;

  public Pessoa() {
  }

  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public String toString() {
    return "Nome: " + nome + "\nIdade: " + idade;

  }

  // Método polimórfico de sobreposição
  public String getInfoAdicional() {
    return "N/A"; // Implementação padrão
  }
  /*
  @Override
  public String toString() {
    return "Nome: " + nome + "\nIdade: " + idade + "\nInformação Adicional: " + getInfoAdicional();
  } */

  //Método sobrecarregado para apresentação Básica
  public void apresentar(){
    System.out.println("Olá, eu sou " + nome +  "!");
  }
  //Método sobrecarregado para apresentação completa
  public void apresentar(int idade){
    System.out.println("Olá, eu sou " + nome + " e tenho " + idade + " anos!");
  }
}