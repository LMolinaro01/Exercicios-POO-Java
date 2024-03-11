class Aluno extends Pessoa {

  private int matricula;

  public Aluno(String nome, int idade, int matricula) {
    super(nome, idade);
    this.matricula = matricula;
  }

  public int getMatricula() {
    return matricula;
  }

  @Override
  public String toString() {
    return super.toString() + "\nMatrícula: " + matricula;
  }

  @Override
  public String getInfoAdicional() {
    return "Matricula: " + matricula;
  }

  @Override
  public void apresentar(){
    System.out.println("Olá, eu sou o aluno " + getNome() + " e minha matricula é " + matricula + "!");
  }
  
}