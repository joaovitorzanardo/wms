package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDAO {
    
    Connection con;
    
    public CustomerDAO(Connection con) {
        this.con = con;
    }
    
    public String saveCustomer(Customer customer) {
        String msg = "Cliente salvo com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call saveCustomer(?, ?, ?, ?, ?, ?, ?)");

            Integer customerId = customer.getAddressId() == null ? 0 : customer.getAddressId();
            
            cs.setInt(1, customerId);
            cs.setString(2, customer.getFirstName());
            cs.setString(3, customer.getLastName());
            cs.setString(4, customer.getEmail());
            cs.setString(5, customer.getCpf());
            cs.setString(6, customer.getPhoneNumber());
            cs.setInt(7, customer.getAddressId());

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public String deleteCustomer(Integer customerId) {
        String msg = "Cliente excluído com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call deleteCustomer(?)");

            cs.setInt(1, customerId);

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        String query = "select customer_id, first_name, last_name, email, cpf, phone_number, address from customers";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setCpf(rs.getString(5));
                customer.setPhoneNumber(rs.getString(6));
                customer.setFullAddress(rs.getString(7));
                customers.add(customer);
            }

        } catch (Exception ex) {

        }

        return customers;
    }

    public List<Customer> getCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();

        String query = "select customer_id, first_name, last_name, email, cpf, phone_number, address from customers where first_name like %?%";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setCpf(rs.getString(5));
                customer.setPhoneNumber(rs.getString(6));
                customer.setFullAddress(rs.getString(7));
                customers.add(customer);
            }

        } catch (Exception ex) {

        }

        return customers;
    }
    
    public Customer getCustomerByEmail(String email) {
        Customer customer = new Customer();
        String query = "select customer_id, first_name, last_name, email, cpf, phone_number, address from customers where email = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customer.setCustomerId(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setCpf(rs.getString(5));
                customer.setPhoneNumber(rs.getString(6));
                customer.setFullAddress(rs.getString(7));
            }

        } catch (Exception ex) {

        }

        return customer;
    }
    
    public Customer getCustomerByCPF(String cpf) {
        Customer customer = new Customer();
        String query = "select customer_id, first_name, last_name, email, cpf, phone_number, address from customers where cpf = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cpf);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customer.setCustomerId(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setCpf(rs.getString(5));
                customer.setPhoneNumber(rs.getString(6));
                customer.setFullAddress(rs.getString(7));                
            }

        } catch (Exception ex) {

        }

        return customer;
    }
    
}
