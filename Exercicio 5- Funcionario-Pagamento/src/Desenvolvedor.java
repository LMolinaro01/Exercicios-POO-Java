class Desenvolvedor extends Funcionario {
    private int horasTrabalhadas;
    private double salarioHora;

    public Desenvolvedor(String nome, int idade, int horasTrabalhadas, double salarioHora) {
        super(nome, idade);
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    }

    public int getHorasTrabalhadas(){
        return horasTrabalhadas;
    }

    public double getSalarioHora(){
        return salarioHora;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas){
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void setSalarioHora(double salarioHora){
        this.salarioHora = salarioHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * salarioHora;
    }
}