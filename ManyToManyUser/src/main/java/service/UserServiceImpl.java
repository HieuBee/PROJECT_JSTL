package service;

import bean.User;
import repository.UserRepoImpl;

import java.util.List;

public class UserServiceImpl implements IUserService{
    private UserRepoImpl repo = new UserRepoImpl();
    @Override
    public boolean create(User user) {
        return repo.create(user);
    }

    @Override
    public boolean update(User user) {
        return repo.update(user);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }
}
