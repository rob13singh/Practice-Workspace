<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Student Display Page</title>
	</head>
	<body>
		The Student is: ${student.firstName } ${student.lastName }
		<br>
		Country: ${student.country }
		<br>
		Language: ${student.language }
		<br>
		OS: 
		<ul>
			<c:forEach var="temp" items="${student.os}">
			<li>${temp }</li>
			</c:forEach>
		</ul>
	</body>
</html>	