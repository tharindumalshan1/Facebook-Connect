
<%@page import="com.example.facebookConnect.restFB.UserProfile"%>
<%@page import="com.example.facebookConnect.restFB.GetUserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Response Page</title>
</head>
<body>
<%
    String access_token=(String)request.getParameter("access_token");
    GetUserDetails objGetUserDetails=new GetUserDetails();
   UserProfile objUserProfile=objGetUserDetails.GetProfileinfoOther(access_token);
%>
Access Token is : <%=access_token %> <br> <br>

User Name : <%=objUserProfile.getUserName() %> <br>
ID : <%=objUserProfile.getId() %> <br>
Email : <%=objUserProfile.getEmail() %> <br>
Picture : <%=objUserProfile.getPicture()%> <br>

<img src="<%=objUserProfile.getPicture()%>" alt="">

</body>
</html>