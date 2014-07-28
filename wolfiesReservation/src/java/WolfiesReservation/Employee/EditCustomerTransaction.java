/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WolfiesReservation.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Youngseo Son
 */
public class EditCustomerTransaction extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void service(HttpServletRequest request, HttpServletResponse 
                        response) throws ServletException, IOException {
        String customerId = (String)request.getParameter("CustomerId");
        String personFirstName = (String)request.getParameter("PersonFirstName");
        String personLastName = (String)request.getParameter("PersonLastName");
        String personAddress = (String)request.getParameter("PersonAddress");
        String personCity = (String)request.getParameter("PersonCity");
        String personState = (String)request.getParameter("PersonState");
        String personZipCode = (String)request.getParameter("PersonZipCode");
        String customerCreditCardNo = (String)request.getParameter("CustomerCreditCardNo");
        String customerEmail = (String)request.getParameter("CustomerEmail");
        
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "travelagency";
        String driver = "com.mysql.jdbc.Driver";
        String dbUserName = "root";
        String dbPassword = "root";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, dbUserName,   
                                            dbPassword);
            //Execute Query
            String strQuery = "UPDATE Person"
                    +" SET "
                    + " FirstName = ?,"
                    + " LastName = ?,"
                    + " Address = ?,"
                    + " City = ?,"
                    + " State = ?,"
                    + " ZipCode = ?"
                    + " WHERE Id = ?";
            
            PreparedStatement stm = conn.prepareStatement(strQuery);
            stm.setString(1, personFirstName);
            stm.setString(2, personLastName);
            stm.setString(3, personAddress);
            stm.setString(4, personCity);
            stm.setString(5, personState);
            stm.setString(6, personZipCode);
            stm.setString(7, customerId);
            stm.executeUpdate();
            
           
       
            
            strQuery = "UPDATE Customer"
                    +" SET"
                    + " CreditCardNo = ?,"
                    + " Email = ?"
                    + " WHERE Id = ?";
            stm = conn.prepareStatement(strQuery);
            stm.setString(1, customerCreditCardNo);
            stm.setString(2, customerEmail);
            stm.setString(3, customerId);
            stm.executeUpdate();
            RequestDispatcher rd = request.getRequestDispatcher(
                    "/employee/CustomerManagementSuccess.jsp");
            rd.forward(request, response);
            
           
            
            

        } catch(Exception e ) {
            e.printStackTrace();
        }
            
        response.setContentType("text/html");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
