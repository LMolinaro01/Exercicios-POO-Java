public class Aviao extends Veiculo {
    private String tipo;
    private String uso;

    public Aviao(String modelo, Float velocidade, int passageiros, String combustivel, String tipo, String uso){
        super(modelo, velocidade, passageiros, combustivel);
        this.uso = uso;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\n Uso: " + uso + "\n\n Tipo: " + tipo;
    }

}
