/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WolfiesReservation.Manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Garret Leotta
 */
public class ReservationsByFlight extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void service(HttpServletRequest request, HttpServletResponse 
                        response) throws ServletException, IOException {
        //get form data
        String flightNo = request.getParameter("reservFlightNumber");
        String airId = flightNo.substring(0, 2);
        String fltNo = flightNo.substring(2);
        //connection preliminaries
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
            String strQuery = "SELECT DISTINCT R.ResrNo, R.ResrDate, "
                            + "R.TotalFare, R.BookingFee, R.RepSSN, "
                            + "P.FirstName, P.LastName FROM Reservation R, "
                            + "Customer C, Includes I, Person P WHERE "
                            + "R.AccountNo = C.AccountNo AND C.Id = P.Id AND "
                            + "I.ResrNo = R.ResrNo AND I.AirlineID = ? AND "
                            + "I.FlightNo = ? ";
            PreparedStatement stm = conn.prepareStatement(strQuery);
            stm.setString(1, airId);
            stm.setString(2, fltNo);
            ResultSet rs = stm.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            //Validate result set
            //Data structure to hold column names
            List<String> columns = new ArrayList<String>();
            int rowCount = md.getColumnCount();
            for (int i = 1; i <= rowCount; i++) {
                columns.add(md.getColumnName(i));
            }
            //Data structure to hold result set
            List<String[]> results = new ArrayList<String[]>();
            while(rs.next()) {
                String[] row = new String[rowCount];
                for (int i = 1; i <= rowCount; i++) {
                    row[i-1] = rs.getString(columns.get(i-1));
                }
                results.add(row);
            }
            
            String queryType = "Reservations on Flight " + flightNo + ": ";
            request.setAttribute("query", queryType);
            request.setAttribute("columns", columns);
            request.setAttribute("results", results);
            RequestDispatcher rd = request.getRequestDispatcher(
                                           "/manager/queryresults.jsp");
            rd.forward(request, response);
        } catch(Exception e ) {
            e.printStackTrace();
        }
            
        response.setContentType("text/html");
    }
    
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
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Customer Login Validation";
    }

}
