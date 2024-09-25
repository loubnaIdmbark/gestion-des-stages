import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.session.StatistiquesLocal;

@WebServlet("/accueilServlet")
public class AccueilServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StatistiquesLocal statistiques;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalEncadrants = statistiques.TotalEncadrant();
        request.setAttribute("totalEncadrants", totalEncadrants);

        
        int totalStagiaire = statistiques.TotalStagiaire();
        request.setAttribute("totalStagiaire", totalStagiaire);
        
        int totalStage = statistiques.TotalStage();
        request.setAttribute("totalStage", totalStage);
        
        int StagiaireNouveaux = statistiques.StagiaireNouveaux();
        request.setAttribute("StagiaireNouveaux", StagiaireNouveaux);
        
        int EncadrantAffecte = statistiques.TotalEncadrant();
        request.setAttribute("EncadrantAffecte", EncadrantAffecte);

        int StageAffecte = statistiques.StageAffecete();
        request.setAttribute("StageAffecte", StageAffecte);
        
        int TotalStagiaire = statistiques.TotalStagiaire();
        request.setAttribute("TotalStagiaire", TotalStagiaire);
        
        int StagiaireAffecte = statistiques.StagiaireAffecete();
        request.setAttribute("StagiaireAffecte", StagiaireAffecte);
        
        int EncadrantNonAffecte = statistiques.TotalEncadrant()-statistiques.TotalEncadrant();
        request.setAttribute("EncadrantNonAffecte", EncadrantNonAffecte);
        
        int StageNonAffecte = statistiques.TotalStagiaire()-statistiques.StageAffecete();
        request.setAttribute("StageNonAffecte", StageNonAffecte);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("AcceuilAdmin.jsp");
        dispatcher.forward(request, response);
        
        
    }

    
    
    
}

