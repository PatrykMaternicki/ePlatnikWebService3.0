<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja nowego uzytkownika systemu ePlatnik</title>
</head>
<body>
<label><strong>Rejestracja danych dotyczacych edukacji uzytkownika systemu ePLatnik</strong></label><br />
<form action="registerEducation" method="post">
<label><strong>School name:</strong><input type="text" id="nameschool" name="nameschool"></label><br />
<label><strong>Start year:</strong><input type="number" id="startyear" name="startyear"></label><br />
<label><strong>End year:</strong><input type="number" id="endyear" name="endyear"></label><br />
<input type="submit" value="dalej" />
</form>
</body>
</html>