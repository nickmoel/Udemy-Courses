<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
</head>

<title>Student Confirmation</title>

<body>

	The student is confirmed: ${student.firstName} ${student.lastName}
	<br>
	<br> Country: ${student.country}

	<br>
	<br> Favorite Language: ${student.favoriteLanguage}

	<br>
	<br> Operating System:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">

			<li>${temp}</li>
			<!-- passing temp variable in for looping element in the array  -->
		</c:forEach>
	</ul>
</body>

</html>