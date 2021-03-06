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
public class DelayedFlights extends HttpServlet {

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
        //connection preliminaries
        String msg = "";
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "travelagency";
        String driver = "com.mysql.jdbc.Driver";
        String dbUserName = "root";
        String dbPassword = "root";
        PrintWriter out = response.getWriter();
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, dbUserName,   
                                            dbPassword);
            //Execute Query
            String strQuery = "SELECT * FROM Flight F WHERE NOT EXISTS ( "
                            + "SELECT * FROM Leg L WHERE F.AirlineID = "
                            + "L.AirlineID AND F.FlightNo = L.FlightNo AND "
                            + "(ActualArrTime > ArrTime OR ActualDepTime > "
                            + " DepTime))";
            PreparedStatement stm = conn.prepareStatement(strQuery);
            ResultSet rs = stm.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            
            //Validate result set
            //Data structure to hold column names
            List<List<String>> columns = new ArrayList<List<String>>();
            columns.add(new ArrayList<String>());
            int rowCount = md.getColumnCount();
            for (int i = 1; i <= rowCount; i++) {
                columns.get(0).add(md.getColumnName(i));
            }
            //Data structure to hold result set
            List<List<String[]>> results = new ArrayList<List<String[]>>();
            results.add(new ArrayList<String[]>());
            while(rs.next()) {
                String[] row = new String[rowCount];
                for (int i = 1; i <= rowCount; i++) {
                    row[i-1] = rs.getString(columns.get(0).get(i-1));
                }
                results.get(0).add(row);
            }
            
            //Execute Query
            strQuery = "SELECT * FROM Flight F WHERE EXISTS ( SELECT * FROM "
                     + "Leg L WHERE F.AirlineID = L.AirlineID AND F.FlightNo "
                     + "= L.FlightNo AND (ActualArrTime > ArrTime OR "
                     + "ActualDepTime > DepTime))";
            stm = conn.prepareStatement(strQuery);
            rs = stm.executeQuery();
            md = rs.getMetaData();
            
            //Validate result set
            //Data structure to hold column names
            columns.add(new ArrayList<String>());
            rowCount = md.getColumnCount();
            for (int i = 1; i <= rowCount; i++) {
                columns.get(1).add(md.getColumnName(i));
            }
            //Data structure to hold result set
            results.add(new ArrayList<String[]>());
            while(rs.next()) {
                String[] row = new String[rowCount];
                for (int i = 1; i <= rowCount; i++) {
                    row[i-1] = rs.getString(columns.get(1).get(i-1));
                }
                results.get(1).add(row);
            }
            
            List<String> queryTypes = new ArrayList<String>();
            queryTypes.add("Delayed Flights: ");
            queryTypes.add("On-Time Flights: ");
            request.setAttribute("queries", queryTypes);
            request.setAttribute("columns", columns);
            request.setAttribute("results", results);
            RequestDispatcher rd = request.getRequestDispatcher(
                            "/manager/delayedqueryresults.jsp");
            rd.forward(request, response);
        } catch(Exception e ) {
            out.println(e);
            e.printStackTrace();
        }
        out.println(msg);
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
