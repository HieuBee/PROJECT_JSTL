package service.impl;

import model.Customer;

import java.util.List;

public interface ICustomerSv {
    boolean create(Customer customer);
    boolean update(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
    boolean delete(int id);
}
