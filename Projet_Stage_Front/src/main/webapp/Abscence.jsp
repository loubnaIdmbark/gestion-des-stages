<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
                <li><a href="AcceuilAdmin.jsp">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Accueil</span>
                </a></li>
                <li id="admin"><a href="Cadre.jsp">
                    <i class="uil uil-briefcase"></i>
                    <span class="link-name">Admin DRH</span>
                </a></li>
                <li><a href="Email.jsp">
                    <i class="uil uil-envelope-alt"></i>
                    <span class="link-name">Emails</span>
                </a></li>
                <li id="chef"><a href="Cadre.jsp">
                    <i class="uil uil-user-md"></i>
                    <span class="link-name">Chef DRH</span>
                </a></li>
                <li><a href="Encadrant.jsp">
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
                <li ><a href="Abscence.jsp">
                    <i class="uil uil-ban"></i>
                    <span class="link-name">Abscence</span>
                    </a></li>
                <li id="compte"><a href="Compte.jsp">
                    <i class="uil uil-user"></i>
                    <span class="link-name">Compte</span>
                    </a></li>

            </ul>
            
            <ul class="logout-mode">
                <li><a href="#">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>

                <li class="mode">
                    <a href="index.html">
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
                <span class="text">Ajouter une abscence</span>
            </div>

            <div class="center-container form-container">
                <form id="Compte-form" method="post" action="AbscenceServlet">
                    <div class="form-group">
                        <label for="date">Date:</label>
                        <input type="date" id="date" name="date" required>
                    </div>
                    <div class="form-group">
                        <label for="justification">Justification:</label>
                        <input type="text" id="justification" name="justification" required>
                    </div>
                    <div class="form-group">
                        <label for="justified">justifiee? (Oui ou Non):</label>
                        <input type="text" id="justified" name="justified" required>
                    </div>
                    <div class="form-group">
                        <label for="Stagiaire_id">ID du Stagiaire:</label>
                        <input type="text" id="Stagiaire_id" name="Stagiaire_id" required>
                        <input type="text" name="action" value="add" hidden required>
                    </div>
                    <div class="form-group">
                        <label for="id_cadre">ID du Cadre:</label>
                        <input type="text" id="user_id" name="id_cadre" required>
                    </div>

                    <div class="form-buttons">
                        <button type="submit" class="btn btn-primary" id="btn-ajouter">
                            <i class="uil uil-plus"></i> Ajouter
                        </button>
                        <button type="reset" class="btn btn-warning" id="btn-effacer">
                            <i class="uil uil-trash-alt"></i> Effacer
                        </button>
                    </div>
                </form>
            </div>

            <div class="activity">
                <div class="title">
                    <i class="uil uil-list-ul"></i>
                    <span class="text">Liste des abscences</span>
                </div>

                <form method="post" action="AbscenceServlet">
                    <div class="search-box">
                        <i class="uil uil-search"></i>
                        <input type="text" name="userSearch" placeholder="Chercher par Utilisateur">
                        <input type="hidden" name="action" value="byuser">
                        <div class="form-buttons">
                            <button type="submit" class="btn btn-chercher">
                                <i class="uil uil-search"></i> Chercher
                            </button>
                            <button type="button" class="btn btn-Liste" id="btn-Liste" onclick="updateTable()">
                                <i class="uil uil-list-ul"></i> Afficher tous les abscences
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <table class="table table-hover" id="tableContent">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Justification</th>
                <th>Justifiee</th>
                <th>ID Stagiaire</th>
                <th>ID Cadre</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
        </thead>
        <c:forEach items="${abscences}" var="abscence">
            <tr>
                <td>${abscence.id}</td>
                <td>${abscence.date_abs}</td>
                <td>${abscence.justified}</td>
                <td>${abscence.justification}</td>
                <td>${abscence.stagiaire.id}</td>
                <td>${abscence.cadre.id}</td>
                <td>
                    <form method="post" action="AbscenceServlet">
                        <input type="hidden" name="id_modif" value="${abscence.id}">
                        <input type="hidden" name="action" value="chercher">
                        <button type="submit" class="btn btn-primary" id="btn-modifier">Modifier</button>
                    </form>
                </td>
                <td>
                    <form method="post" action="AbscenceServlet">
                        <input type="hidden" name="id" value="${abscence.id}">
                        <input type="hidden" name="action" value="delete">
                        <button type="submit" class="btn btn-danger" id="btn-supprimer">
                            <i class="uil uil-trash-alt"></i> Supprimer
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
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