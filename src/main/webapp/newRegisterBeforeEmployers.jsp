<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja nowego uzytkownika systemu ePlatnik</title>
</head>
<body>
<label><strong>Rejestracja danych dotyczacych bylych uzytkownikow systemu ePLatnik</strong></label><br />
<form action="registerBeforeEmployers" method="post">
<label><strong>Name Employers:</strong><input type="text" id="nameemployers" name="nameemployers"></label><br />
<label><strong>Start year work:</strong><input type="number" id="startyearwork" name="startyearwork"></label><br />
<label><strong>End year work:</strong><input type="number" id="endyearwork" name="endyearwork"></label><br />
<label><strong>End month work:</strong><input type="number" id="endmonthwork" name="endmonthwork"></label><br />
<label><strong>Start month work:</strong><input type="number" id="startmonthwork" name="startmonthwork"></label><br />
<input type="submit" value="dalej" />
</form>
</body>
</html>