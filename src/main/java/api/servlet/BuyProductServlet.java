package api.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

import api.entity.User;
import api.entity.Receipt;

@WebServlet("/buyProduct")
public class BuyProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = new User();
        user.setMemberId(1);
        user.setMemberName("Rosena");
        user.setMemberWallet(1500);

        Receipt receipt = new Receipt();
        receipt.setReceiptId(1);
        receipt.setMemberId(1);
        receipt.setTotal(55);
        receipt.setShopName("CoffePrince");

        Connection conn = null;
		Statement stmt = null;
        ResultSet rs = null;
		try {
            // new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			String connectionUrl = "jdbc:mysql://localhost:3306/mfuwallet";
			String connectionUser = "root";
			String connectionPassword = "root";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO receipt (receipt_id, member_id, date_time, total, shop_name) VALUES ( "+receipt.getReceiptId()+", "+receipt.getMemberId()+", 21-1-2561, "+receipt.getTotal()+", "+receipt.getShopName()+");");
        }catch (Exception e) {
			e.printStackTrace();
		} 
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), receipt);

    }
}