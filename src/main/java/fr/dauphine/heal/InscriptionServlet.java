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

@WebServlet( name = "inscriptionServlet", value = "/inscription" )
public class InscriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 2562294252731783855L;

    @EJB
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserBo userBo = (UserBo) req.getSession().getAttribute("user");
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
            resp.sendRedirect("inscription.jsp"); // logged-in page
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String telephone = req.getParameter("telephone");
        String anneeNaissence = req.getParameter("anneeNaissence");
        String adresse = req.getParameter("adresse");

        UserBo userBo = new UserBo(nom, prenom, email, password, telephone, anneeNaissence, adresse,"patient", "actif");
        String errors = userBo.validateAttributes();
        if (!errors.equals("")){
            RequestDispatcher rd = req.getRequestDispatcher("inscription.jsp");
            req.setAttribute("error",errors);
            rd.forward(req,resp);
            return;
        }

        if (userService.findByEmail(email)!=null) {
            RequestDispatcher rd = req.getRequestDispatcher("inscription.jsp");
            req.setAttribute("error","this email already exists !");
            rd.forward(req,resp);
            return;
        }

        userService.save(userBo);
        resp.sendRedirect("login");
    }
}
