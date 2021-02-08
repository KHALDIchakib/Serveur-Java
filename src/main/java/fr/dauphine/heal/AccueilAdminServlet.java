package fr.dauphine.heal;

import fr.dauphine.heal.busnessobjects.UserBo;
import fr.dauphine.heal.ejb.services.api.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "accueilAdminServlet", value = "/accueil-admin" )
public class AccueilAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 2562294252731783855L;

    @EJB
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("accueil-admin.jsp");
        UserBo userBo = (UserBo) req.getSession().getAttribute("user");
        if (userBo != null && userBo.getType().equals("admin") && userBo.getStatut().equals("actif")) {
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
