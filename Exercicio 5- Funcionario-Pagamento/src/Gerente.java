class Gerente extends Funcionario {
    private double salarioMensal;

    public Gerente(String nome, int idade, double salarioMensal) {
        super(nome, idade);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularSalario() {
        return salarioMensal;
    }
}