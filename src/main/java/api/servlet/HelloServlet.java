package api.servlet;

import api.entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = new User();
        user.setMemberId(1);
        user.setMemberName("Up1");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        User sendUser = mapper.readValue(req.getInputStream(), User.class);

        User user = new User();
        user.setMemberId(0000);
        user.setMemberName("Response from POST form " + sendUser.getMemberName());

        mapper.writeValue(response.getOutputStream(), user);

    }

}

