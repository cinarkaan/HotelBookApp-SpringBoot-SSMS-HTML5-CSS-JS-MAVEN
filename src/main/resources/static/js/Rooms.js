$(document)
	.ready(function() {
		$('#showRooms')
			.on('click', function(event) {
				event.preventDefault();
				showRoomTable();
			});

		function showRoomTable() {
			$.ajax({
				url: '/api/rooms/', // user tablosunu alacak endpoint
				method: 'GET'
				, success: function(data) {
					console.log('Veriler alındı:', data); // Verilerin console'da görünüp görünmediğini kontrol et

					const dataTable = $('#dataTable'); // id=dataTable kullanarak tabloyu referans alıyoruz
					const tableHeader = $('#tableHeader');
					const tableBody = $('#tableBody');

					// Önceki içerikleri temizle
					tableHeader.empty();
					tableBody.empty();

					// Veriler gelmişse
					if (data && data.length > 0) {
						// Tablo başlıklarını oluştur
						Object.keys(data[0])
							.forEach(key => {
								tableHeader.append(`<th>${key}</th>`);
							});

						// Tablo satırlarını oluştur
						data.forEach(row => {
							const rowElement = $('<tr></tr>');
							Object.values(row)
								.forEach(value => {
									rowElement.append(`<td>${value}</td>`);
								});
							tableBody.append(rowElement);
						});
					} else {
						tableBody.append('<tr><td colspan="100%">No data available</td></tr>'); // Veri yoksa uyarı
					}
				}
				, error: function(xhr, status, error) {
					console.error('Hata:', error); // Hata mesajını console'a yazdır
					alert('Error fetching data.');
				}
			});
		}
	});