$(document).ready(function() {
    $('#dataTable').DataTable({
        scrollX: true, // Yatay kaydırma
        autoWidth: false, // Sütun genişliklerini manuel kontrol etmenizi sağlar
        columnDefs: [{
                width: "10%",
                targets: 0
            }, // ID
            {
                width: "20%",
                targets: 1
            }, // Name
            {
                width: "30%",
                targets: 2
            }, // Email
            {
                width: "15%",
                targets: 3
            }, // Age
            {
                width: "15%",
                targets: 4
            }, // Status
            {
                width: "10%",
                targets: 5
            } // Actions
        ]
    });
});
$(document).ready(function() {
    $('#dataTable').DataTable({
        autoWidth: false, // Otomatik genişlik hesaplamayı devre dışı bırakır
        columnDefs: [{
                width: "10%",
                targets: 0
            }, // ID
            {
                width: "20%",
                targets: 1
            }, // Name
            {
                width: "30%",
                targets: 2
            }, // Email
            {
                width: "15%",
                targets: 3
            }, // Age
            {
                width: "15%",
                targets: 4
            }, // Status
            {
                width: "10%",
                targets: 5
            } // Actions
        ],
        scrollX: true // Yatay kaydırma
    });
});