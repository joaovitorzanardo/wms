package dao;

import java.sql.CallableStatement;
import java.sql.Connection;

public class WarehouseDAO {

    private Connection con;

    public WarehouseDAO(Connection con) {
        this.con = con;
    }

    public String ajustaEstoque(String barCode, Integer quantity) {
        String msg = "Estoque ajustado com sucesso!";

        try {
            CallableStatement cs = con.prepareCall("call ajustarEstoque(?, ?)");

            cs.setString(1, barCode);
            cs.setInt(2, quantity);

            cs.execute();

        } catch (Exception ex) {
            msg = ex.getMessage();
        }

        return msg;
    }

}
