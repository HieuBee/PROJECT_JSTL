package service;

import bean.User;

import java.util.List;

public interface IUserService {
    boolean create(User user);
    boolean update(User user);
    List<User> findAll();
    boolean delete(int id);
}
