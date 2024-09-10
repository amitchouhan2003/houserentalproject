/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LoginAregistration;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class MyLoginServlet extends HttpServlet {
    private Connection conn=null;
    private PreparedStatement ps=null;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userapp1";
            String username = "root";
            String password = "Anshu@1234";

            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("SELECT name FROM USERS WHERE userid=? AND password=?");
            System.out.println("Connected successfully to the db");
        } catch (Exception ex) {
            System.out.println("Exception in init: " + ex);
            throw new ServletException("Initialization failed: " + ex.getMessage(), ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter pw = response.getWriter()) {
            String userid = request.getParameter("userId");
            String pass = request.getParameter("userpwd");

            if (userid == null || pass == null) {
                pw.println("<html>");
                pw.println("<head>");
                pw.println("<title>Login</title>");
                pw.println("</head>");
                pw.println("<body>");
                pw.println("<p>Invalid input: User ID and Password are required.</p>");
                pw.println("<a href='login.html'>Try Again</a>");
                pw.println("</body>");
                pw.println("</html>");
                return;
            }

            ps.setString(1, userid);
            ps.setString(2, pass);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                String username = result.getString("name");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                request.setAttribute("username", username);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                   RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                   dispatcher.forward(request, response);
            } else {
                pw.println("<html>");
                pw.println("<head>");
                pw.println("<title>Login</title>");
                pw.println("</head>");
                pw.println("<body>");
                pw.println("<p>Sorry, wrong input</p>");
                pw.println("<a href='login.html'>Try Again</a>");
                pw.println("</body>");
                pw.println("</html>");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            throw new ServletException("Database error: " + ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            throw new ServletException("Error processing request: " + ex.getMessage(), ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

