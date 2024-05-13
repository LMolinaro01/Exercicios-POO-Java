import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioDAO {

    private static final String DATABASE_FILE = "usuarios.db";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT)";
    private static final String INSERT_USUARIO_SQL = "INSERT INTO usuarios (nome, email) VALUES (?,?)";
    private static final String SELECT_ALL_USUARIOS_SQL = "SELECT * FROM usuarios";
    private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";
    private static final String DELETE_USUARIO_SQL = "DELETE FROM usuarios WHERE id = ?";

    public static void criarTabela() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_TABLE_SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarUsuario(Usuario usuario){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite" + DATABASE_FILE);
             PreparedStatement statement = connection.prepareStatement(INSERT_USUARIO_SQL)){
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void atualizarUsuario(Usuario usuario){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite" + DATABASE_FILE);
             PreparedStatement statement = connection.prepareStatement(UPDATE_USUARIO_SQL)){
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, usuario.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite" + DATABASE_FILE);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_USUARIOS_SQL)){
            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public static void excluirUsuario(int id){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite" + DATABASE_FILE);
             PreparedStatement statement = connection.prepareStatement(DELETE_USUARIO_SQL)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
