package users;

import cadastro.dataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuarios usuarios) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuarios.getNome());
            stmt.setString(2, usuarios.getEmail());
            stmt.setString(3, usuarios.getPassword());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuário cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuarios> listarUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public void apagarUsuario(int id) {
        String sqlDelete = "DELETE FROM users WHERE id = ?";
        String sqlSelect = "SELECT id FROM users";
        String sqlUpdate = "UPDATE users SET id = ? WHERE id = ?";

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete);
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {

            // Excluir o usuário pelo ID fornecido
            stmtDelete.setInt(1, id);
            int rowsDeleted = stmtDelete.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Usuário com ID " + id + " excluído com sucesso.");

                // Selecionar todos os IDs restantes na tabela após a exclusão
                ResultSet rs = stmtSelect.executeQuery();
                int novoId = 1;

                while (rs.next()) {
                    int idAtual = rs.getInt("id");
                    stmtUpdate.setInt(1, novoId);
                    stmtUpdate.setInt(2, idAtual);
                    stmtUpdate.executeUpdate();
                    novoId++;
                }

                System.out.println("IDs reordenados após exclusão.");
            } else {
                System.out.println("Nenhum usuário encontrado com ID " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void atualizarCadastro(int id, String novoNome, String novoEmail, String novaSenha) {
        String sqlUpdate = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        String sqlSelect = "SELECT name, email, password FROM users WHERE id = ?";

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement stmtUpdate = connection.prepareStatement(sqlUpdate);
             PreparedStatement stmtSelect = connection.prepareStatement(sqlSelect)) {

            stmtSelect.setInt(1, id);
            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                String nomeAtual = rs.getString("name");
                String emailAtual = rs.getString("email");
                String senhaAtual = rs.getString("password");

                // Define os novos valores ou mantém os atuais conforme escolha do usuário
                String nomeFinal = (novoNome.isEmpty()) ? nomeAtual : novoNome;
                String emailFinal = (novoEmail.isEmpty()) ? emailAtual : novoEmail;
                String senhaFinal = (novaSenha.isEmpty()) ? senhaAtual : novaSenha;

                // Atualiza o usuário no banco de dados
                stmtUpdate.setString(1, nomeFinal);
                stmtUpdate.setString(2, emailFinal);
                stmtUpdate.setString(3, senhaFinal);
                stmtUpdate.setInt(4, id);

                int rowsUpdated = stmtUpdate.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Usuário com ID " + id + " atualizado com sucesso.");
                } else {
                    System.out.println("Nenhum usuário encontrado com ID " + id);
                }
            } else {
                System.out.println("Nenhum usuário encontrado com ID " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
