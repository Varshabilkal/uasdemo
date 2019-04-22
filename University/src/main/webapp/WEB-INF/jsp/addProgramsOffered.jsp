<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Add PrgramsOffered</h1>
<div>
	<form:form action="addProgramsOffered.html" method = "post">
	<table>
	<td><input path="programName" type="text" name="programName" required="true"></input></td></tr>
	<td><input path="description" type="text" name="description" required="true"></input></td></tr>
	<td><input path="applicantEligibility" type="text" name="applicantEligibility" required="true"></input></td></tr>
	<td><input path="duration" type="text" name="duration" required="true"></input></td></tr>
    <td><input path="degreeCertificate" type="text" name="degreeCertificate" required="true"></input></td></tr>
		<tr><td><button type="submit">Submit</button></td></tr>
			</table>
		</form:form>
	</div>
	</body>
	</html>