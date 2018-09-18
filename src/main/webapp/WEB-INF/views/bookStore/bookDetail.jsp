<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Car</title>
</head>
<body>
<form:form modelAttribute="book" action="" method="post">
    <form:errors path="*" cssClass="errorblock" element="div" />

    <table>
        <tr>
            <td>Title:</td>
            <td>
                <form:input path="title" />
                <form:errors path="title" cssClass="errorblock" element="div" />

            </td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td>

                <form:input path="ISBN" />
                <form:errors path="ISBN" cssClass="errorblock" element="div" />

            </td>
        </tr>
        <tr>
            <td>Author:</td>
            <td>
                <form:input path="author" />
                <form:errors path="author" cssClass="errorblock" element="div" />
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>
                <form:input path="price" />
                <form:errors path="price" cssClass="errorblock" element="div" />

                 
            </td>
        </tr>
    </table>
    <c:choose>
        <c:when test="${book == null}">
            <input type="submit" value="Create"/>
        </c:when>
        <c:otherwise>
            <input type="submit" value="Update"/>
        </c:otherwise>
    </c:choose>

</form:form>

<c:if test="${book != null}">
    <form action="/books/delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
</c:if>

</body>
</html>