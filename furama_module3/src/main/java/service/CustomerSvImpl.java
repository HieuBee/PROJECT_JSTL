package service;

import model.Customer;
import repository.CustomerRepoImpl;
import service.impl.ICustomerSv;

import java.util.List;

public class CustomerSvImpl implements ICustomerSv {
    private CustomerRepoImpl customerRepo = new CustomerRepoImpl();

    @Override
    public boolean create(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public boolean delete(int id) {
        return customerRepo.delete(id);
    }
}
