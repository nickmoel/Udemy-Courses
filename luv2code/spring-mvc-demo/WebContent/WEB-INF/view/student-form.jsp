<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" />

		<br>
		<br>

Last name: <form:input path="lastName" />

		<br>
		<br>

Country: <form:select path="country">

			<form:options items="${student.countryOptions}" />
			
<!-- 			old hard coded format
 -->			<%-- value="Brazil" label="Brazil" /> --%>
			<%-- <form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" /> --%>
		</form:select>

		<br>
		<br>
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		RUBY <form:radiobutton path="favoriteLanguage" value="RUBY" />

		<br>
		<br>
		Operating System:
		Linux <form:checkbox path="operatingSystem" value="Linux" />
				Mac OS <form:checkbox path="operatingSystem" value=" MAC OS" />
				Windows <form:checkbox path="operatingSystem" value=" WINDOWS" />
		
		
		<br>
		<br>

		<input type="submit" value="Submit" />
	</form:form>
</body>


</html>