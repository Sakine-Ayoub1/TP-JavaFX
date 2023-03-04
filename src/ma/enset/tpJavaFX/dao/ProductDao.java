package ma.enset.tpJavaFX.dao;

import ma.enset.tpJavaFX.dao.entities.Product;

import java.util.List;

public interface ProductDao extends DAO<Product> {

    List<Product> findByQuery(String query);
}
