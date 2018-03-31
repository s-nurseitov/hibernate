package org.it.step;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "hello", urlPatterns = {"/hello/*", "/hi"})
public class HelloWorldServlet extends HttpServlet {

    private static boolean isLoaded = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select id, user, logged from it_step.users");) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLoggedAt(resultSet.getTimestamp("logged"));
                user.setLogin(resultSet.getString("user"));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }

        HttpSession session = req.getSession();
        session.setAttribute("users", users);
        resp.sendRedirect("users.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println("Hello " + userName + " from Servlet!");
        outputStream.close();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        if (!isLoaded) {
            Class.forName("org.h2.Driver");
        }
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
