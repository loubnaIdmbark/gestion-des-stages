


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enteties.Encadrant;
import com.enteties.Stage;
import com.enteties.Stagiaire;
import com.session.StagiaireLocal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/StagiaireServlet")
public class StagiaireServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 5556052098244279872L;
	@EJB
	StagiaireLocal stagiaireSession;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "getAll":
                    getAll(request, response, session);
                    break;
                case "SansStage":
                    getSansStage(request, response, session);
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
                case "accepter":
                    accepter(request, response, session);
                    break;
                case "inscrire":
                    try {
                        inscrire(request, response, session);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "getAll":
                    getAll(request, response, session);
                    break;
                case "SansStage":
                    getSansStage(request, response, session);
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

    public void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException, ServletException {
        Stagiaire st = new Stagiaire();
        st.setPrenom(request.getParameter("prenom"));
        st.setNom(request.getParameter("nom"));
        st.setCIN(request.getParameter("CIN"));
        st.setEtablissemnt(request.getParameter("etablissemnt"));
        st.setFiliere(request.getParameter("filiere"));
        st.setAdresse(request.getParameter("adresse"));
        st.setEmail(request.getParameter("mail"));
        st.setTelephone(Long.parseLong(request.getParameter("tel")));
        st.setDateNaissance(dateFormat.parse(request.getParameter("DateN")));
        st.setStage(new Stage(Integer.parseInt(request.getParameter("id_stage"))));
        st.setEncadrant(new Encadrant(Integer.parseInt(request.getParameter("id_encadr"))));
        stagiaireSession.addStagiaire(st);
        getAll(request, response, session);
    }

    public void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException, ServletException {
        Stagiaire st = new Stagiaire();
        st.setId(Integer.parseInt(request.getParameter("id")));
        st.setPrenom(request.getParameter("prenom"));
        st.setNom(request.getParameter("nom"));
        st.setCIN(request.getParameter("CIN"));
        st.setEtablissemnt(request.getParameter("etablissemnt"));
        st.setFiliere(request.getParameter("filiere"));
        st.setAdresse(request.getParameter("adresse"));
        st.setEmail(request.getParameter("mail"));
        st.setTelephone(Long.parseLong(request.getParameter("tel")));
        st.setDateNaissance(dateFormat.parse(request.getParameter("DateN")));
        st.setStage(new Stage(Integer.parseInt(request.getParameter("id_stage"))));
        st.setEncadrant(new Encadrant(Integer.parseInt(request.getParameter("id_encadr"))));
        stagiaireSession.updateStagiaire(st);
        getAll(request, response, session);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        stagiaireSession.deleteStagiaire(Integer.parseInt(request.getParameter("id")));
        getAll(request, response, session);
    }

    public void accepter(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("stagiaire", stagiaireSession.getStagiaire(Integer.parseInt(request.getParameter("id_accepter"))));
        RequestDispatcher dispatcher = request.getRequestDispatcher("StagiaireAccepter.jsp");
        dispatcher.forward(request, response);
    }

    public void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("stagiaire", stagiaireSession.getStagiaire(Integer.parseInt(request.getParameter("id_modif"))));
        RequestDispatcher dispatcher = request.getRequestDispatcher("StagiaireModif.jsp");
        dispatcher.forward(request, response);
    }

    public void inscrire(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException, ServletException {
        Stagiaire st = new Stagiaire();
        st.setPrenom(request.getParameter("prenom"));
        st.setNom(request.getParameter("nom"));
        st.setCIN(request.getParameter("CIN"));
        st.setEtablissemnt(request.getParameter("etablissemnt"));
        st.setFiliere(request.getParameter("filiere"));
        st.setAdresse(request.getParameter("adresse"));
        st.setEmail(request.getParameter("mail"));
        st.setTelephone(Long.parseLong(request.getParameter("tel")));
        st.setDateNaissance(dateFormat.parse(request.getParameter("DateN")));
        stagiaireSession.Inscrire(st);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("stagiaires", stagiaireSession.getAllStagiaire());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stagiaire.jsp");
        dispatcher.forward(request, response);
    }

    public void getSansStage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("demandes", stagiaireSession.getAllStagiaireSansStage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stagiaire.jsp");
        dispatcher.forward(request, response);
    }

    public void getByNom(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        session.setAttribute("stagiaires", stagiaireSession.getStagiairebyNom(request.getParameter("Nom")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stagiaire.jsp");
        dispatcher.forward(request, response);
    }

}