<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
   
    <link rel="stylesheet" href="style4.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

<title>Admin app</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>



    <section class="dashboard">
            <div class="dash-content">
                <div class="overview">
                    <div class="title">
                        <i class="uil uil-plus"></i>
                        <span class="text">S'inscrire</span>
                    </div>
    
                    <div class="center-container form-container">
                        <form id="Encadrant-form" method="post" action="StagiaireServlet">
                            <div class="form-group">
                                <label for="cin">CIN:</label>
                                <input type="text" id="cin" name="CIN" required>
                            </div>
                            <div class="form-group">
                                <label for="dob">Date de Naissance:</label>
                                <input type="date" id="dob" name="DateN" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="mail" required>
                            </div>
                            <div class="form-group">
                                <label for="nom">Nom:</label>
                                <input type="text" id="nom" name="nom" required>
                            </div>
                            <div class="form-group">
                                <label for="prenom">Prenom:</label>
                                <input type="text" id="prenom" name="prenom" required>
                            </div>
                            <div class="form-group">
                                <label for="telephone">Telephone:</label>
                                <input type="tel" id="telephone" name="tel" required>
                            </div>
                             <div class="form-group">
                                <label for="telephone">Etablissement:</label>
                                <input type="text" id="etablissement" name="etablissemnt" required>
                            </div>
                             <div class="form-group">
                                <label for="filiere">Filiere:</label>
                                <input type="text" id="filiere" name="filiere" required>
                            </div>
                            <div class="form-group">
                                <label for="adresse">Adresse:</label>
                                <input type="text" id="adresse" name="adresse" required>
                                <input type="text" hidden name="action" value="inscrire">
                            </div>
                            <div class="form-buttons">
                                <button type="submit" class="btn btn-primary">
                                    <i class="uil uil-plus"></i> S'inscrire
                                </button>
                                <button type="reset" class="btn btn-warning" id="btn-modifier">
                                    <i class="uil uil-trash-alt"></i> Effacer
                                </button>
                                   </div>
                           </form>       
                       
 </div>
            
    </section>
</body>
</html>