package repository;

import bean.User;

import java.util.List;

public interface IUserRepo {
    boolean create(User user);
    boolean update(User user);
    List<User> findAll();
    boolean delete(int id);
}
