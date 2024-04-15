public class Main {
    public static void main(String[] args) {
        try (DAOPessoa dao = new DAOPessoa("Alunos", "root", "root")){

            Pessoa p1 = new Pessoa(1, "Leonardo", (float) 1.80, 19, "leo@email.com", "Estudante");
            dao.inserirPessoa(p1);

            Pessoa p2 = new Pessoa(2, "João", (float) 1.70, 29, "joao@email.com", "Cozinheiro");
            dao.inserirPessoa(p2);

            Pessoa p3 = new Pessoa(3, "Maria", (float) 1.60, 69, "mr@email.com", "Musicista");
            dao.inserirPessoa(p3);

            Pessoa p4 = new Pessoa(4, "Pedro", (float) 1.90, 39, "pdro@email.com", "Taxista");
            dao.inserirPessoa(p4);

            System.out.println("Lista de todas as pessoas:");
            dao.obterPessoas().forEach(System.out::println); //imprime cada pessoa

            dao.editarPessoa(1, "Leonardo Molinaro", 19, (float) 1.80, "leo@email.com", "Desenvolvedor");
            System.out.println("Edição na Pessoa:" + dao.obterUmaPessoa(1));

            dao.deletarPessoa(4);
            System.out.println("Pessoa deletada:" + dao.obterUmaPessoa(4));

            System.out.println("Lista de todas as pessoas atuais:");
            dao.obterPessoas().forEach(System.out::println); //imprime cada pessoa
        }
    }
}