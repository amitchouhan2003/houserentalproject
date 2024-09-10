/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Searchanddisplay;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author krishtiwari
 */
public class RegisterHouse extends HttpServlet {
    private Connection conn;
    private PreparedStatement ps;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Userapp1";
            String username = "root";
            String password = "Anshu@1234";

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully to the db");
            ps=conn.prepareStatement("Insert into housedetails values (?,?,?,?,?)");
            System.out.println("query set successfully");

        } catch (Exception ex) {
           ServletException obj=new ServletException(ex.getMessage());
            System.out.println("exception in init:,"+ex);
           throw obj;


        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter pw = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            pw.println("<html>");
                pw.println("<head>");
                pw.println("<title>Registration response</title>");
                pw.println("</head>");
                pw.println("<body>");

                String ownername=request.getParameter("ownername");
                String contact=request.getParameter("contact");
                String p=request.getParameter("price");
                String location=request.getParameter("location");
                String state=request.getParameter("state");
                double price=Double.parseDouble(p);
                

                try{
                    ps.setString(1,ownername);
                    ps.setString(2,contact);
                    ps.setDouble(3,price);
                    ps.setString(4,location);
                    ps.setString(5,state);
                    int res=ps.executeUpdate();
                    if (res==1)
                    {
                    pw.println("<p>Thank you <strong></strong> for registering with us <br>you can now <a href='index.jsp'> Login</a></p>");
                } else {
                    pw.println("<p>Sorry! registration unsuccessful</p>");
                    pw.println("<p><a href='login.html'>try again</a></p>");
                }
            }
         catch (SQLException ex) {
            pw.println("Server is experiencing some issue, please try again later");
            ex.printStackTrace(); // Print the stack trace for debugging purposes
        } finally {
            pw.println("</body>");
            pw.println("</html>");
            pw.close();
        }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
