public class Livros extends Produtos{
  
  private String autor;
  private String editora;
  private int paginas;

  public Livros(String nome, double preco, int quantidade, String autor, String editora, int paginas){
    super(nome, preco, quantidade);
    this.autor = autor;
    this.editora = editora;
    this.paginas = paginas;
  }

  public String getAutor(){
    return autor;
  }

  public String getEditora(){
    return editora;
  }

  public int getPaginas(){
    return paginas;
  }

  public void setAutor(String autor){
    this.autor = autor;
  }

  public void setEditora(String editora){
    this.editora = editora;
  }

  public void setPaginas(int paginas){
    this.paginas = paginas;
  }

  
}