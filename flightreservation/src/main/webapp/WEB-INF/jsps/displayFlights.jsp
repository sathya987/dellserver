<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flights</title>
</head>
<body>
<h2>Flights:</h2>
<table>
<tr><th>Airlines</th>
<th>Departure City</th>
<th>Arrival City</th>
<!-- <th>Departure Time</th> -->

</tr>

<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<%-- <td>fmt:formatDate value="${flight.estimated_departure_time}" type="date" pattern="yyyy-MM-dd hh:mm:ss"</td> --%>
<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
</tr>

</c:forEach>
</table>
</body>
</html>