<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja nowego uzytkownika systemu ePlatnik</title>
</head>
<body>
<label><strong>Rejestracja nowego uzytkownika systemu ePLatnik</strong></label><br />
<form action="registerPersonInformation" method="post">
<label><strong>Name:</strong><input type="text" id="name" name="name"></label><br />
<label><strong>Surname:</strong><input type="text" id="surname" name="surname"></label><br />
<label><strong>Date of Birth:</strong><input type="text" id="dateofbirth" name="dateofbirth"></label><br />
<label><strong>Place of Birth:</strong><input type="text" id="placeofbirth" name="placeofbirth"></label><br />
<label><strong>Old:</strong><input type="text" id="old" name="old"></label><br />
<label><strong>PESEL:</strong><input type="text" id="pesel" name="pesel"></label><br />
<input type="submit" value="dalej" />
</form>
</body>
</html>