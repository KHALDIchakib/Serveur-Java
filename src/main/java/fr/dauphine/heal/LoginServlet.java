package fr.dauphine.heal;

import fr.dauphine.heal.beans.UserBean;
import fr.dauphine.heal.busnessobjects.UserBo;
import fr.dauphine.heal.ejb.services.api.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet( name = "loginServlet", value = "/login" )
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 2562294252731783855L;

    @EJB
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        fr.dauphine.heal.busnessobjects.UserBo userBo = (fr.dauphine.heal.busnessobjects.UserBo) req.getSession().getAttribute("user");
        if(userBo != null){
            if(userBo.getType().equals("admin")) {
                resp.sendRedirect("accueil-admin");
            }else{
                if (userBo.getType().equals("medecin"))
                    resp.sendRedirect("accueil-medecin");
                else
                    resp.sendRedirect("accueil");
            }
        }else{
            resp.sendRedirect("login.jsp"); // logged-in page
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserBean userBean = userService.findByEmail(email);
        UserBo userBo = null;
        if (userBean != null) {
            userBo = new UserBo(userBean);
        }
        if (userBo!=null && userBo.getPassword().equals(password)) {
            req.getSession().setAttribute("user", userBo);
            if(userBo.getType().equals("admin")) {
                resp.sendRedirect("accueil-admin");
            }else{
                if (userBo.getType().equals("medecin"))
                    resp.sendRedirect("accueil-medecin");
                else
                    resp.sendRedirect("accueil");
            }
        }else{
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            req.setAttribute("error","Email ou Mot de passe incorrect! Veuillez réessayer ");
            rd.forward(req,resp);
        }
    }
}
