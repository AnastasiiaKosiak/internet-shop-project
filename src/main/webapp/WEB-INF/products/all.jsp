<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Products</title>
</head>
<body>
    <table border="1">
     <tr>
         <th>ID</th>
         <th>Name</th>
         <th>Price</th>
         <th>Delete</th>
         <th>Add to cart</th>
     </tr>
     <c:forEach var="product" items="${products}">
            <tr>
                <td>
                    <c:out value="${product.id}"/>
                </td>
                <td>
                    <c:out value="${product.name}"/>
                </td>
                <td>
                    <c:out value="${product.price}"/>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/products/delete?id=${product.id}">Delete</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/products/add?id=${product.id}">Add to cart</a>
                </td>
            </tr>
        </c:forEach>
</table>
</body>
</html>