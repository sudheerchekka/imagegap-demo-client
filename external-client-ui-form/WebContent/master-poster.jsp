<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poster database</title>

<style>

body {
	font-family: sans-serif;
}

#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#footer {
	text-align: center;
	padding: 1em;
}

form {
	border: 2px solid #f0f0f0;
}

form > div {
	padding: .5em;
}

form > div:nth-child(odd) {
	background-color: #f0f0f0;
}

form div label {
	display: inline-block;
	min-width: 25%;
}

form > div > div {
	display: inline-block;
}

input[type="submit"] {
	padding: .5em 1em .5em 1em;
	background-color: red;
	font-weight: bold;
	color: white;
	border: 0;
	margin: 1em;
	font-size: large;
}

h2 {
	font-size: large;
	color: red;
	margin: 0;
	padding: .4em;
	padding-top: 1.5em;
}

h3 {
	font-size: 2em;
	color: white;
	font-weight: bold;
	margin: 0;
	padding: .4em;
	padding-top: 1.5em;
}

tr.even { background: lightgray; }
tr.odd { background: white; }
th {background: lightskyblue}

</style>

</head>
<body>

	<div id="header">
		
		<img src="http://www.techgig.com/files/photo_1426577193_quiz_image_temp.jpg" width="100px" height="70px" align="left" />
		<h1>Poster database</h1>
		
	</div>
	
	
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/bpms62"
        user="bpmsDBA" password="jboss123!"
    />
     
    <sql:query var="listPosters"   dataSource="${myDS}">
        SELECT posterId, posterTags, posterUrl FROM bpms62.MOVIE_EPISODE_POSTER;
    </sql:query>
     
     <div id="section">
    <div align="center">
        <table border="1" cellpadding="5" >
            <caption><h2>List of Posters</h2></caption>
            <tr background="blue">
                <th>Poster Id</th>
                <th>Poster URL</th>
                <th>tag</th>
            </tr>
            <c:forEach var="user" items="${listPosters.rows}" varStatus="loop">
                <tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
                    <td><c:out value="${user.posterId}" /></td>
                    <td><c:out value="${user.posterUrl}" /></td>
                    <td><c:out value="${user.posterTags}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
</body>
</html>