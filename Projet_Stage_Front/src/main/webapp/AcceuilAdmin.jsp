<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     
   
    <link rel="stylesheet" href="hamza.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    
<%
    String NbrStagiaire = String.valueOf(session.getAttribute("totalStagiaire"));
    String NbrEncadrant = String.valueOf(session.getAttribute("totalEncadrants"));
    String NbrStage = String.valueOf(session.getAttribute("totalStage"));

    String NbrStagiaireAffecte = String.valueOf(session.getAttribute("StagiaireAffecte"));
    String NbrEncadrantAffecte = String.valueOf(session.getAttribute("EncadrantAffecte"));
    String NbrStageAffecte = String.valueOf(session.getAttribute("StageAffecte"));

    String NbrStagiaireNonAffecte = String.valueOf(session.getAttribute("StagiaireNouveaux"));
    String NbrEncadrantNonAffecte = String.valueOf(session.getAttribute("EncadrantNonAffecte"));
    String NbrStageNonAffecte = String.valueOf(session.getAttribute("StageNonAffecte"));
%>
<title>Admin app</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body>
<%

	
%>
<nav>
        <div class="logo-name">
            <div class="logo-image">
                <img src="logo.png" alt="">
            </div>

            <span class="logo_name">Admin App</span>
        </div>

        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="AcceuilAdmin.jsp">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Accueil</span>
                </a></li>
                <li id="chef"><a href="Cadre.jsp">
                    <i class="uil uil-briefcase"></i>
                    <span class="link-name">Admin DRH</span>
                </a></li>
                <li><a href="Email.jsp">
                    <i class="uil uil-envelope-alt"></i>
                    <span class="link-name">Emails</span>
                </a></li>
                <li id="admin"><a href="Cadre.jsp">
                    <i class="uil uil-user-md"></i>
                    <span class="link-name">Chef DRH</span>
                </a></li>
                <li ><a href="Encadrant.jsp">
                    <i class="uil uil-users-alt"></i>
                    <span class="link-name">Encadrants</span>
                </a></li>
                <li><a href="Stagiaire.jsp">
                    <i class="uil uil-users-alt"></i>
                    <span class="link-name">Stagiaires</span>
                </a></li>
                <li><a href="Stage.jsp">
                    <i class="uil uil-file-plus"></i>
                    <span class="link-name">Stages</span>
                </a></li>
                <li><a href="Attestation.jsp">
                    <i class="uil uil-file-check"></i>
                    <span class="link-name">Attestations</span>
                    </a></li>
                <li><a href="Abscence.jsp">
                    <i class="uil uil-ban"></i>
                    <span class="link-name">Abscence</span>
                    </a></li>
                <li id="compte"><a href="Compte.jsp">
                    <i class="uil uil-user"></i>
                    <span class="link-name">Compte</span>
                    </a></li>

            </ul>
            
            <ul class="logout-mode">
                <li><a href="index.html">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>

                <li class="mode">
                    <a href="#">
                        <i class="uil uil-moon"></i>
                    <span class="link-name">Dark Mode</span>
                </a>

                <div class="mode-toggle">
                  <span class="switch"></span>
                </div>
            </li>
            </ul>
        </div>
    </nav>

    <section class="dashboard">
        <div class="top">
            <i class="uil uil-bars sidebar-toggle"></i>

            
         
        </div>

       
    
                    <div class="dash-content">
                        <div class="overview">
                            <div class="title">
                                <i class="uil uil-home"></i>
                                <span class="text">Accueil</span>
                            </div>
                            
                         <div class="center-container">
                        	     <h2>Bienvenue dans votre espace administrateur ! </h2>
                        	     <p>Vous trouvez ci-dessous les statistiques relatives aux stages,stagiaires et encadrants </p>
            			 </div>
             
              
                        <div class="overview">
                            <div class="title">
                                <i class="uil uil-chart"></i>
                                <span class="text">Les Encadrants </span> 
                                     
                                
                            </div>
             
              <form id="statistiques-form" method="post" action="AcceuilServlet"> 
                   				 <div class=" boxes">
                            <div class="box box1">
                                    <i class="uil uil-users-alt"></i>
                                    <h1 >Total</h1>
                                   <span class="number"><%=NbrEncadrant%></span>
                                </div>
                                <div class=" box box1">
                                    <i class="uil uil-plus"></i>
                                    <h1 >Nouveux</h1>
                                    <span class="number"><%=NbrEncadrantNonAffecte%></span>
                                   </div>
                                
                                <div class="box box2">
                                    <i class="uil-hourglass"></i>
                                    <h1 >Encours</h1>
                                       <span class="text"> </span>
                                    <span class="number"><%=NbrEncadrantAffecte%></span>
                                </div>
                                
                            
                            </div>
                           
                             
                             
                             <div class="overview">
                            <div class="title">
                                <i class="uil uil-users-alt"></i>
                                <span class="text">Les Stagiaires</span>
                            </div>
             
                   				 <div class=" boxes">
                            
                            <div class=" box box1">
                                    <i class="uil uil-users-alt"></i>
                                    <h1 >Total</h1>
                                    <span class="number"><%=NbrStagiaire%></span>
                                   </div>
                                   
                                <div class=" box box1">
                                    <i class="uil-user-check"></i>
                                    <h1 >Affectes</h1>
                                    <span class="number"><%=NbrStagiaireAffecte%></span>
                                   </div>
                                
                                <div class="box box2">
                                    <i class="uil-user-times"></i>
                                    <h1 >Non Affectes</h1>
                                       <span class="text"> </span>
                                    <span class="number"><%=NbrStagiaireNonAffecte%></span>
                                </div>
                               
                            </div>
                             </div>
                             
                             
                                   <div class="overview">
                            <div class="title">
                                <i class="uil uil-chart"></i>
                                <span class="text">Les Stages</span>
                            </div>
             
             
                   				 <div class=" boxes">
                   				  <div class=" box box1">
                                    <i class="uil uil-file-plus"></i>
                                    <h1 >Total</h1>
                                    <span class="number"><%=NbrStage%></span>
                                   </div>
                            
                                <div class=" box box1">
                                    <i class="uil-file-check"></i>
                                    <h1 >Affectes</h1>
                                    <span class="number"><%=NbrStageAffecte%></span>
                                   </div>
                                
                                <div class="box box2">
                                    <i class="uil-file-times"></i>
                                    <h1 >Non affectes</h1>
                                       <span class="text"> </span>
                                    <span class="number"><%=NbrStageNonAffecte%></span>
                                </div>
                               
                            </div>
                               
                             </div>
                            </form>   
                         
                         </div>    
                        </div>
                      
		      <br>
           <br>
		          
		       </div>
                           
   				 
                  

    


                        
</section>
  
           
 
    <script src="Scripts/abscence.js"></script>
    <script>
        const userType = '<%= session.getAttribute("userType") %>';
        var btnCompte = document.getElementById('compte');
        var btnChef = document.getElementById('chef');
        var btnAdmin = document.getElementById('admin');
        var overview = document.getElementById('overview');

        if (userType == 'Admin') {
            btnCompte.style.display = 'none';
            btnChef.style.display = 'none';
            btnAdmin.style.display = 'none';
            overview.style.display = 'none';
        }
        else if (userType == 'Cadre') {
            btnCompte.style.display = 'none';
        } else {
            console.log("User type not recognized");
        }
    </script>
</body>

</html>