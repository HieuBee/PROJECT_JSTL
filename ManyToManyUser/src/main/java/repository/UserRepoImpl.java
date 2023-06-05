package repository;

import bean.User;
import db_connect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements IUserRepo{
    private static final String SELECT_ALL_USER = "SELECT * FROM user;";
    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?;";
    private static final String INSERT_USER = "INSERT INTO user(full_name, code, birthday, create_time) values (?, ?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE user SET full_name = ?, code = ?, birthday = ?, create_time = ? where id = ?;";

    @Override
    public boolean create(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_USER);
                statement.setString(1, user.getFullName());
                statement.setString(2, user.getCode());
                statement.setString(3, user.getBirthday());
                statement.setString(4, user.getCreateTime());
                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    throw new RuntimeException(throwables);
                }
                DBConnection.close();
            }
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_USER);
                statement.setString(1, user.getFullName());
                statement.setString(2, user.getCode());
                statement.setString(3, user.getBirthday());
                statement.setString(4, user.getCreateTime());
                statement.setInt(5, user.getId());
                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    throw new RuntimeException(throwables);
                }
                DBConnection.close();
            }
        }
        return true;
    }

    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("fullName");
                    String code = resultSet.getString("code");
                    String birthday = resultSet.getString("birthday");
                    String createTime = resultSet.getString("create_time");
                    user = new User(id, name, code, birthday, createTime);
                    list.add(user);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    throw new RuntimeException(throwables);
                }
                DBConnection.close();
            }
        }

        return list;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_USER);
                statement.setInt(1, id);
                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    throw new RuntimeException(throwables);
                }
                DBConnection.close();
            }
        }
        return true;
    }
}
