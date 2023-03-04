package ma.enset.tpJavaFX.dao;

import ma.enset.tpJavaFX.dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{


    @Override
    public Product find(long id) {
        Connection connection= ConnexionDBSingleton.getConnection();
        Product product= new Product();
        try {
            PreparedStatement pr=connection.prepareStatement("select * from PRODUCTS where id=?");
            pr.setLong(1,id);
            ResultSet rs= pr.executeQuery();
            while (rs.next()){
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setReference(rs.getString("reference"));
                product.setPrix(rs.getFloat("prix"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products =new ArrayList<>();
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("select * from PRODUCTS");
            ResultSet rs= pr.executeQuery();
            while (rs.next()){
                Product product= new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setReference(rs.getString("reference"));
                product.setPrix(rs.getFloat("prix"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public void save(Product o) {
       Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("insert into PRODUCTS(name,reference,prix,ID_CAT) values(?,?,?,?)");
            pr.setString(1,o.getName());
            pr.setString(2,o.getReference());
            pr.setFloat(3,o.getPrix());
            pr.setLong(4,o.getCategory().getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Product o) {
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("delete from PRODUCTS where id=?");
            pr.setLong(1,o.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product o) {
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("Update PRODUCTS SET name=?, reference=?, prix=? where id=?");
            pr.setString(1,o.getName());
            pr.setString(2,o.getReference());
            pr.setFloat(3,o.getPrix());
            pr.setLong(4,o.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findByQuery(String query) {
        List<Product> products =new ArrayList<>();
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("select * from PRODUCTS where nom like ? or reference like ? or prix like ?");
            pr.setString(1,"%"+query+"%");
            pr.setString(2,"%"+query+"%");
            pr.setString(3,"%"+query+"%");
            ResultSet rs= pr.executeQuery();
            while (rs.next()){
                Product product= new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setReference(rs.getString("reference"));
                product.setPrix(rs.getFloat("prix"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
