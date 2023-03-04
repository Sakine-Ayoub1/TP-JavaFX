package ma.enset.tpJavaFX.service;

import ma.enset.tpJavaFX.dao.entities.Category;
import ma.enset.tpJavaFX.dao.entities.Product;

import java.util.List;

public interface CatalogueService {

    List<Product> getAllProducts();

    void addProduct(Product p);

    void updateProduct(Product p);

    void deleteProduct(Product p);

    List<Category> getAllCategories();

    void addCategory(Category category);

    void deleteCategory(Category category);
}
