

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enteties.Attestation;
import com.enteties.Stagiaire;
import com.session.AttestationLocal;


import java.io.IOException;
import java.util.Date;
import java.util.Map;


@WebServlet("/AttestationServlet")
public class AttestationServlet extends HttpServlet {
	
	@EJB
	AttestationLocal attestationSession;

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
                default:
                    response.getWriter().println("Invalid action");
            }
        } else {
            response.getWriter().println("No action specified");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        
        Attestation attestation = new Attestation();
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(Integer.parseInt(request.getParameter("id_stagiaire")));
        attestation.setStagiaire(stagiaire);
        attestationSession.addAttestation(attestation); 
    }

    private void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Attestation attestation = new Attestation();
        attestation.setId(Integer.parseInt(request.getParameter("id")));
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(Integer.parseInt(request.getParameter("id_stagiaire")));
        attestation.setStagiaire(stagiaire);
        attestationSession.updateAttestation(attestation);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        attestationSession.deleteAttestation(Integer.parseInt(request.getParameter("id")));
    }

    private void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Map<String, Object> attestation = attestationSession.getAttestationbyNomAndPrenom(nom, prenom);
        int duree = (int) attestation.get("duration");
        System.out.println(duree);
        String type = (String) attestation.get("type");
        String division = (String) attestation.get("division");
        Date CurrentDate = new Date();
        String date = CurrentDate.toString();
        session.setAttribute("nom", nom);
        session.setAttribute("prenom", prenom);
        session.setAttribute("duree", duree);
        session.setAttribute("type", type);
        session.setAttribute("division", division);
        session.setAttribute("date", date);
        response.sendRedirect("Attestation.jsp");
    }

    

}
