public class Designer extends Funcionario {

    private int servicos;

    Designer(String nome, int idade, int servicos) {
        super(nome, idade);
        this.servicos = servicos;
    }

    public int getServicos() {
        return servicos;
    }

    public void setServicos() {
        this.servicos = servicos;
    }

    @Override
    public double calcularSalario() {
        return servicos * 350;
    }


}
