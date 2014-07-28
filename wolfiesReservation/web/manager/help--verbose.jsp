<%-- 
    Document   : manager
    Created on : Apr 11, 2014, 11:10:50 AM
    Author     : 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.jquery.com/jquery.js"></script>
  <link rel="stylesheet" type="text/css" href="/TravelAgencyWeb/css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="/TravelAgencyWeb/css/style.css" />
   <link rel="stylesheet" type="text/css" href="/TravelAgencyWeb/logincss/textbox.css" />
  <script src="/TravelAgencyWeb/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="navbar.jsp" %>

<h2>Manager Help Page</h2>
<h3>How do I?</h3>
<p>
  <ul>
    <li><h4>Add, Edit and Delete information for employees:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/employees.jsp">Employee 
      Management</a></strong> page contains the means to search for employees 
      in the database. After finding the employee you're looking for, you can 
      edit or delete his/her information. Employees can also be added on this 
      page.
    </p></li>
    <li><h4>Obtain a sales report for a particular month:</h4><p>
       The <strong><a href="/TravelAgencyWeb/manager/revenue.jsp">Revenue 
       Reports</a></strong> page can produce sales reports for particular 
       months. This function can be found under the "Monthly Report" form.
    </p></li>
    <li><h4>Produce a comprehensive listing of all flights:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/flights.jsp">Flight 
      Listings</a></strong> page
    </p></li>
    <li><h4>Produce a list of reservations by flight number or customer name:
    </h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/revenue.jsp">Revenue 
      Reports</a></strong> page can produce lists of reservations given a 
      flight number or the name of a customer. This function can be found under the "Reservation Listing" form.
    </p></li>
    <li><h4>Produce a summary listing of revenue generated by a particular 
    flight, destination city, or customer:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/revenue.jsp">Revenue 
      Reports</a></strong> page can produce revenue summaries given a flight 
      number, the name of a city, or a customer's account number. This 
      function can be found under the "Revenue Summary" form.
    </p></li>
    <li><h4>Determine which customer representative generated most total 
    revenue:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/revenue.jsp">Revenue 
      Reports</a></strong> page can return the SSN of the employee who 
      generated the most total revenue for the company. This function can be 
      found under the "Top Employee" form.
    </p></li>
    <li><h4>Determine which customer generated most total revenue:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/revenue.jsp">Revenue 
      Reports</a></strong> page can return the Account Number and name of the 
      customer who generated the most total revenue for the company. This 
      function can be found under the "Top Customer" form.
    </p></li>
    <li><h4>Produce a list of most active flights:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/flights.jsp">Flight Listings</a></strong> page
    </p></li>
    <li><h4>Produce a list of all customers who have seats reserved on a given flight:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/flights.jsp">Flight Listings</a></strong> page
    </p></li>
    <li><h4>Produce a list of all flights for a given airport:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/flights.jsp">Flight Listings</a></strong> page
    </p></li>
    <li><h4>Produce a list of all flights whose arrival and departure times are on-time/delayed:</h4><p>
      The <strong><a href="/TravelAgencyWeb/manager/flights.jsp">Flight Listings</a></strong> page
    </p></li>
  </ul>
</p>

</body>
</html>