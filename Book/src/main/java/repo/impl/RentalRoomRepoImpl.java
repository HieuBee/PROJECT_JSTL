package repo.impl;

import bean.RentalRoom;
import db_connect.DBConnection;
import repo.IRentalRoomRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalRoomRepoImpl implements IRentalRoomRepo {

//    private static final String SELECT_ALL_RENTAL_ROOM = "select id, name, phone, borrow_date, give_date, payment_name, note from rental_room left join payment on rental_room.payment_id = payment.payment_id;";
    private static final String SELECT_ALL_RENTAL_ROOM = "select * from rental_room;";
    private static final String DELETE_RENTAL_ROOM = "DELETE FROM rental_room WHERE id = ?;";
    private static final String SEARCH_RENTAL_ROOM = "select * from rental_room where id = ? or name like ?;";
    private static final String CREATE_RENTAL_ROOM = "insert into rental_room(name, phone, borrow_date, payment_name, note) value (?, ?, ?, ?, ?);";

    @Override
    public boolean create(RentalRoom rentalRoom) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {

            try {
                statement = connection.prepareStatement(CREATE_RENTAL_ROOM);
                statement.setString(1, rentalRoom.getName());
                statement.setInt(2, rentalRoom.getPhone());
                statement.setString(3, rentalRoom.getBorrow_date());
                statement.setString(4, rentalRoom.getPayment());
                statement.setString(5, rentalRoom.getNote());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<RentalRoom> search(String search) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RentalRoom> list = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_RENTAL_ROOM);
                statement.setString(1, search);
                statement.setString(2, "%" + search + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idS = resultSet.getInt("id");
                    String nameS = resultSet.getString("name");
                    int phoneS = resultSet.getInt("phone");
                    String borrowDate = resultSet.getString("borrow_date");
                    String payment = resultSet.getString("payment_name");
                    String note = resultSet.getString("note");
                    list.add(new RentalRoom(idS, nameS, phoneS, borrowDate, payment, note));
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
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public List<RentalRoom> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RentalRoom> rentalRoomList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_RENTAL_ROOM);
                resultSet = statement.executeQuery();

                RentalRoom rentalRoom = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int phone = resultSet.getInt("phone");
                    String borrowDate = resultSet.getString("borrow_date");
                    String payment = resultSet.getString("payment_name");
                    String note = resultSet.getString("note");
                    rentalRoom = new RentalRoom(id, name, phone, borrowDate, payment, note);
                    rentalRoomList.add(rentalRoom);
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
        return rentalRoomList;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_RENTAL_ROOM);
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
