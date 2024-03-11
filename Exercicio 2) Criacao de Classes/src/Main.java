public class Main {
    public static void main(String[] args) {

        Livro[] livro = new Livro[4];

        livro[0] = new Livro(231, 1, "Vagabond Vol. 8", "Takehiko Inoe","Panini","20032-12312", "Histórico/Samurai");
        livro[1] = new Livro(198, 2, "One Piece Vol. 106", "Eichiro Oda", "Panini", "20032-12313", "Aventura");
        livro[2] = new Livro(278, 3, "Boa noite Punpun Vol. 7", "Inio Asano", "JBC", "20003-1232", "Drama");
        livro[3] = new Livro(348, 4, "Ashita no Joe: Em busca pelo Amanhã Vol. 1", "Tetsuya Chiba e Ikki Kajiwara", "New Pop","230203-12334", "Drama/Esporte");

        System.out.println(livro[0].toString() + livro[1].toString() + livro[2].toString() + livro[3].toString());

        System.out.println("\nMelhor de Todos: " + livro[3].getTitulo());
        System.out.println("\nMelhor Autor: " + livro[1].getAutor());

    }
}