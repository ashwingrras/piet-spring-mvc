<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Student</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Course :</td>
          <td><form:input path="course" /></td>
         </tr> 
         <tr>  
          <td>Address :</td>
          <td><form:input path="address" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Create New" /></td>
         </tr>  
        </table>  
       </form:form>  
