const body = document.querySelector("body"),
      modeToggle = body.querySelector(".mode-toggle");
      sidebar = body.querySelector("nav");
      sidebarToggle = body.querySelector(".sidebar-toggle");

let getMode = localStorage.getItem("mode");
if(getMode && getMode ==="dark"){
    body.classList.toggle("dark");
}

let getStatus = localStorage.getItem("status");
if(getStatus && getStatus ==="close"){
    sidebar.classList.toggle("close");
}

modeToggle.addEventListener("click", () =>{
    body.classList.toggle("dark");
    if(body.classList.contains("dark")){
        localStorage.setItem("mode", "dark");
    }else{
        localStorage.setItem("mode", "light");
    }
});

sidebarToggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
    if(sidebar.classList.contains("close")){
        localStorage.setItem("status", "close");
    }else{
        localStorage.setItem("status", "open");
    }
})
document.getElementById('btn-ajouter').addEventListener('click', function() {
    
});

document.getElementById('btn-modifier').addEventListener('click', function() {
    
});

document.getElementById('btn-retour').addEventListener('click', function() {
    //redirect to index.jsp
    window.location.href = "http://localhost:8080/Projet_Stage_Front/index.jsp";
});




function updateTable() {
    $.ajax({
        url: 'http://localhost:8080/Projet_Stage_Front/AbscenceServlet?action=getAll',
        method: 'GET',
        success: function(response) {
            var tableContent = $(response).find('#tableContent').html();
            $('#tableContent').html(tableContent);
            console.log(response);
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
}


    

    
    


