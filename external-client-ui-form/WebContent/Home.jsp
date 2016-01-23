<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Form</title>

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

</style>

</head>
<body>

	<div id="header">
		
		<img src="http://www.techgig.com/files/photo_1426577193_quiz_image_temp.jpg" width="100px" height="70px" align="left" />
		<h1>Image Inbound request web form</h1>
		
	</div>
	
	

	<div id="section">
		<form action="SimpleServlet">
			<h2>Movie/Episode Details:</h2>
			
			<div>
				<label for = "applicantName">Movie or Episode Name</label> 
				<div>
					<input type="text" id = "movieEpisodeName" name="movieEpisodeName" size="20px" />
				</div>
			</div>

			<div>
				<label for = "emailAddress">Release Year</label>
				<div>
					<input type="text" id = "releaseYear" name="releaseYear" size="20px" />
				</div>
			</div>

			<div>
				<label for = "applicantName">Air Date</label> 
				<div>
					<input type="text" id = "airDate" name="airDate" size="20px" />
				</div>
			</div>

			<div>
				<label for = "emailAddress">Country</label>
				<div>
					<input type="text" id = "country" name="country" size="20px" />
				</div>
			</div>
		
			<input type="submit" value="SUBMIT"><br>
		</form>
	</div>

	<div id="footer">Powered by <strong>Red Hat JBoss BPM Suite</strong></div>

</body>
</html>
