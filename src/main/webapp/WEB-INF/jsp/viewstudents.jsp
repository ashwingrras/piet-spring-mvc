    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Student List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Course</th><th>Address</th><th>Delete</th></tr>
    <c:forEach var="student" items="${list}">
    <tr>
    <td>${student.id}</td>
    <td>${student.name}</td>
    <td>${student.course}</td>
    <td>${student.address}</td>

    <td><a href="deletestudent/${student.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="studentform">Add New Student</a>