<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.enteties.Stagiaire" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Stagiaire stagiaire = (Stagiaire) session.getAttribute("stagiaire");
    String date = sdf.format(stagiaire.getDateNaissance());
    String id = Integer.toString(stagiaire.getId());
    String cin = stagiaire.getCIN();
    String nom = stagiaire.getNom();
    String prenom = stagiaire.getPrenom();
    String mail = stagiaire.getEmail();
    String tel = Long.toString(stagiaire.getTelephone());
    String etablissement = stagiaire.getEtablissemnt();
    String filiere = stagiaire.getFiliere();
    String adresse = stagiaire.getAdresse();

        
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
   
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

<title>Admin app</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>

<nav>
        <div class="logo-name">
            <div class="logo-image">
                <img src="logo.png" alt="">
            </div>

            <span class="logo_name">Admin App</span>
        </div>

        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="#">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Accueil</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-briefcase"></i>
                    <span class="link-name">Admin DRH</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-chart"></i>
                    <span class="link-name">Statistiques</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-user-md"></i>
                    <span class="link-name">Chef DRH</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-users-alt"></i>
                    <span class="link-name">Encadrants</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-users-alt"></i>
                    <span class="link-name">Stagiaires</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-file-plus"></i>
                    <span class="link-name">Stages</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-file-check"></i>
                    <span class="link-name">Attestations</span>
                     </a></li>
            </ul>
            
            <ul class="logout-mode">
                <li><a href="#">
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
                        <i class="uil uil-plus"></i>
                        <span class="text">Ajouter un Stagiaire</span>
                    </div>
    
                    <div class="center-container form-container">
                        <form id="Encadrant-form" method="post" action="StagiaireServlet">
                            <div class="form-group">
                                <label for="cin">CIN:</label>
                                <input type="text" id="cin" name="CIN" value="<%=cin%>" required>
                            </div>
                            <div class="form-group">
                                <label for="dob">Date de Naissance:</label>
                                <input type="date" id="dob" name="DateN" value="<%=date%>" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="mail" value="<%=mail%>" required>
                            </div>
                            <div class="form-group">
                                <label for="nom">Nom:</label>
                                <input type="text" id="nom" name="nom" value="<%=nom%>" required>
                            </div>
                            <div class="form-group">
                                <label for="prenom">Prenom:</label>
                                <input type="text" id="prenom" name="prenom" value="<%=prenom%>" required>
                            </div>
                            <div class="form-group">
                                <label for="telephone">Telephone:</label>
                                <input type="tel" id="telephone" name="tel" value="<%=tel%>" required>
                            </div>
                             <div class="form-group">
                                <label for="telephone">Etablissement:</label>
                                <input type="text" id="etablissement" name="etablissemnt" value="<%=etablissement%>" required>
                            </div>
                             <div class="form-group">
                                <label for="filiere">Filiere:</label>
                                <input type="text" id="filiere" name="filiere" value="<%=filiere%>" required>
                            </div>
                            <div class="form-group">
                                <label for="adresse">Adresse:</label>
                                <input type="text" id="adresse" name="adresse" value="<%=adresse%>" required>
                            </div>
                             <div class="form-group">
                                <label for="idEncadrant">ID encadrant:</label>
                                <input type="number" id="idEncadrant" name="id_encadr"  required>
                            </div>
                               <div class="form-group">
                                <label for="idStage">ID Stage:</label>
                                <input type="number" id="idStage" name="id_stage" required>
                                <input type="number" id="id" name="id" value="<%=id%>" hidden>
                                <input type="hidden" name="action" value="update">
                             </div>
                         
                             
                   
                            <div class="form-buttons">
                                <button type="submit" class="btn btn-primary">
                                    <i class="uil uil-plus"></i> Affecter
                                </button>
                                <button type="reset" class="btn btn-warning" id="btn-modifier">
                                    <i class="uil uil-trash-alt"></i> Effacer
                                </button>
                                   </div>
                            
                         
                           </form>       
                       
 </div>
        
     
            
      
    </section>

    <script src="Scripts/stagiaire.js"></script>
</body>
</html>