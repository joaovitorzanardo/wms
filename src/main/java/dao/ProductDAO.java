package dao;

import java.sql.CallableStatement;
import model.Brand;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection con;

    public ProductDAO(Connection con) {
        this.con = con;
    }

    public String saveProduct(Product product) {
        String msg = "Produto salvo com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call saveProduct(?, ?, ?, ?, ?)");

            Integer productId = product.getProductId() == null ? 0 : product.getProductId();
            
            cs.setInt(1, productId);
            cs.setString(2, product.getBarCode());
            cs.setString(3, product.getName());
            cs.setString(4, product.getBrand().getName());
            cs.setDouble(5, product.getPrice());

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public String deleteProduct(Integer productId) {
        String msg = "Produto excluído com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call deleteProduct(?)");

            cs.setInt(1, productId);

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        String query = "select product_id, bar_code, name, brand, price, quantity from products";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setBarCode(rs.getString(2));
                product.setName(rs.getString(3));
                Brand brand = new Brand();
                brand.setName(rs.getString(4));
                product.setBrand(brand);
                product.setPrice(rs.getDouble(5));
                product.setQuantity(rs.getInt(6));
                products.add(product);
            }

        } catch (Exception ex) {

        }

        return products;
    }

    public Product getProductByBarCode(String barCode) {
        Product product = new Product();

        String query = "select * from products where bar_code = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, barCode);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                product.setProductId(rs.getInt(1));
                product.setBarCode(rs.getString(2));
                product.setName(rs.getString(3));
                Brand brand = new Brand();
                brand.setName(rs.getString(4));
                product.setBrand(brand);
                product.setPrice(rs.getDouble(5));
                product.setQuantity(rs.getInt(6));
            }

        } catch (Exception ex) {

        }

        return product;
    }
    
    public List<Product> getProductsByName(String name) {
        List<Product> products = new ArrayList();

        String query = "select * from getProductByNameLike(?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setBarCode(rs.getString(2));
                product.setName(rs.getString(3));
                Brand brand = new Brand();
                brand.setName(rs.getString(4));
                product.setBrand(brand);
                product.setPrice(rs.getDouble(5));
                product.setQuantity(rs.getInt(6));
                products.add(product);
            }

        } catch (Exception ex) {

        }
        return products;
    }
    
    
    public List<Product> getProductsByBrandName(String brandName) {
        List<Product> products = new ArrayList();

        String query = "select * from products where brand = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, brandName);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setBarCode(rs.getString(2));
                product.setName(rs.getString(3));
                Brand brand = new Brand();
                brand.setName(rs.getString(4));
                product.setBrand(brand);
                product.setPrice(rs.getDouble(5));
                product.setQuantity(rs.getInt(6));
                products.add(product);
            }

        } catch (Exception ex) {

        }
        return products;
    }
    
    public boolean productExists(String barCode) {
        boolean exists = false;
        
        String query = "select product_id from product where bar_code = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, barCode);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Integer productId = rs.getInt(1);
                if (productId != null) {
                    exists = true;
                }
            }

        } catch (Exception ex) {

        }
        
        return exists;
    }

}
