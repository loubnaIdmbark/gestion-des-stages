

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enteties.Abscence;
import com.enteties.Cadre;
import com.enteties.Stagiaire;
import com.session.AbscenceLocal;


import java.io.IOException;

@WebServlet("/AbscenceServlet")
public class AbscenceServlet extends HttpServlet {
	
	@EJB
	AbscenceLocal abscenceSession;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
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
                case "getAllAbscence":
                    getAll(request, response, session);
                    break;
                case "getByStagiaire":
                    getByStagiaire(request, response, session);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        } else {
            response.getWriter().println("No action specified");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        Abscence abscence = new Abscence();
        abscence.setDate_abs(request.getParameter("date"));
        abscence.setJustification(request.getParameter("justification"));
        if (request.getParameter("justified").equals("oui")) {
            abscence.setJustified(1);
        } else {
            abscence.setJustified(0);
        }
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(Integer.parseInt(request.getParameter("Stagiaire_id")));
        abscence.setStagiaire(stagiaire);
        Cadre cadre = new Cadre();  
        cadre.setId(Integer.parseInt(request.getParameter("id_cadre")));
        abscence.setCadre(cadre);
        abscenceSession.addAbscence(abscence);   
        getAll(request, response, session); 
    }

    private void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        Abscence abscence = new Abscence();
        abscence.setId(Integer.parseInt(request.getParameter("id")));
        abscence.setDate_abs(request.getParameter("date"));
        abscence.setJustification(request.getParameter("justification"));
        if (request.getParameter("justified").equals("oui")) {
            abscence.setJustified(1);
        } else {
            abscence.setJustified(0);
        }
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(Integer.parseInt(request.getParameter("Stagiaire_id")));
        abscence.setStagiaire(stagiaire);
        Cadre cadre = new Cadre();  
        cadre.setId(Integer.parseInt(request.getParameter("id_cadre")));
        abscence.setCadre(cadre);
        abscenceSession.updateAbscence(abscence);
        getAll(request, response, session);
            
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        abscenceSession.deleteAbscence(Integer.parseInt(request.getParameter("id")));
        getAll(request, response, session);
    }

    private void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("abscence", abscenceSession.getAbscence(Integer.parseInt(request.getParameter("id_modif"))));
        request.getRequestDispatcher("AbscenceModif.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("abscences", abscenceSession.getAllAbscence());
        request.getRequestDispatcher("Abscence.jsp").forward(request, response);
    }

    private void getByStagiaire(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("abscences", abscenceSession.getByStagiaire(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("Abscence.jsp").forward(request, response);
    }

    
}
