public class Main {
  public static void main(String[] args) {
    
    Produtos produto1 = new Produtos("Caderno", 10.00, 10);

    Alimento a1 = new Alimento("Arroz", 16.00, 10, "20/10/2024", "1kg");

    Livros l1 = new Livros("Senhor dos Aneis: A duas Torres", 49.90, 1, "Tolkien", "Editora Veneta", 300);

    System.out.println(produto1.toString());
    
  }

 
}