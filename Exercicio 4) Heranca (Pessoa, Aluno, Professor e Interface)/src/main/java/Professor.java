class Professor extends Pessoa {

  private String disciplina;

  public Professor(String nome, int idade, String disciplina) {
    super(nome, idade);
    this.disciplina = disciplina;
  }

  public String getDisciplina() {
    return disciplina;
  }

  @Override
  public String toString() {
    return super.toString() + "\nDisciplina: " + disciplina;
  }

  @Override
  public String getInfoAdicional() {
    return "Disciplina: " + disciplina;
  }

  @Override
  public void apresentar(){
    System.out.println("Olá, eu sou o professor " + getNome() + " e leciono a disciplina de " + disciplina + "!");
  }

}