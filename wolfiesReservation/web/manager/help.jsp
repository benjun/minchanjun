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
    <li><h4>Add, Edit and Delete information for employees:</h4>
      <strong><a href="/TravelAgencyWeb/manager/employees.jsp">Employee 
      Management</a></strong>
    </li>
    <li><h4>Obtain a sales report for a particular month:</h4>
       <strong><a href="/TravelAgencyWeb/manager/revenue.jsp#0">Revenue 
       Reports --> Monthly Report</a></strong>
    </li>
    <li><h4>Produce a comprehensive listing of all flights:</h4>
      <strong><a href="/TravelAgencyWeb/manager/flights.jsp#0">Flight 
      Listings --> Comprehensive Listing</a></strong>
    </li>
    <li><h4>Produce a list of reservations by flight number or customer name:
    </h4>
      <strong><a href="/TravelAgencyWeb/manager/revenue.jsp#1">Revenue 
      Reports --> Reservation Listing</a></strong>
    </li>
    <li><h4>Produce a summary listing of revenue generated by a particular 
    flight, destination city, or customer:</h4>
      <strong><a href="/TravelAgencyWeb/manager/revenue.jsp#2">Revenue 
      Reports --> Revenue Summary</a></strong>
    </li>
    <li><h4>Determine which customer representative generated most total 
    revenue:</h4>
      <strong><a href="/TravelAgencyWeb/manager/revenue.jsp#3">Revenue 
      Reports --> Top Employee</a></strong>
    </li>
    <li><h4>Determine which customer generated most total revenue:</h4>
      <strong><a href="/TravelAgencyWeb/manager/revenue.jsp#4">Revenue 
      Reports --> Top Customer</a></strong>
    </li>
    <li><h4>Produce a list of most active flights:</h4>
      <strong><a href="/TravelAgencyWeb/manager/flights.jsp#1">Flight Listings --> Most Active Flights</a></strong>
    </li>
    <li><h4>Produce a list of all customers who have seats reserved on a given flight:</h4>
      <strong><a href="/TravelAgencyWeb/manager/flights.jsp#2">Flight Listings --> Customer Listing By Flight</a></strong>
    </li>
    <li><h4>Produce a list of all flights for a given airport:</h4>
      <strong><a href="/TravelAgencyWeb/manager/flights.jsp#3">Flight Listings --> Flight Listing By Airport</a></strong>
    </li>
    <li><h4>Produce a list of all flights whose arrival and departure times are on-time/delayed:</h4>
      <strong><a href="/TravelAgencyWeb/manager/flights.jsp#4">Flight Listings --> List Flights by Delays</a></strong>
    </li>
  </ul>
</p>

</body>
</html>