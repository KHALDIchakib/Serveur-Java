
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier mes informations</title>
</head>
<body>
<form action="edit-account" method="post">
    <h1>Modifier mes informations :</h1>

    <%
        if (request.getAttribute("error")!=null) {
            out.print("<small class=\"form-text red-text mb-4\">\n" + request.getAttribute("error") + "</small> <br> <br>");
        }
    %>

    <label>Nom:
        <input name="nom" type="text" value="<% out.print(request.getAttribute("nom")); %>">
    </label>
    <br>
    <label>Prénom:
        <input name="prenom" type="text" value="<% out.print(request.getAttribute("prenom")); %>">
    </label>
    <br>
    <label>Mail: <% out.print(request.getAttribute("email")); %>
    </label>
    <br>
    <label>Mot de passe:
        <input name="password" type="password" value="<% out.print(request.getAttribute("password")); %>">
    </label>
    <br>
    <label>Téléphone:
        <input name="telephone" type="text" value="<% out.print(request.getAttribute("telephone")); %>">
    </label>
    <br>
    <label>Année De naissence:
        <input name="anneeNaissence" type="text" value="<% out.print(request.getAttribute("anneeNaissence")); %>">
    </label>
    <br>
    <label>Adresse:
        <input name="adresse" type="text" value="<% out.print(request.getAttribute("adresse")); %>">
    </label>
    <br>
    <button class="btn btn-primary btn-block searchBox" type="submit">Sauvgarder</button>
</form>
</body>
</html>
