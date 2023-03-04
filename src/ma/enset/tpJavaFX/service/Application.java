package ma.enset.tpJavaFX.service;

import ma.enset.tpJavaFX.dao.CategoryDaoImpl;
import ma.enset.tpJavaFX.dao.ProductDaoImpl;
import ma.enset.tpJavaFX.dao.entities.Category;
import ma.enset.tpJavaFX.dao.entities.Product;

public class Application {

    public static void main(String[] args) {
        CatalogueService catalogueService= new CatalogueServiceImpl(new ProductDaoImpl(),new CategoryDaoImpl());

        Category category= new Category();
        category.setId(1);

        Product p1= new Product();
        p1.setName("HP");
        p1.setReference("R1234");
        p1.setPrix(12000);
        p1.setCategory(category);

        catalogueService.addProduct(p1);
    }
}
