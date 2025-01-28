$(document)
	.ready(function() {

		$('#showUsers')
			.on('click', function(event) {
				event.preventDefault();
				showUsersTable();
			});
		// User tablosunun verilerini al ve tabloyu güncelle
		function showUsersTable() {
			$.ajax({
				url: '/api/users/', // user tablosunu alacak endpoint
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
							// Edit ve Delete butonlarını ekle
							rowElement.append(`
                                                        <td>
                                                            <button class="btn btn-warning btn-sm editBtn"
                                                            data-id="${row.kullaniciID}"
                                                            data-userid="${row.kullaniciAdi}"
                                                            data-name="${row.adSoyad}"
                                                            data-email="${row.email	}"
                                                            data-password="${row.sifre}"
                                                            data-phone="${row.telefon}"
                                                            >
                                                            Edit
                                                            </button>
                                                            <button class="btn btn-danger btn-sm deleteBtn" data-id="${row.kullaniciID}">Delete</button>
                                                        </td>
                                                    `);
							tableBody.append(rowElement);
						});

						// Edit butonuna tıklandığında modal aç
						$('.editBtn')
							.on('click', function() {
								const ID = $(this)
									.data('id');
								const userId = $(this)
									.data('userid');
								const userName = $(this)
									.data('name');
								const userEmail = $(this)
									.data('email');
								const userPassword = $(this)
									.data('password');
								const userPhone = $(this)
									.data('phone');

								$('#editUserID')
									.val(userId);
								$('#editName')
									.val(userName);
								$('#editEmail')
									.val(userEmail);
								$('#editPassword')
									.val(userPassword);
								$('#editPhone')
									.val(userPhone);

								$('#editModal')
									.modal('show');
								$('#saveChanges')
									.off('click')
									.on('click', function() {
										updateUser(ID);
										$('#editModal')
											.modal('hide');
									});
							});

						// Delete butonuna tıklandığında modal aç
						$('.deleteBtn')
							.on('click', function() {
								const ID = $(this)
									.data('id');
								$('#deleteModal')
									.modal('show');
								$('#deleteUser')
									.off('click')
									.on('click', function() {
										deleteUser(ID);
										$('#deleteModal')
											.modal('hide');
									});
							});
					} else {
						tableBody.append('<tr><td colspan="100%">No data available</td></tr>'); // Veri yoksa uyarı
					}
				}
				, error: function() {
					alert('Error fetching data.');
				}
			});
		}

		// Kullanıcıyı silme işlemi
		function deleteUser(ID) {
			$.ajax({
				url: `/api/users/${ID}`
				, method: 'DELETE'
				, success: function() {
					alert('User deleted successfully');
					$('#deleteModal')
						.modal('hide');
					showUsersTable(); // Tabloyu güncelle
				}
				, error: function() {
					alert('Error deleting user.');
				}
			});
		}

		function updateUser(ID) {
			const userId = $('#editUserID')
				.val();
			const userName = $('#editName')
				.val();
			const userEmail = $('#editEmail')
				.val();
			const userPassword = $('#editPassword')
				.val();
			const userPhone = $('#editPhone')
				.val();

			const updateData = {
				kullaniciAdi: userId
				, adSoyad: userName
				, email: userEmail
				, sifre: userPassword
				, telefon: parseInt(userPhone)
			};

			$.ajax({
				url: `/api/users/${ID}`, // Backend endpoint
				type: 'PUT', // HTTP metodu
				contentType: 'application/json'
				, data: JSON.stringify(updateData)
				, success: function(response) {
					alert('User updated successfully!');
					$('#editModal')
						.modal('hide');
					showUsersTable(); // Tabloyu güncelle
				}
				, error: function() {
					alert('Error updating user.');
				}
			});
		}
	});