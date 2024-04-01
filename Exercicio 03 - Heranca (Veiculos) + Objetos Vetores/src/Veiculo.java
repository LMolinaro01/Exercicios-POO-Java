public class Veiculo {

    private String modelo;
    private Float velocidade;
    private int passageiros;
    private String combustivel;

    public Veiculo(String modelo, Float velocidade, int passageiros, String combustivel) {
        this.modelo = modelo;
        this.velocidade = velocidade;
        this.passageiros = passageiros;
        this.combustivel = combustivel;
    }

    public String getModelo() {
        return modelo;
    }

    public Float getVelocidade() {
        return velocidade;
    }

    public int getPassageiros() {
        return passageiros;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setVelocidade(Float velocidade) {
        this.velocidade = velocidade;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setPassageiros(int passageiros) {
        this.passageiros = passageiros;
    }

    @Override
    public String toString() {
        return "\n\n\n Modelo: " + modelo + "\n\n Velocidade: " + velocidade + " \n\n Combustível: "
                + combustivel + " \n\n Passageiros: " + passageiros;
    }
}
