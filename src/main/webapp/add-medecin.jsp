
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Medecin</title>
</head>
<body>
    <form action="add-medecin" method="post">
        <h1>Ajouter un médecin :</h1>

        <%
            if (request.getAttribute("error")!=null) {
                out.print("<small class=\"form-text red-text mb-4\">\n" + request.getAttribute("error") + "</small> <br> <br>");
            }
        %>

        <label>Nom:
            <input name="nom" type="text" placeholder="Entrer le nom">
        </label>
        <br>
        <label>Prénom:
            <input name="prenom" type="text" placeholder="Entrer le prénom">
        </label>
        <br>
        <label>Mail:
            <input name="email" type="text" placeholder="Entrer le email">
        </label>
        <br>
        <label>Mot de passe:
            <input name="password" type="password" placeholder="Entrer le mot de passe">
        </label>
        <br>
        <label>Téléphone:
            <input name="telephone" type="text" placeholder="Entrer le téléphone">
        </label>
        <br>
        <label>Adresse:
            <input name="adresse" type="text" placeholder="Entrer une adresse">
        </label>
        <br>
        <button class="btn btn-primary btn-block searchBox" type="submit">Ajouter</button>
    </form>
</body>
</html>
