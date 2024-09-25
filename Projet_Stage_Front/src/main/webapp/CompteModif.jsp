<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.enteties.Compte" %>
<%
    Compte compte = (Compte) session.getAttribute("compte");
    String id = Integer.toString(compte.getId());
    String user = compte.getUser();
    String password = compte.getPassword();
    String type = compte.getType();
    String id_cadre = Integer.toString(compte.getCadre().getId());
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
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>



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
                <span class="text">Ajouter un compte</span>
            </div>

            <div class="center-container form-container">
                <form id="Compte-form" method="post" action="CompteServlet">
                    <div class="form-group">
                        <label for="user">Utilisateur:</label>
                        <input type="text" id="user" name="user" value="<%=user%>" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Mot de passe:</label>
                        <input type="text" id="password" name="password" value="<%=password%>" required>
                    </div>
                    <div class="form-group">
                        <label for="type">Type:</label>
                        <input type="text" id="type" name="type" value="<%=type%>" required>
                    </div>
                    <div class="form-group">
                        <label for="user_id">ID de l'Cadre:</label>
                        <input type="text" id="user_id" name="id_cadre" value="<%=id_cadre%>" required>
                        <input type="text" id="user" name="id" value="<%=id%>" hidden required>
                        <input type="text" name="action" value="update" hidden required>
                    </div>

                    <div class="form-buttons">
                        <button type="submit" class="btn btn-primary" id="btn-ajouter">
                            <i class="uil uil-plus"></i> Modifier
                        </button>
                        <button type="reset" class="btn btn-warning" id="btn-effacer">
                            <i class="uil uil-trash-alt"></i> Effacer
                        </button>
                    </div>
                </form>
            </div>
    </section>

    <script src="Scripts/compte.js"></script>
</body>
</html>