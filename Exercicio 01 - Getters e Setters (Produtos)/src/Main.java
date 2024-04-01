public class Main {

    public static void main(String[] args) {
        // ------------------------------------------------------
        Produtos p1 = new Produtos("Caneta", "Bic", 1.5f, 10);

        System.out.println(p1.toString());

        // ------------------------------------------------------
        Produtos p2 = new Produtos();

        p2.setNome("Lápis");
        p2.setMarca("Faber Castell");
        p2.setValor(0.5f);
        p2.setQtde(0);

        System.out.println(p2.toString());

        // ------------------------------------------------------
        Produtos p3 = new Produtos("Camisa", "Renner", 50.0f, 34);

        System.out.println(p3.toString());

        System.out.println("\nNome do Produto: " + p3.getNome());

    }

}