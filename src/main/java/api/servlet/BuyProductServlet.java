package api.servlet;

import java.io.IOException;
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
        user.setMemberName("Nat...");
        user.setMemberWallet(1500);

        Receipt receipt = new Receipt();
        receipt.setReceiptId(1);
        receipt.setMemberId(1);
        receipt.setTotal(55);
        receipt.setFee(1);
        receipt.setShopName("Coffe Prince");

        Date date = new Date();
        receipt.setDateTime(date);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), receipt);

    }
}