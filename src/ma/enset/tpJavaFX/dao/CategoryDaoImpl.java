package ma.enset.tpJavaFX.dao;

import ma.enset.tpJavaFX.dao.entities.Category;
import ma.enset.tpJavaFX.dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{

    @Override
    public Category find(long id) {
        Connection connection= ConnexionDBSingleton.getConnection();
        Category c= new Category();
        try {
            PreparedStatement pr=connection.prepareStatement("select * from CATEGORY where id=?");
            pr.setLong(1,id);
            ResultSet rs= pr.executeQuery();
            while (rs.next()){
                c.setId(rs.getLong("id"));
                c.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories =new ArrayList<>();
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("select * from CATEGORY");
            ResultSet rs= pr.executeQuery();
            while (rs.next()){
                Category category= new Category();
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

    @Override
    public void save(Category o) {
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("insert into CATEORY(name) values(?)");
            pr.setString(1,o.getName());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Category o) {
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("delete from CATEGORY where id=?");
            pr.setLong(1,o.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Category o) {
        Connection connection= ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pr= connection.prepareStatement("Update CATEGORY SET name=? where id=?");
            pr.setString(1,o.getName());
            pr.setLong(2,o.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
