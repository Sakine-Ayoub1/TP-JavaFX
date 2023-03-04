package ma.enset.tpJavaFX.service;

import ma.enset.tpJavaFX.dao.CategoryDao;
import ma.enset.tpJavaFX.dao.ProductDao;
import ma.enset.tpJavaFX.dao.entities.Category;
import ma.enset.tpJavaFX.dao.entities.Product;

import java.util.List;

public class CatalogueServiceImpl implements CatalogueService{

    private ProductDao productDao;
    private CategoryDao categoryDao;

    public CatalogueServiceImpl(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public void addProduct(Product p) {
       productDao.save(p);
    }

    @Override
    public void updateProduct(Product p) {
       productDao.update(p);
    }

    @Override
    public void deleteProduct(Product p) {
       productDao.delete(p);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }
}
