import java.sql.*;

public class Model {
    private Connection connection;
    private Statement statement;

    public Model() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:pessoas.db");
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean adicionarPessoa(Pessoa pessoa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pessoas (nome, email) VALUES (?, ?)");
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getEmail());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
