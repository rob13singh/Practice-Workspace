<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Student Page</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName"/>
			<br>
			Last Name: <form:input path="lastName"/>
			<br>
			<br>
			<form:select path="country">
				<form:options items="${student.countryOptions}"/>
			</form:select>
			<br><br>
			Java<form:radiobutton path="language" value="Java"/>
			C<form:radiobutton path="language" value="C"/>
			<br><br>
			Windows<form:checkbox path="os" value="Windows"/>
			Unix<form:checkbox path="os" value="Unix"/>
			<input type="submit" value="Submit"/>
		</form:form>
	</body>
</html>