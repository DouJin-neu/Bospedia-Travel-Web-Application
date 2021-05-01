<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 2/26/2021
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Movie</title>
</head>
<body>
<form action="movie.htm" method="post">
    <h1>Please enter the details below</h1>

    <table border="0" cellspacing="" cellpadding="">
        <tr>
            <td><label for="title"> Movie Title</label></td>
            <td><input type="text" name="title" id="title"/></td>
        </tr>
        <tr>
            <td><label for="actor"> Lead Actor</label></td>
            <td><input type="text" name="actor" id="actor"/></td>
        </tr>
        <tr>
            <td><label for="actress"> Lead Actress</label></td>
            <td><input type="text" name="actress" id="actress"/></td>
        </tr>
        <tr>
            <td><label for="genre"> Genre</label></td>
            <td><input type="text" name="genre" id="genre"/></td>
        </tr>
        <tr>
            <td><label for="movie_year"> Year</label></td>
            <td><input type="text" name="movie_year" id="movie_year"/></td>
        </tr>
    </table>
    <br/>
    <input type="submit" name="addMovie" value="Add Movie"/>
    <input type="hidden" name="option" value="add"/>

</form>
</body>
</html>
