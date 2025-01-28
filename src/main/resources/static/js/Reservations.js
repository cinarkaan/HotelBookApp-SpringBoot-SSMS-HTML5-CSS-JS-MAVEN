$(document)
	.ready(function() {

		$('#showReservationDetails')
			.on('click', function(event) {
				event.preventDefault();
				showReservationsTable();
			});

		function showReservationsTable() {
			$.ajax({
				url: '/api/customers/reservations', // user tablosunu alacak endpoint
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
						tableHeader.append('<th>Actions</th>'); // Action (Edit/Delete) sütunu

						// Tablo satırlarını oluştur
						data.forEach(row => {
							const rowElement = $('<tr></tr>');
							Object.values(row)
								.forEach(value => {
									rowElement.append(`<td>${value}</td>`);
								});
							rowElement.append(`
                                                    <td>
                                                        <button class="btn btn-success btn-sm approvalBtn"
                                                        data-id="${row.rezervasyonID}"
                                                        data-room="${row.odaID}"
                                                        data-status="${row.durum}"
                                                        data-payment="${row.odemeDurumu}"
                                                        >Approve</button>
                                                        <button class="btn btn-dark btn-sm rejectBtn"
                                                        data-id="${row.rezervasyonID}"
                                                        data-status="${row.durum}"
                                                        >Reject</button>
                                                    </td>`);

							tableBody.append(rowElement);
						});
						$('.approvalBtn')
							.on('click', function() {
								const ID = $(this)
									.data('id');
								const rID = $(this)
									.data('room');
								$('#ApproveModal')
									.modal('show');
								$('#ApproveApplication')
									.off('click')
									.on('click', function() {
										ApproveCustomer(ID, rID);
										$('#ApproveModal')
											.modal('hide');
									});
							});
						$('.rejectBtn')
							.on('click', function() {
								const ID = $(this)
									.data('id');
								$('#RejectModal')
									.modal('show');
								$('#RejectApplication')
									.off('click')
									.on('click', function() {
										RejectCustomer(ID);
										$('#RejectModal')
											.modal('hide');
									});
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

		function ApproveCustomer(ID, rID) {
			const room = rID;
			const updateData = {
				odaID: parseInt(room)
				, durum: 'Onaylandı'
				, odemeDurumu: 'Ödendi'
			};
			$.ajax({
				url: `/api/customers/${ID}`, // Backend endpoint
				type: 'PUT', // HTTP metodu
				contentType: 'application/json'
				, data: JSON.stringify(updateData)
				, success: function(response) {
					alert('Reservation has been approved as successfully!');
					$('#ApproveModal')
						.modal('hide');
					showReservationsTable(); // Tabloyu güncelle
				}
				, error: function() {
					alert('Error updating reservation.');
				}
			});
		}

		function RejectCustomer(ID) {
			const updateData = {
				durum: 'İptal Edildi'
				, odemeDurumu: 'Ödenmedi'
			};
			$.ajax({
				url: `/api/customers/${ID}`, // Backend endpoint
				type: 'PUT', // HTTP metodu
				contentType: 'application/json'
				, data: JSON.stringify(updateData)
				, success: function(response) {
					alert('Reservation has been rejected as successfully!');
					$('#RejectModal')
						.modal('hide');
					showReservationsTable(); // Tabloyu güncelle
				}
				, error: function() {
					alert('Error updating user.');
				}
			});
		}
	});