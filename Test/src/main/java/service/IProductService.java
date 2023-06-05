package service;

import bean.Product;

import java.util.List;

public interface IProductService {
    boolean create(Product product);
    List<Product> search(String search);
    List<Product> findAll();
    boolean delete(int id);
    void update(Product product);
    Product findById(int id);
}

