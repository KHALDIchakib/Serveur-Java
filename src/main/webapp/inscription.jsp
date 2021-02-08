
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>

<form action="inscription" method="post">
    <h1>Se connecter</h1>

    <%
        if (request.getAttribute("error")!=null) {
            out.print("<small class=\"form-text red-text mb-4\">\n" + request.getAttribute("error") + "</small> <br> <br>");
        }
    %>

    <label>Nom:
        <input name="nom" type="text" placeholder="Entrer votre nom">
    </label>
    <br>
    <label>Prénom:
        <input name="prenom" type="text" placeholder="Entrer votre prénom">
    </label>
    <br>
    <label>Mail:
        <input name="email" type="text" placeholder="Entrer votre email">
    </label>
    <br>
    <label>Mot de passe:
        <input name="password" type="password" placeholder="Entrer votre mot de passe">
    </label>
    <br>
    <label>Téléphone:
        <input name="telephone" type="text" placeholder="Entrer votre téléphone">
    </label>
    <br>
    <label>Année De naissence:
        <input name="anneeNaissence" type="text" placeholder="Entrer votre année de naissence">
    </label>
    <br>
    <label>Adresse:
        <input name="adresse" type="text" placeholder="Entrer votre adresse">
    </label>
    <br>
    <button class="btn btn-primary btn-block searchBox" type="submit">S'inscrire</button>
</form>
</body>
</html>
