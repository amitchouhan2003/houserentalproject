/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Searchanddisplay;

//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author krishtiwari
// */
//public class Searchhouse extends HttpServlet {
//     private Connection conn;
//    private PreparedStatement ps;
//
//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/userapp1";
//            String username = "root";
//            String password = "Anshu@1234";
//            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Connected successfully to the db");
//            ps = conn.prepareStatement("SELECT owner_name, contact,price,location,state FROM housedetails WHERE location=? and state=?");
//        } catch (Exception ex) {
//            System.out.println("Exception in init: " + ex);
//            throw new ServletException(ex.getMessage());
//        }
//    }
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     * @throws java.sql.SQLException
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            String location = request.getParameter("location");
//            String state =request.getParameter("state");
//            ps.setString(1,location);
//            ps.setString(2,state);
//
//            ResultSet result = ps.executeQuery();
//            List<House> houseNames = new ArrayList<>();
//
//            while (result.next()) {
//                String ownername = result.getString("owner_name");
//                String contact = result.getString("contact");
//                Double price = result.getDouble("price");
//                String loc = result.getString("location");
//                String st = result.getString("state");
//                House hse = new House(ownername,contact,price,loc,st);
//                houseNames.add(hse);
//            }
//
//            if (houseNames.isEmpty()) {
//                out.println("<p>Sorry, there are no available books for this subject.</p>");
//                out.println("<a href='search.html'>Try Again</a>");
//            } else {
//                request.setAttribute("housename",houseNames );
//                RequestDispatcher dispatcher = request.getRequestDispatcher("displayhouse");
//                dispatcher.forward(request, response);
//            }
//           
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}

//MAIN
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Searchhouse extends HttpServlet {
//    private Connection conn;
//    private PreparedStatement ps;
//
//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/userapp1";
//            String username = "root";
//            String password = "Anshu@1234";
//            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Connected successfully to the db");
//            ps = conn.prepareStatement("SELECT owner_name, contact, price, location, state FROM housedetails WHERE location=? AND state=?");
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println("Exception in init: " + ex);
//            throw new ServletException("Initialization failed: " + ex.getMessage());
//        }
//    }
//
//    @Override
//    public void destroy() {
//        try {
//            if (ps != null) {
//                ps.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println("Exception in destroy: " + ex);
//        }
//    }
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        List<House> houseNames = new ArrayList<>();
//        try (PrintWriter out = response.getWriter()) {
//            String location = request.getParameter("location");
//            String state = request.getParameter("state");
//            ps.setString(1, location);
//            ps.setString(2, state);
//
//            try (ResultSet result = ps.executeQuery()) {
//                while (result.next()) {
//                    String ownername = result.getString("owner_name");
//                    String contact = result.getString("contact");
//                    double price = result.getDouble("price");
//                    String loc = result.getString("location");
//                    String st = result.getString("state");
//                    House hse = new House(ownername, contact, price, loc, st);
//                    houseNames.add(hse);
//                }
//            }
//
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>House Details</title>");
//            out.println("<style>");
//            out.println("table {width: 100%; border-collapse: collapse;}");
//            out.println("th, td {padding: 8px; text-align: left; border-bottom: 1px solid #ddd;}");
//            out.println("th {background-color: #f2f2f2;}");
//            out.println("</style>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h2>House Details</h2>");
//            if (houseNames.isEmpty()) {
//                out.println("<p>Sorry, there are no available houses for this location and state.</p>");
//                out.println("<a href='index.jsp'>Try Again</a>");
//            } else {
//                out.println("<table>");
//                out.println("<thead>");
//                out.println("<tr>");
//                out.println("<th>Owner Name</th>");
//                out.println("<th>Contact</th>");
//                out.println("<th>Price</th>");
//                out.println("<th>Location</th>");
//                out.println("<th>State</th>");
//                out.println("</tr>");
//                out.println("</thead>");
//                out.println("<tbody>");
//                for (House house : houseNames) {
//                    out.println("<tr>");
//                    out.println("<td>" + house.getOwnername() + "</td>");
//                    out.println("<td>" + house.getContact() + "</td>");
//                    out.println("<td>" + house.getPrice() + "</td>");
//                    out.println("<td>" + house.getLocation() + "</td>");
//                    out.println("<td>" + house.getState() + "</td>");
//                    out.println("</tr>");
//                }
//                out.println("</tbody>");
//                out.println("</table>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//        } catch (SQLException ex) {
//            throw new ServletException("Database access error: " + ex.getMessage(), ex);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Searchhouse servlet for finding houses based on location and state";
//    }
//}


//TRial

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Searchhouse extends HttpServlet {
    private Connection conn;
    private PreparedStatement ps;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userapp1";
            String username = "root";
            String password = "Anshu@1234";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully to the db");
            ps = conn.prepareStatement("SELECT owner_name, contact, price, location, state FROM housedetails WHERE location=? AND state=?");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception in init: " + ex);
            throw new ServletException("Initialization failed: " + ex.getMessage());
        }
    }

    @Override
    public void destroy() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Exception in destroy: " + ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<House> houseNames = new ArrayList<>();
        try (PrintWriter out = response.getWriter()) {
            String location = request.getParameter("location");
            String state = request.getParameter("state");
            ps.setString(1, location);
            ps.setString(2, state);

            try (ResultSet result = ps.executeQuery()) {
                while (result.next()) {
                    String ownername = result.getString("owner_name");
                    String contact = result.getString("contact");
                    double price = result.getDouble("price");
                    String loc = result.getString("location");
                    String st = result.getString("state");
                    House hse = new House(ownername, contact, price, loc, st);
                    houseNames.add(hse);
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>House Details</title>");
            out.println("<style>");
            out.println(".house-details {margin-bottom: 20px; padding: 10px; border: 1px solid #ddd;}");
            out.println(".house-details h3 {margin-top: 0;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>House Details</h2>");
            if (houseNames.isEmpty()) {
                out.println("<p>Sorry, there are no available houses for this location and state.</p>");
                out.println("<a href='index.jsp'>Try Again</a>");
            } else {
                for (House house : houseNames) {
                    out.println("<div class='house-details'>");
                    out.println("<h3>Owner Name: " + house.getOwnername() + "</h3>");
                    out.println("<p><strong>Contact:</strong> " + house.getContact() + "</p>");
                    out.println("<p><strong>Price:</strong> $" + house.getPrice() + "</p>");
                    out.println("<p><strong>Location:</strong> " + house.getLocation() + "</p>");
                    out.println("<p><strong>State:</strong> " + house.getState() + "</p>");
                    out.println("<a href=\"book.html\">Book now</a>");
                    
                    out.println("</div>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            throw new ServletException("Database access error: " + ex.getMessage(), ex);
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
        return "Searchhouse servlet for finding houses based on location and state";
    }
}

