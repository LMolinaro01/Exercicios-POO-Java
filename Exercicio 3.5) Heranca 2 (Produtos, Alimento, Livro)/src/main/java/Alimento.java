public class Alimento extends Produtos
{
  private String validade;
  private String peso;
  
  public Alimento(String nome, double preco, int quantidade, String validade, String peso) {
      super(nome, preco, quantidade);
      this.validade = validade;
      this.peso = peso;
  
    }

  public String getValidade() {
    return validade;
  }

  public String getPeso() {
    return peso;
  }

  public void setValidade(String validade) {
    this.validade = validade;
  }

  public void setPeso(String peso) {
    this.peso = peso;
  }

}