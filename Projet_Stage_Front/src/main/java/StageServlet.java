

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.enteties.Stage;
import com.session.StageLocal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/StageServlet")
public class StageServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 5556052098244279872L;
	@EJB
	StageLocal stageSession;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Stage.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "update":
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("Stage.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "delete":
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("Stage.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "chercher":
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("Stage.jsp");
                    dispatcher3.forward(request, response);
                    break;
                case "getAll":
                    getAll(request, response, session);
                    break;
                case "getByType":
                    RequestDispatcher dispatcher4 = request.getRequestDispatcher("Stage.jsp");
                    dispatcher4.forward(request, response);
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
                case "getAll":
                    getAll(request, response, session);
                    break;
                case "getByType":
                    getByType(request, response, session);
                    break;
                default:
                    response.getWriter().println("Invalid action");
            }
        } else {
            response.getWriter().println("No action specified");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException, ParseException {
        
        Stage  stage = new Stage();
        stage.setSujet(request.getParameter("sujet"));
        date = dateFormat.parse(request.getParameter("dateDebut"));
        stage.setDateDebut(date);
        date = dateFormat.parse(request.getParameter("dateFin"));
        stage.setDateFin(date);
        stage.setDivision(request.getParameter("division"));
        stage.setType(request.getParameter("type"));
        stageSession.addStage(stage);
        getAll(request, response, session);
        response.sendRedirect("Stage.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException, ParseException {
        Stage stage = new Stage();
        stage.setId(Integer.parseInt(request.getParameter("id")));
        stage.setSujet(request.getParameter("sujet"));
        date = dateFormat.parse(request.getParameter("dateDebut"));
        stage.setDateDebut(date);
        date = dateFormat.parse(request.getParameter("dateFin"));
        stage.setDateFin(date);
        stage.setDivision(request.getParameter("division"));
        stage.setType(request.getParameter("type"));
        stageSession.updateStage(stage);
        getAll(request, response, session);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        stageSession.deleteStage(Integer.parseInt(request.getParameter("id")));
        getAll(request, response, session);
    }

    private void chercher(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Stage stage = stageSession.getStage(Integer.parseInt(request.getParameter("id_modif")));
        session.setAttribute("stage", stage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("StageModif.jsp");
        dispatcher.forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("stages", stageSession.getAllStages());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stage.jsp");
        dispatcher.forward(request, response);
    }

    private void getByType(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.setAttribute("stages", stageSession.getByType(request.getParameter("Type")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stage.jsp");
        dispatcher.forward(request, response);
    }

}