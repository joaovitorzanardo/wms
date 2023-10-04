package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Order;

public class OrderDAO {
    
    Connection con;
    
    public OrderDAO(Connection con) {
        this.con = con;
    }
    
    public String saveOrder(Order order) {
        String msg = "Pedido excluído com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call saveOrder(?, ?, ?)");

            Integer orderId = order.getOrderId() == null ? 0 : order.getOrderId();
            
            cs.setInt(1, orderId);
            cs.setString(2, order.getDescription());
            cs.setInt(3, order.getCustomerId());

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public String deleteOrder(Integer orderId) {
        String msg = "Pedido excluído com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call deleteOrder(?)");

            cs.setInt(1, orderId);

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();

        String query = "select order_id, description, customer, address, billed, billed_date from ordersview";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setDescription(rs.getString(2));
                order.setCustomerName(rs.getString(3));
                order.setCustomerAddress(rs.getString(4));
                order.setBilled(rs.getBoolean(5));
                order.setBilledDate(rs.getDate(6));
                orders.add(order);
            }

        } catch (Exception ex) {

        }

        return orders;
    }

    public List<Order> getOrderByCustomerName(String name) {
        List<Order> orders = new ArrayList<>();

        String query = "select order_id, description, customer, address, billed, billed_date from ordersview where customer = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setDescription(rs.getString(2));
                order.setCustomerName(rs.getString(3));
                order.setCustomerAddress(rs.getString(4));
                order.setBilled(rs.getBoolean(5));
                order.setBilledDate(rs.getDate(6));
                orders.add(order); 
            }

        } catch (Exception ex) {

        }

        return orders;
    }
    
    
}
