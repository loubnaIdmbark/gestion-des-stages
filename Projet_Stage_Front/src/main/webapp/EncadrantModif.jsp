<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.enteties.Encadrant" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Encadrant encadrant = (Encadrant) session.getAttribute("encadrant");

            String id = encadrant.getId()+ "";
            String nom = encadrant.getNom();
            String prenom = encadrant.getPrenom();
            String role = encadrant.getRole();
            String email = encadrant.getEmail();
            String cin = encadrant.getCIN();
            String telephone = encadrant.getTelephone().toString();
            String dob = sdf.format(encadrant.getDateNaissance());
        
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
                <img src="images/logo.png" alt="">
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
                        <i class="uil uil-edit"></i>
                        <span class="text">Modifier un encadrant</span>
                    </div>
    
                    <div class="form-container">
                        <form id="Encadrant-form" method="post" action="EncadrantServlet">
                            <div class="form-group">
                                <label for="cin">CIN:</label>
                                <input type="text" id="cin" name="cin" value="<%=cin%>" required>
                                <input hidden name="id" value="<%=id%>" required>
                            </div>
                            <div class="form-group">
                                <label for="dob">Date de Naissance:</label>
                                <input type="date" id="dob" name="dob" value="<%=dob%>"  required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" value="<%=email%>" required>
                            </div>
                            <div class="form-group">
                                <label for="nom">Nom:</label>
                                <input type="text" id="nom" name="nom" value="<%=nom%>" required>
                            </div>
                            <div class="form-group">
                                <label for="prenom">Prenom:</label>
                                <input type="text" id="prenom" name="prenom"  value="<%=prenom%>" required>
                            </div>
                            <div class="form-group">
                                <label for="telephone">Telephone:</label>
                                <input type="tel" id="telephone" name="telephone" value="<%=telephone%>" required>
                            </div>
                            <div class="form-group">
                                <label for="role">Role:</label>
                                <input type="text" id="role" name="role" value="<%=role%>" required>
                                <input name="action" value="update" hidden>
                            </div>
                            <div class="form-buttons">
                                <button type="submit" class="btn btn-warning" id="btn-modifier">
                                    <i class="uil uil-edit"></i> Modifier
                                </button>
                            </div>
                        </form>
                    </div>
    <script src="Scripts/script.js"></script>
</body>
</html>