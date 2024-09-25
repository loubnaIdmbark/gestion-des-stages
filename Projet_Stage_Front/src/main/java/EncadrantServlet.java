

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enteties.Encadrant;
import com.session.EncadrantLocal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/EncadrantServlet")
public class EncadrantServlet extends HttpServlet {
	
	@EJB
	EncadrantLocal encadrantSession;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    try {
                        add(request, response, session);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "update":
                    try {
                        update(request, response, session);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    delete(request, response, session);
                    break;
                case "chercher":
                    chercher(request, response, session);
                    break;
                case "bynom":
                    chercherByNom(request, response, session);
                    break;
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

    private void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException, ServletException {
        
        Encadrant encadrant = new Encadrant();
        encadrant.setNom(request.getParameter("nom"));
        encadrant.setPrenom(request.getParameter("prenom"));
        encadrant.setEmail(request.getParameter("email"));
        encadrant.setTelephone(Long.parseLong(request.getParameter("telephone")));
        encadrant.setCIN(request.getParameter("cin"));
        encadrant.setRole(request.getParameter("role"));
        encadrant.setDateNaissance(dateFormat.parse(request.getParameter("dob")));
        encadrantSession.addEncadrant(encadrant);
        getAll(request, response, session);
        response.sendRedirect("Encadrant.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException, ServletException {
        Encadrant encadrant = new Encadrant();
        encadrant.setId(Integer.parseInt(request.getParameter("id")));
        encadrant.setNom(request.getParameter("nom"));
        encadrant.setPrenom(request.getParameter("prenom"));
        encadrant.setEmail(request.getParameter("email"));
        encadrant.setTelephone(Long.parseLong(request.getParameter("telephone")));
        encadrant.setCIN(request.getParameter("cin"));
        encadrant.setRole(request.getParameter("role"));
        encadrant.setDateNaissance(dateFormat.parse(request.getParameter("dob")));
        encadrantSession.updateEncadrant(encadrant);
        getAll(request, response, session);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        encadrantSession.deleteEncadrant(Integer.parseInt(request.getParameter("id")));
        getAll(request, response, session);
        response.sendRedirect("Encadrant.jsp");
    }

    private void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("encadrant", encadrantSession.getEncadrant(Integer.parseInt(request.getParameter("id"))));
        RequestDispatcher disp = request.getRequestDispatcher("EncadrantModif.jsp"); 
        disp.forward(request, response);
    }

    private void chercherByNom(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("encadrants", encadrantSession.getByNom(request.getParameter("adminNom")));
        RequestDispatcher disp = request.getRequestDispatcher("Encadrant.jsp");
		disp.forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("encadrants", encadrantSession.getAllEncadrant());
        RequestDispatcher disp = request.getRequestDispatcher("Encadrant.jsp");
		disp.forward(request, response);
    }

}