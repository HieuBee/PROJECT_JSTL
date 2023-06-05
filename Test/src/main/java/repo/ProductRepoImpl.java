package repo;

import bean.Product;
import database.DBConnecttion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements IProductRepo{
    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String CREATE_PRODUCT = "insert into product(name, price, quantity, color, description, categories) value (?, ?, ?, ?, ?, ?);";
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?;";
    private static final String UPDATE_PRODUCT = "UPDATE product SET name = ?, price = ?, quantity = ?, color = ?, description = ?, categories = ? WHERE id = ?";
    private static final String FIND_BY_ID = "select * from product where id=?;";
    private static final String SEARCH_PRODUCT = "select * from product where name like ?;";

    @Override
    public boolean create(Product product) {
        Connection connection = DBConnecttion.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {

            try {
                statement = connection.prepareStatement(CREATE_PRODUCT);
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getQuantity());
                statement.setString(4, product.getColor());
                statement.setString(5, product.getDescription());
                statement.setString(6, product.getCategories());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnecttion.close();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Product> search(String search) {
        Connection connection = DBConnecttion.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_PRODUCT);
                statement.setString(1, "%" + search + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description");
                    String categories = resultSet.getString("categories");
                    products.add(new Product(id, name, price, quantity, color, description, categories));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnecttion.close();
            }
        }
        return products;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = DBConnecttion.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = statement.executeQuery();

                Product product = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description");
                    String categories = resultSet.getString("categories");
                    product = new Product(id, name, price, quantity, color, description, categories);
                    products.add(product);
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
                DBConnecttion.close();
            }
        }
        return products;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DBConnecttion.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_PRODUCT);
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
                DBConnecttion.close();
            }
        }
        return true;
    }

    @Override
    public void update(Product product) {
        Connection connection = DBConnecttion.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_PRODUCT);
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getQuantity());
                statement.setString(4, product.getColor());
                statement.setString(5, product.getDescription());
                statement.setString(6, product.getCategories());
                statement.setInt(7, product.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnecttion.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Connection connection = DBConnecttion.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int ids = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description");
                    String categories = resultSet.getString("categories");
                    product = new Product(ids, name, price, quantity, color, description, categories);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnecttion.close();
            }
        }
        return product;
    }
}
