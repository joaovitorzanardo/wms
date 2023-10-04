package dao;

import java.sql.CallableStatement;
import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {

    private Connection con;

    public BrandDAO(Connection con) {
        this.con = con;
    }

    public String saveBrand(Brand brand) {
        String msg = "Marca salva com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call saveBrand(?, ?)");

            Integer brandId = brand.getBrandId() == null ? 0 : brand.getBrandId();
            
            cs.setInt(1, brandId);
            cs.setString(2, brand.getName());

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public String deleteBrand(Integer brandId) {
        String msg = "";

        try {
            CallableStatement cs = con.prepareCall("call deleteBrand(?)");

            cs.setInt(1, brandId);

            cs.execute();

        } catch (Exception ex) {
            msg = "Marca excluída com sucesso!";
        }

        return msg;
    }

    public List<Brand> getAllBrands() {
        List<Brand> brands = new ArrayList<>();

        String query = "select brand_id, name from brand";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Brand brand = new Brand(rs.getInt(1), rs.getString(2));
                brands.add(brand);
            }

        } catch (Exception ex) {

        }

        return brands;
    }

}
