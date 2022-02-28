<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Product Feedback Form </title>
</head>
<body>
	<center>
		<h1>Product Feedback</h1>
        <h2>
        	<a href="new">Add New Feedback</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Display All Feedback</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Feedback/h2></caption>
            <tr>
                <th>FORMID</th>
                <th>ProductName</th>
                <th>ProductQuality</th>
                <th>ProductWarranty</th>
                <th>ProductRating</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="feedback" items="${listFeedback}">
                <tr>
                    <td><c:out value="${feedback.formId}" /></td>
                    <td><c:out value="${feedback.productName}" /></td>
                    <td><c:out value="${feedback.productQuality}" /></td>
                    <td><c:out value="${feedback.productWarranty}" /></td>
                    <td><c:out value="${feedback.productRating}" /></td>
                    <td>
                    	<a href="edit?formId=<c:out value='${feedback.dformI}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${feedback.formId}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
