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

@WebServlet( name = "editAccountServlet", value = "/edit-account")
public class EditAccount extends HttpServlet {
    private static final long serialVersionUID = 2562294252731783855L;

    @EJB
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserBo userBo = (UserBo) req.getSession().getAttribute("user");
        if(userBo != null){
            if(userBo.getType().equals("patient")) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit-account.jsp");
                req.setAttribute("nom", userBo.getNom());
                req.setAttribute("prenom", userBo.getPrenom());
                req.setAttribute("email", userBo.getEmail());
                req.setAttribute("password", userBo.getPassword());
                req.setAttribute("telephone", userBo.getTelephone());
                req.setAttribute("anneeNaissence", userBo.getAnneeNaissence());
                req.setAttribute("adresse", userBo.getAdresse());
                requestDispatcher.forward(req,resp);
            }else{
                if (userBo.getType().equals("medecin"))
                    resp.sendRedirect("accueil-medecin");
                else
                    resp.sendRedirect("accueil-admin");
            }
        }else{
            resp.sendRedirect("login.jsp"); // logged-in page
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBo userBo = (UserBo) req.getSession().getAttribute("user");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String password = req.getParameter("password");
        String telephone = req.getParameter("telephone");
        String anneeNaissence = req.getParameter("anneeNaissence");
        String adresse = req.getParameter("adresse");

        UserBo userBo1 = new UserBo(nom, prenom, userBo.getEmail(), password, telephone, anneeNaissence, adresse,"patient", "actif");
        String errors = userBo1.validateAttributes();
        if (!errors.equals("")){
            RequestDispatcher rd = req.getRequestDispatcher("edit-account.jsp");
            req.setAttribute("error",errors);
            rd.forward(req,resp);
            return;
        }

        userBo.update(nom, prenom, password, telephone, anneeNaissence, adresse);
        userService.update(userBo);
        resp.sendRedirect("accueil");
    }
}
