package fr.dauphine.heal;

import fr.dauphine.heal.busnessobjects.UserBo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "accueilServlet", value = "/accueil" )
public class AccueilServlet extends HttpServlet {
    private static final long serialVersionUID = 2562294252731783855L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("accueil.jsp");
        UserBo userBo = (UserBo) req.getSession().getAttribute("user");
        if (userBo != null && userBo.getType().equals("patient") && userBo.getStatut().equals("actif")) {
            req.setAttribute("id", userBo.getId());
            req.setAttribute("email", userBo.getEmail());
            req.setAttribute("type", userBo.getType());
            requestDispatcher.forward(req, resp);
        }else resp.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
