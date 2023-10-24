package by.arsy.p3dao;

import by.arsy.p1util.ConnectorManager;
import by.arsy.p2entity.User;
import by.arsy.p7coder.HashCoder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public final class UserDao {

    private static final String CHECK_USER_SQL = """
            SELECT *
            FROM console_user
            WHERE user_name = ? AND hash_pass = ?
            """;

    private static final String CHECK_NAME_SQL = """
            SELECT id
            FROM console_user
            WHERE user_name = ?
            """;

    private static final String REGISTRATION_NEW_USER_SQL = """
            INSERT INTO console_user (user_name, hash_pass,  master) VALUES (?, ?, ?);
            """;

    private static final String CHANGE_PASSWORD_SQL = """
            UPDATE console_user
            SET hash_pass = ?
            WHERE user_name = ?
            """;

    private static final String FIND_NAMES_CAN_DELETE_USERS_SQL = """
            SELECT user_name
            FROM console_user
            WHERE user_name NOT IN ('master', ?);
            """;

    private static final String DELETE_USERS_BY_NAME_SQL = """
            DELETE FROM console_user
            WHERE user_name = ?;
            """;


    public Optional<User> findUser(String name, String pass) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatementUser = connection.prepareStatement(CHECK_USER_SQL)) {

            preparedStatementUser.setString(1, name);
            preparedStatementUser.setInt(2, HashCoder.getHash(pass));

            ResultSet resultSetUser = preparedStatementUser.executeQuery();

            return buildUser(resultSetUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public boolean findName(String name) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatementName = connection.prepareStatement(CHECK_NAME_SQL)) {

            preparedStatementName.setString(1, name);

            ResultSet resultSetName = preparedStatementName.executeQuery();

            return resultSetName.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public int getIdByName(String name) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatementName = connection.prepareStatement(CHECK_NAME_SQL)) {


            preparedStatementName.setString(1, name);

            ResultSet resultSetName = preparedStatementName.executeQuery();
            if (resultSetName.next()) {
                return resultSetName.getInt(1);
            }

            return 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public void registration(String name, String password, boolean master) {

        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REGISTRATION_NEW_USER_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, HashCoder.getHash(password));
            preparedStatement.setBoolean(3, master);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePass(String name, int hashNewPass) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_PASSWORD_SQL)) {
            preparedStatement.setInt(1, hashNewPass);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> findNamesCanDeleteUsers(String userName) {
        ArrayList<String> canDeleteUsersNames = new ArrayList<>();
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_NAMES_CAN_DELETE_USERS_SQL)) {

            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                canDeleteUsersNames.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canDeleteUsersNames;
    }

    public void deleteUserByName(String name) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_BY_NAME_SQL)) {

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Optional<User> buildUser(ResultSet result) throws SQLException {
        Optional<User> user = Optional.empty();

        if (result.next()) {
            user = Optional.of(new User(
                    result.getInt(1),
                    result.getString(2),
                    result.getBoolean(4)));
        }
        return user;
    }
}
