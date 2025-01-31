
document.addEventListener("DOMContentLoaded", function() {
	// Sayfa yüklendiğinde çalışacak kod
	connectSocket();
});

function connectSocket() {
   const socket = new WebSocket("ws://localhost:5000");

   socket.onopen = function() {
       console.log("✅ WebSocket bağlantısı açıldı!");
   };

   socket.onmessage = function(event) {
       console.log("📩 Sunucudan mesaj:", event.data);
       conditionalRender(event.data);
   };

   socket.onclose = function() {
       console.log("❌ Bağlantı kapandı.");
   };

   socket.onerror = function(error) {
       console.error("❌ WebSocket hatası:", error);
   };

}

function conditionalRender (Role) {

    if (Role === 'Staff') {

        var panel = document.getElementById('Panel');
        var incomes = document.getElementById('Incomes');
        var users = document.getElementById('Users');
        var logs = document.getElementById('Logs');
        var occupancy = document.getElementById('Occupancy');

        incomes.remove();
        users.remove();
        logs.remove();
        occupancy.remove();
        panel.innerText = 'Staff Panel';

    } else {

        var incomes = document.getElementById('showIncomes');
        var users = document.getElementById('showUsers');
        var logs = document.getElementById('showLogs');
        var occupancy = document.getElementById('showOccupancy');

        incomes.style.display = "block";
        users.style.display = "block";
        logs.style.display = "block";
        occupancy.style.display = "block";

    }

}