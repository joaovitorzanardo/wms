package dao;

import java.sql.CallableStatement;
import model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {

    private Connection con;

    public AddressDAO(Connection con) {
        this.con = con;
    }

    public String saveAddress(Address address) {
        String msg = "Produto salvo com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call saveAddress(?, ?, ?, ?, ?, ?, ?)");
            
            Integer addresId = address.getAddressId() == null ? 0 : address.getAddressId();

            cs.setInt(1, addresId);
            cs.setString(2, address.getCep());
            cs.setString(3, address.getCity());
            cs.setString(4, address.getUf());
            cs.setString(5, address.getStreet());
            cs.setString(6, address.getDistrict());
            cs.setInt(7, address.getNumber());

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public String deleteAddress(Integer addressId) {
        String msg = "Endereço excluído com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call deleteAddress(?)");

            cs.setInt(1, addressId);
            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public List<Address> getAllAdresses() {
        List<Address> addresses = new ArrayList<>();

        String query = "select address_id, cep, city, uf, street, district, number from address";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setAddressId(rs.getInt(1));
                address.setCep(rs.getString(2));
                address.setCity(rs.getString(3));
                address.setUf(rs.getString(4));
                address.setStreet(rs.getString(5));
                address.setDistrict(rs.getString(6));
                address.setNumber(rs.getInt(7));
                addresses.add(address);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return addresses;
    }

    public List<Address> getAdressesByCity(String city) {
        List<Address> addresses = new ArrayList<>();

        String query = "select address_id, cep, city, uf, street, district, number from address where city = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, city);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setAddressId(rs.getInt(1));
                address.setCep(rs.getString(2));
                address.setCity(rs.getString(3));
                address.setUf(rs.getString(4));
                address.setStreet(rs.getString(5));
                address.setDistrict(rs.getString(6));
                address.setNumber(rs.getInt(7));
                addresses.add(address);
            }

        } catch (Exception ex) {

        }

        return addresses;
    }

}
