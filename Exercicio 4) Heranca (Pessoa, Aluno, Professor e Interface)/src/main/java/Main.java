public class Main {
  public static void main(String[] args) {

    Pessoa p1 = new Pessoa("Leonardo", 19);
    System.out.println(p1.toString());
    Pessoa pessoa = new Pessoa();
    pessoa.setNome("Jorge");
    pessoa.setIdade(29);

    System.out.println("Nome: " + pessoa.getNome());
    System.out.println("Idade: " + pessoa.getIdade());

    Aluno aluno = new Aluno("Fabio", 29, 123456);
    Professor professor = new Professor("Raphael", 39, "Programação Orientada a Objetos");

    System.out.println("\nInformações do Aluno: \n" + aluno.toString() + "\n");
    System.out.println("Informações do Professor: \n" + professor.toString() + "\n");

    Aluno[] alunos = new Aluno[2];
    alunos[0] = new Aluno("Leo", 21, 1232456);
    alunos[1] = new Aluno("Anderson", 23, 1232457);

    for (Aluno alunoAtual : alunos) {
      System.out.println(alunoAtual.toString());
    }

    Professor[] professores = new Professor[3];
    professores[0] = new Professor("Maria", 35, "Programação em Python");
    professores[1] = new Professor("José", 40, "Programação em Java");
    professores[2] = new Professor("Pedro", 45, "Programação em C++");

    for (Professor professorAtual : professores) {
      System.out.println(professorAtual.toString());
    }

    p1.apresentar();

    pessoa.apresentar(pessoa.getIdade());
    
    Pessoa aluno2 = new Aluno("Ana", 18, 12345);
    Pessoa professor2 = new Professor("Raphael", 39, "Programação Orientada a Objetos");
    
    System.out.println("Informações da Pessoa 1: \n" + aluno2.toString() + "\n");
    System.out.println("Informações da Pessoa 2: \n" + professor2.toString());
    
    aluno2.apresentar();
    professor2.apresentar(professor2.getIdade());
    professor2.apresentar();
    
  }

}