import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//ao invés de utilizar a função close() pode-se utilizar o AutoClosable
//Exemplo: public class DAOPessoa implements AutoCloseable
public class DAOPessoa implements AutoCloseable{
    private final Connection conexao; //final -> apenas um artributo

    public DAOPessoa(String bancoNome, String usuario, String senha) {
        try{
            String url = "jdbc:mysql://localhost:3306/pessoa/" + bancoNome + "?createDatabaseIfNotExist=true&useSSL=false"; //url padrão de conexão com o banco (MySQL)
            conexao = DriverManager.getConnection(url,usuario, senha); // Estabelece a conexão com o banco utilizando a URL, nome de usuário e senha fornecidos
            createTabelaPessoas();
        } catch (SQLException e) { //SQLException, Erro proveniente do banco de dados
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar ao banco", e);
        }
    }

    private void createTabelaPessoas() {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas ("
                + "id INTEGER PRIMARY KEY,"
                + "nome VARCHAR(255),"
                + "idade INTEGER,"
                + ")";
        try (PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.execute();
            // Executa o comando SQL para criar a tabela
        } catch (SQLException e) {
            // Se ocorrer um erro ao executar o SQL, imprime uma mensagem de erro e lança uma exceção
            System.err.println("Erro ao criar Tabela de Pessoas: " + e.getMessage());
            throw new RuntimeException("Erro ao criar Tabela de Pessoas", e);
        }
    }

    public void inserirPessoa(Pessoa pessoa){
        String sql = "INSERT INTO pessoas (id, nome, altura, idade, email, profissao) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)){ //PreparedStatement: Forma de prevenção do SQL Injection
            // Define os valores dos parâmetros na consulta SQL
            statement.setInt(1, pessoa.getId());
            statement.setString(2, pessoa.getNome());
            statement.setFloat(3, pessoa.getIdade());
            statement.setFloat(4, pessoa.getAltura());
            statement.setString(5, pessoa.getEmail());
            statement.setString(6, pessoa.getProfissao());
            statement.execute();

        } catch (SQLException e){
            System.err.println("Erro ao inserir uma pessoa no Banco de Dados");
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir uma pessoa no Banco de Dados", e);
        }
    }

    public List<Pessoa> obterPessoas(){
        List<Pessoa> pessoas = new ArrayList<>(); // Cria uma lista para armazenar objetos (Pessoa)
        String sql = "SELECT * FROM pessoas";
        try (PreparedStatement statement = conexao.prepareStatement(sql)){
            // Executa a consulta SQL e itera sobre os resultados
            try (ResultSet result = statement.executeQuery()){
                while (result.next()){
                    // Para cada linha do resultado, cria um objeto Pessoa e adiciona à lista
                    pessoas.add(new Pessoa (result.getInt("id"),
                        result.getString("nome"),
                        result.getFloat("altura"),
                        result.getInt("idade"),
                        result.getString("email"),
                        result.getString("profissao")));
                }
            }
        } catch (SQLException e){
            System.err.println("Erro ao obter Pessoas com ID: " + e.getMessage());
            throw new RuntimeException("Erro ao obter Pessoas", e);
        }
        return pessoas; //Retorna a lista de pessoas
    }

    public Pessoa obterUmaPessoa(int id){
        String sql = "SELECT * FROM pessoas WHERE id = ?";
        try(PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1,id); // Define o ID na consulta SQL
            try (ResultSet result = statement.executeQuery()) { // Executa a consulta SQL e itera sobre os resultados
                if (!result.next()){  // Se não houver resultados, retorna null (não há pessoa com o ID fornecido)
                    return null;
                }
                return new Pessoa (result.getInt("id"), //cria e retorna um objeto Pessoa com os dados obtidos do ResultSet
                    result.getString("nome"),
                    result.getFloat("altura"),
                    result.getInt("idade"),
                    result.getString("email"),
                    result.getString("profissao"));
            }
        } catch (SQLException e){
            System.err.println("Erro ao obter Pessoa com ID: " + e.getMessage());
            throw new RuntimeException("Erro ao obter Pessoa com ID: " + id, e);
        }
    }

    public void editarPessoa(int id, String nome, int idade, float altura, String email, String profissao) {
        StringBuilder sqlBuilder = new StringBuilder("UPDATE pessoas SET "); // Cria um StringBuilder para construir a consulta SQL de atualização
        List<Object> parametros = new ArrayList<>(); // Cria uma lista para armazenar os parâmetros a serem definidos no PreparedStatement

        if (nome != null) {
            sqlBuilder.append("nome = ?"); // Adiciona o nome à consulta SQL
            parametros.add(nome); // Adiciona o nome à lista de parâmetros
        }

        if (idade != 0) {
            sqlBuilder.append("idade = ?");
            parametros.add(idade);
        }

        if (altura != 0) {
            sqlBuilder.append("altura = ?");
            parametros.add(altura);
        }

        sqlBuilder.append(" WHERE id = ?");
        parametros.add(id); // Adiciona o ID à lista de parâmetros

        try (PreparedStatement statement = conexao.prepareStatement(sqlBuilder.toString())) {
            for (int i = 0; i < parametros.size(); i++) { //Define os parâmetros o PreparedStatement
                statement.setObject(i + 1, parametros.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao alterar Pessoa com ID: " + e.getMessage());
            throw new RuntimeException("Erro ao alterar Pessoa com ID", e);
        }
    }

    public void deletarPessoa(int id){
        String sql = "DELETE FROM pessoas WHERE id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt (1,id);
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erro ao excluir Pessoa com ID: " + e.getMessage());
            throw new RuntimeException("Erro ao excluir Pessoa com ID", e);
        }
    }

    @Override
    public void close(){ // Lembrando: ao invés de utilizar a função close(), pode-se utilizar o AutoClosable direto na classe, exemplo: public class DAOPessoa implements AutoCloseable
        try{
            if (conexao != null && !conexao.isClosed()){
                conexao.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.err.println("Erro ao fechar a conexão com o Banco");
        }
    }
}
