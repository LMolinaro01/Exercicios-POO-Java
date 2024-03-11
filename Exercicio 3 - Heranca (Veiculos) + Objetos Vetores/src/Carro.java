public class Carro extends Veiculo {
    private int ano;
    private String portas;

    public Carro(String modelo, Float velocidade, int passageiros, String combustivel, int ano, String portas){
        super(modelo, velocidade, passageiros, combustivel);
        this.ano = ano;
        this.portas = portas;
    }

    public int getAno() {
        return ano;
    }

    public String getPortas() {
        return portas;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }

    // Sobrescrevendo o método toString() para adicionar informações específicas do Carro
    @Override
    public String toString() {
        // Chama o toString() da superclasse Veiculo e adiciona informações adicionais do Carro
        return super.toString() + "\n\n Ano: " + ano + "\n\n Portas: " + portas;
    }

}
