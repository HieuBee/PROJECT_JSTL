package service;

import bean.Product;
import repo.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    private ProductRepoImpl repo = new ProductRepoImpl();

    @Override
    public boolean create(Product product) {
        return repo.create(product);
    }

    @Override
    public List<Product> search(String search) {
        return repo.search(search);
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }

    @Override
    public void update(Product product) {
        repo.update(product);
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id);
    }
}
