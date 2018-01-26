<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja nowego uzytkownika systemu ePlatnik</title>
</head>
<body>
<label><strong>Rejestracja nowego adresu uzytkownika systemu ePLatnik</strong></label><br />
<form action="registerAddress" method="post">
<label><strong>Postal code:</strong><input type="text" id="postalcode" name="postalcode"></label><br />
<label><strong>City:</strong><input type="text" id="city" name="city"></label><br />
<label><strong>Country:</strong><input type="text" id="country" name="country"></label><br />
<label><strong>Flat number:</strong><input type="number" id="flatnumber" name="flatnumber"></label><br />
<label><strong>Street:</strong><input type="text" id="street" name="street"></label><br />
<input type="submit" value="dalej" />
</form>
</body>
</html>