<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="register" method="post" commandName="adduser">
            <table>
                <tr>
                    <td colspan="2" align="center"><h2>Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input  type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input  type="email" name="email" /></td>
                </tr>
                <tr>
                    <td>Mobile No:</td>
                    <td><input  type="tel" name="mobile"  maxlength="10" min="10"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input  type="text" name="address" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
