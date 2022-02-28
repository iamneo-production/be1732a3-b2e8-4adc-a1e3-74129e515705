<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Product Feedback Form</title>
</head>
<body >
<center>
	
		<h1>Product Feedback</h1>
        <h2>
        	<a href="new">Add New Feedback/a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Display All Feedback</a>
        	&nbsp;&nbsp;&nbsp;
        </h2>
        </center>
	
    <div align="center">
		<c:if test="${feedback != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${feedback == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${feedback != null}">
            			Edit Feedback
            		</c:if>
            		<c:if test="${feedback == null}">
            			Add New Feedback
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${feedback != null}">
        			<input type="hidden" name="formId" value="<c:out value='${feedback.formId}' />" />
        		</c:if>            
            
            <tr>
                <th>Product Name: </th>
                <td>
                	<input type="text" name="productName" size="45"
                			value="<c:out value='${feedback.productName}' />"
                	/>
                </td>
            </tr>
           
           
            <tr>
                <th>Product Quality: </th>
                <td>
                	<input type="text" name="productQuality" size="45"
                			value="<c:out value='${feedback.productQuality}' />"
                	/>
                </td>
            </tr>

			<tr>
                <th>Product Warranty: </th>
                <td>
                	<input type="text" name="productWarranty" size="45"
                			value="<c:out value='${feedback.productWarranty}' />"
                	/>
                </td>
            </tr>

			<tr>
                <th>Product Rating: </th>
                <td>
                	<input type="text" name="productRating" size="45"
                			value="<c:out value='${feedback.productRating}' />"
                	/>
                </td>
            </tr>
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>