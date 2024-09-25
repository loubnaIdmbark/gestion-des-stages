<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin app</title>
    <link rel="stylesheet" href="hamza.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
</head>
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
                    <i class="uil uil-print"></i>
                    <span class="text">Imprimer une attestation</span>
                </div>
                <form id="Encadrant-form" method="post" action="AttestationServlet">
                    <div class="center-container form-container">
                        <div class="">
                            <label for="nom">Nom Stagiaire:</label>
                            <input type="text" id="nom" name="nom" required>
                            <input name="action" value="chercher" hidden>
                            <label for="prenom">Prenom Stagiaire:</label>
                            <input type="text" id="prenom" name="prenom" required>
                            <div class="form-buttons">
                                <button type="submit" id="btn-ajouter" class="btn btn-primary">
                                    <i class="uil uil-check"></i> Valider
                                </button>
                            </div>
                        </div> 
                    </div>
                </form>
            </div>
            <div class="activity">
                <div class="attestation" id="attestation">
                    <p>Universit Sultan Moulay Slimane<br>
                    Ecole Nationale des Sciences<br>
                    Appliquees de Khouribga</p>
                    <h1>Attestation de stage</h1>
                    <p>Ce document certifie que :</p>
                    <h2>${nom} ${prenom}</h2>
                    <p>a effectue un stage de type ${type} au sein de notre Societe dans une duree de ${duree} jours.</p>
                    <p>ce stage a ete supervise par la division :</p>
                    <h2>${division}</h2>
                    <div class="signature">
                        <div class="signee">
                            <label>Signature de l'encadrant:</label>
                            <div class="logo-signature">
                                <img src="signture.png" alt="">
                            </div>
                            <div class="date">
                                <label>Date :</label>
                                <span>${date}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="center-container form-container">
                <div class="form-buttons">
                    <button type="button" id="btn-ajouter" class="btn btn-primary" onclick="generatePDF()">
                        <i class="uil uil-print"></i> Imprimer
                    </button>
                </div>
            </div>
        </div>
    </section>
    <script src="Scripts/abscence.js"></script>
    <script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.debug.js"></script>

    <script>
        function generatePDF() {
        var attestationSection = document.getElementById("attestation");

        // Use html2canvas to capture the section as an image with a higher scale for higher resolution
        html2canvas(attestationSection, { scale: 3 }) // Increase scale for higher resolution
            .then(function (canvas) {
                // Create a new jsPDF instance with A4 dimensions
                var doc = new jsPDF("p", "mm", "a4");

                // Calculate the aspect ratio to fit the image on the page
                var imgWidth = doc.internal.pageSize.getWidth();
                var imgHeight = (canvas.height * imgWidth) / canvas.width;

                // Calculate the center position
                var xPos = (doc.internal.pageSize.getWidth() - imgWidth) / 2;
                var yPos = (doc.internal.pageSize.getHeight() - imgHeight) / 2;

                // Add the captured image to the PDF
                doc.addImage(canvas.toDataURL("image/png"), "PNG", xPos, yPos, imgWidth, imgHeight);

                // Save the PDF
                doc.save('attestation.pdf');
            });
    }
    </script>

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
        } else if (userType == 'Cadre') {
            btnCompte.style.display = 'none';
        } else {
            console.log("User type not recognized");
        }
    </script>

</body>
</html>