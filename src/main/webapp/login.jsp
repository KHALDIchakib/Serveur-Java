
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <form action="login" method="post">
        <h1>Se connecter</h1>

        <%
            if (request.getAttribute("error")!=null) {
                out.print("<small class=\"form-text red-text mb-4\">\n" + request.getAttribute("error") + "</small> <br> <br>");
            }
        %>

        <label>Mail:
            <input name="email" type="text" placeholder="Entrer votre email">
        </label>

        <label>Mot de passe:
            <input name="password" type="password" placeholder="Entrer votre mot de passe">
        </label>

        <button class="btn btn-primary btn-block searchBox" type="submit">Connexion</button>
    </form>

</body>
</html>
