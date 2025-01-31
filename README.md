<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

 </head>

 <body>
  <h1>Hotel Reservation System</h1>
  <p> This project is designed to manage a hotel reservation system. The system allows users to book reservations, manage customer information, and handle hotel rooms. It is developed using modern technologies and provides a user-friendly interface. </p>
  <h2>Features</h2>
  <ul>
   <li>User registration and management</li>
   <li>Hotel room listing and management</li>
   <li>Reservation operations (add, update, delete)</li>
   <li>Dynamic content management using data stored in the database</li>
   <li>AJAX functionality to handle requests without refreshing the page</li>
   <li>Responsive design for mobile compatibility</li>
  </ul>
  <h2>Technologies Used</h2>
  <ul>
   <li>
    <b>Java 17:</b> For backend development
   </li>
   <li>
    <b>Spring Boot:</b> A framework for modern Java applications
   </li>
   <li>
    <b>Maven:</b> For dependency management and project configuration
   </li>
   <li>
    <b>SSMS (SQL Server Management Studio):</b> For database operations
   </li>
   <li>
    <b>HTML5 and CSS3:</b> For user interface design
   </li>
   <li>
    <b>Bootstrap 5:</b> For responsive and modern UI
   </li>
   <li>
    <b>JavaScript:</b> For dynamic content and operations
   </li>
   <li>
    <b>AJAX:</b> For asynchronous requests
   </li>  
   <li>
    <b>WebSocket:</b> To make authorization
   </li>
  </ul>
  <h2>Installation Instructions</h2>
  <h3>1. Clone the Project</h3>
  <pre>
					<code>
git clone https://github.com/&lt;your-username&gt;/&lt;project-name&gt;.git
cd &lt;project-name&gt;
        </code>
				</pre>
  <h3>2. Set Up the Database</h3>
  <p> Use <b>SSMS</b> to create your database and configure the tables as follows: </p>
  <ul>
   <li>
    <code>users</code> table (for user information)
   </li>
   <li>
    <code>rooms</code> table (for room information)
   </li>
   <li>
    <code>reservations</code> table (for reservations)
   </li>
  </ul>
  <p>Edit the <code>application.properties</code> file with your database credentials: </p>
  <pre>
					<code>
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=hotel_reservation
spring.datasource.username=&lt;username&gt;
spring.datasource.password=&lt;password&gt;
spring.jpa.hibernate.ddl-auto=update
        </code>
				</pre>
  <h3>3. Install Dependencies</h3>
  <pre>
					<code>mvn clean install</code>
				</pre>
  <h3>4. Run the Project</h3>
  <pre>
					<code>mvn spring-boot:run</code>
				</pre>
  <h3>5. Access the Application</h3>
  <p>Once the application is running, open your browser and navigate to:</p>
  <pre>
					<code>http://localhost:8080</code>
				</pre>
  <h2>The screenshots on the below of this page</h2>
  <p>1. Dashboard Page</p>
  <p>2. Reservation Page</p>
  <p>3. Room Management Page</p>
  <p>
   <i>Note:</i> You can add screenshots to the <code>images</code> folder and include them here using the <code>&lt;img&gt;</code> tag.
  </p>
  <h2>API Endpoints</h2>
  <table>
   <thead>
    <tr>
     <th>HTTP Method</th>
     <th>Endpoint</th>
     <th>Description</th>
    </tr>
   </thead>
   <tbody>
    <tr>
     <td>GET</td>
     <td>/dashboard</td>
     <td>Fetches the dashboard page</td>
    </tr>
    <tr>
     <td>POST</td>
     <td>/users/create</td>
     <td>Adds a new user</td>
    </tr>
    <tr>
     <td>PUT</td>
     <td>/users/update/{id}</td>
     <td>Updates an existing user</td>
    </tr>
    <tr>
     <td>DELETE</td>
     <td>/users/delete/{id}</td>
     <td>Deletes a user</td>
    </tr>
    <tr>
     <td>GET</td>
     <td>/rooms</td>
     <td>Lists all rooms</td>
    </tr>
    <tr>
     <td>POST</td>
     <td>/reservations/create</td>
     <td>Adds a new reservation</td>
    </tr>
   </tbody>
  </table>
  <h2>Contributing</h2>
  <p>To contribute to this project, follow these steps:</p>
  <ol>
   <li>Fork the repository</li>
   <li>Create a new branch: <code>git checkout -b feature/your-feature</code>
   </li>
   <li>Commit your changes: <code>git commit -m 'Add some feature'</code>
   </li>
   <li>Push to the branch: <code>git push origin feature/your-feature</code>
   </li>
   <li>Submit a pull request</li>
  </ol>
  <h2>License</h2>
  <p>This project is licensed under the MIT License. See the <code>LICENSE</code> file for details. </p>
	 <h3>To take a look all images that points the project please click on the following link</h3>
	 <a href="https://drive.google.com/drive/folders/1zWbNxrXG0MAGQw_B5_L2O6vGlTxqEGFH?usp=drive_link" target="_blank">Show Images</a>
	 <h3>To access ready database that was prepared before please click on the following link</h3>
	 <a href="https://drive.google.com/drive/folders/1Y9u0SkKRLskxKcjCP3kPqMiQuIh-NMCx?usp=sharing" target="_blank">DataBase</a>
	
 </body>
</html>
