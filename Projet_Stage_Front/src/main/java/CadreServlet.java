

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enteties.Cadre;
import com.session.CadreLocal;


import java.io.IOException;

@WebServlet("/CadreServlet")
public class CadreServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3891589496747783516L;
	@EJB
	CadreLocal cadreSession;

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
                case "getAll":
                    getAll(request, response, session);
                    break;
                case "getByNom":
                    getByNom(request, response, session);
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

    private void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        Cadre cadre = new Cadre();
        cadre.setNom(request.getParameter("nom"));
        cadre.setPrenom(request.getParameter("prenom"));
        cadre.setTelephone(Long.parseLong(request.getParameter("telephone")));
        cadre.setEmail(request.getParameter("email"));
        cadre.setRole(request.getParameter("role"));
        cadreSession.addCadre(cadre);
        getAll(request, response, session);
    }

    private void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Cadre cadre = new Cadre();
        cadre.setId(Integer.parseInt(request.getParameter("id")));
        cadre.setNom(request.getParameter("nom"));
        cadre.setPrenom(request.getParameter("prenom"));
        cadre.setTelephone(Long.parseLong(request.getParameter("telephone")));
        cadre.setEmail(request.getParameter("email"));
        cadre.setRole(request.getParameter("role"));
        cadreSession.updateCadre(cadre);
        getAll(request, response, session);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        cadreSession.deleteCadre(Integer.parseInt(request.getParameter("id")));
        getAll(request, response, session);
    }

    private void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("cadre", cadreSession.getCadre(Integer.parseInt(request.getParameter("id_modif"))));
        request.getRequestDispatcher("CadreModif.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("cadres",cadreSession.getAllCadre());
        request.getRequestDispatcher("Cadre.jsp").forward(request, response);
    }

    private void getByNom(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("cadres", cadreSession.getAllCadreByNom(request.getParameter("Nom")));
        request.getRequestDispatcher("Cadre.jsp").forward(request, response);
    }
}
