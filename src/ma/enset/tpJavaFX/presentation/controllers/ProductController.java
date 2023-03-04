package ma.enset.tpJavaFX.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ma.enset.tpJavaFX.dao.CategoryDaoImpl;
import ma.enset.tpJavaFX.dao.ProductDaoImpl;
import ma.enset.tpJavaFX.dao.entities.Category;
import ma.enset.tpJavaFX.dao.entities.Product;
import ma.enset.tpJavaFX.service.CatalogueService;
import ma.enset.tpJavaFX.service.CatalogueServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextField textRef;
    @FXML
    private TextField textPrix;
    @FXML
    private ComboBox<Category> comboCategory;
    @FXML
    private ListView<Product> listViewProd;

    private CatalogueService catalogueService;

    ObservableList<Product> data= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewProd.setItems(data);
       catalogueService= new CatalogueServiceImpl(new ProductDaoImpl(),new CategoryDaoImpl());
       comboCategory.getItems().addAll(catalogueService.getAllCategories());
       loadData();
    }

    private void loadData(){
        data.clear();
        List<Product> products = catalogueService.getAllProducts();
        data.addAll(products);
    }

    public void addProduct(){
       Product p = new Product();
       p.setName(textNom.getText());
       p.setReference(textRef.getText());
       p.setPrix(Float.parseFloat(textPrix.getText()));
       p.setCategory(comboCategory.getSelectionModel().getSelectedItem());
       catalogueService.addProduct(p);
       loadData();
    }

}
