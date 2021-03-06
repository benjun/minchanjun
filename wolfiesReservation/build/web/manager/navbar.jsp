<%-- 
    Document   : manager navbar
    Created on : Apr 11, 2014, 11:10:50 AM
    Author     : 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/TravelAgencyWeb/style_1.css" />
<nav class="navbar navbar-default" role="navigation">
    <a href="/TravelAgencyWeb/logout.jsp" class="navbar-right"> <img src="/TravelAgencyWeb/images/logout.png"></a>
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <img src="/TravelAgencyWeb/images/logo.png" class="navbar-left">
    <a class="navbar-brand" href="/TravelAgencyWeb/manager/index.jsp">Wolfie's Reservations :: Hello, <%= session.getAttribute("firstName") %>!</a>
  </div>
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Managers 
        <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="/TravelAgencyWeb/manager/index.jsp">Manager's Dashboard</a></li>
          <li><a href="/TravelAgencyWeb/manager/employees.jsp">Employee Management</a></li>
          <li><a href="/TravelAgencyWeb/manager/flights.jsp">Flight Listings</a></li>
          <li><a href="/TravelAgencyWeb/manager/revenue.jsp">Revenue Reports</a></li>
          <li class="divider"></li>
          <li><a href="/TravelAgencyWeb/manager/help.jsp">Help Me!</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
  <div id="footer">
  <p>Copyright@ Wolfies' Reservation.  Contact information: <a href="mailto:minchan.jun@stonybrook.edu">
  minchan.jun@stonybrook.edu</a>.</p>
</div>
</html>