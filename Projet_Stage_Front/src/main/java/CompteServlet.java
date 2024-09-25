

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enteties.Cadre;
import com.enteties.Compte;
import com.session.CompteLocal;
import com.session.StatistiquesLocal;

import java.io.IOException;

@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	
	@EJB
	CompteLocal compteSession;
    @EJB
    StatistiquesLocal statistiques;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "login":
                    Login(request, response, session);
                    break;
                case "add":
                    add(request, response, session);
                    break;
                case "update":
                    update(request, response, session);
                    break;
                case "delete":
                    delete(request, response, session);
                    break;
                case "chercher":
                    chercher(request, response, session);
                    break;
                case "getAll":
                    getAll(request, response, session);
                    break;
                case "byuser":
                    byuser(request, response, session);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        } else {
            response.getWriter().println("No action specified");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "getAll":
                    getAll(request, response, session);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        } else {
            response.getWriter().println("No action specified");
        }
    }




    private void Login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        boolean stat = compteSession.getCompteByLoginAndPass(login, password);
        
        int totalEncadrants = statistiques.TotalEncadrant();
        System.out.println("servblet" + totalEncadrants);
        session.setAttribute("totalEncadrants", totalEncadrants);

        int totalStagiaire = statistiques.TotalStagiaire();
        session.setAttribute("totalStagiaire", totalStagiaire);
        
        int totalStage = statistiques.TotalStage();
        session.setAttribute("totalStage", totalStage);
        
        int StagiaireNouveaux = statistiques.StagiaireNouveaux();
        session.setAttribute("StagiaireNouveaux", StagiaireNouveaux);
        
        int EncadrantAffecte = statistiques.TotalEncadrant();
        session.setAttribute("EncadrantAffecte", EncadrantAffecte);

        int StageAffecte = statistiques.StageAffecete();
        session.setAttribute("StageAffecte", StageAffecte);
        
        int StagiaireAffecte = statistiques.StagiaireAffecete();
        session.setAttribute("StagiaireAffecte", StagiaireAffecte);
        
        int EncadrantNonAffecte = statistiques.TotalEncadrant()-statistiques.TotalEncadrant();
        session.setAttribute("EncadrantNonAffecte", EncadrantNonAffecte);
        
        int StageNonAffecte = statistiques.TotalStagiaire()-statistiques.StageAffecete();
        session.setAttribute("StageNonAffecte", StageNonAffecte);

        if (stat) {
            String type = compteSession.getCompteType(login);
            System.out.println(type);
            if ("Admin".equals(type)) {
                session.setAttribute("userType", type); // Store userType in the session
                request.getRequestDispatcher("AcceuilAdmin.jsp").forward(request, response);
            } else if ("Cadre".equals(type)) {
                session.setAttribute("userType", type);
                request.getRequestDispatcher("AcceuilAdmin.jsp").forward(request, response);
            } else if ("root".equals(type)) {
                session.setAttribute("userType", type);
                response.sendRedirect("AcceuilAdmin.jsp");
            } else {
                System.out.println("LoginServlet: Login failed");
            }
        } else {
            System.out.println("LoginServlet: Login failed");
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        Compte compte = new Compte();
        compte.setUser(request.getParameter("user"));
        compte.setPassword(request.getParameter("password"));
        compte.setType(request.getParameter("type"));
        Cadre cadre = new Cadre();
        cadre.setId(Integer.parseInt(request.getParameter("id_cadre")));
        compte.setCadre(cadre);
        compteSession.addCompte(compte);
        getAll(request, response, session);
    }

    private void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        Compte compte = new Compte();
        compte.setId(Integer.parseInt(request.getParameter("id")));
        compte.setUser(request.getParameter("user"));
        compte.setPassword(request.getParameter("password"));
        compte.setType(request.getParameter("type"));
        Cadre cadre = new Cadre();
        cadre.setId(Integer.parseInt(request.getParameter("id_cadre")));
        compte.setCadre(cadre);
        compteSession.updateCompte(compte);
        getAll(request, response, session);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        compteSession.deleteCompte(Integer.parseInt(request.getParameter("id")));
        getAll(request, response, session);
    }

    private void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id_modif"));
        session.setAttribute("compte", compteSession.getCompte(id));
        request.getRequestDispatcher("CompteModif.jsp").forward(request, response);
    }

    private void byuser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("comptes", compteSession.getCompteByLogin(request.getParameter("userSearch")));
        request.getRequestDispatcher("Compte.jsp").forward(request, response);
    }



    private void getAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
       session.setAttribute("comptes", compteSession.getAllCompte());
       request.getRequestDispatcher("Compte.jsp").forward(request, response);
    }


}

