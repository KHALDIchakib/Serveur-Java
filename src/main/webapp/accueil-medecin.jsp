
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil Médecin Heal</title>
</head>
<body>
    <h1> Bienvenu </h1>
    <h1> Votre identifiant est : <% out.print(request.getAttribute("id"));%></h1>
    <h1> Votre mail est : <% out.print(request.getAttribute("email"));%></h1>
    <h1> Vous êtes un : <% out.print(request.getAttribute("type"));%></h1>
    <br><br><br><br>
    <a href="logout">Déconnexion</a>
</body>
</html>
