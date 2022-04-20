import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Timer;
import javax.swing.*;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.sql.*;
import java.util.ArrayList;

public class SkillsServer {
	String x1;
	String x2;
	String x3;
	String x4;
	String x5;
	String x6;
	String x7;

	private ArrayList<String> myList = new ArrayList<String>();


	private int port = 12345;
	private ServerSocket serverSocket;
	// URL of DB server and authentication string
	static final String dbURL = "jdbc:mysql://localhost:3306/libraryManagementSystem?" + "user=root & password=mysql";
	// In the constructor, load the Java driver for the MySQL DB server
	// to enable this program to communicate with the database

	public SkillsServer() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

	}

	public void acceptConnections() {
		try {
			// similar to the WelcomeSocket in the PowerPoint slides
			serverSocket = new ServerSocket(port);

		} catch (IOException e) {
			System.err.println("ServerSocket instantiation failure");
			e.printStackTrace();
			System.exit(0);
		}
		// Entering the infinite loop
		while (true) { // we are waiting for the connection here
			try {
				// wait for a TCP handshake initialization (arrival of a "SYN" packet)
				Socket newConnection = serverSocket.accept();
				System.out.println("accepted connection");

				// Now, pass the connection socket created above to a thread and run it in it
				// First create the thread and pass the connection socket to it
				// This is a non-blocking function: constructor of the class

				ServerThread st = new ServerThread(newConnection);
				// Then, start the thread, and go back to waiting for another TCP connection
				// This also is not blocking
				new Thread(st).start();
			} catch (IOException ioe) {
				System.err.println("server accept failed");
			}
		}
	}

	public static void main(String args[]) {

		SkillsServer server = null;
		try {
			// Instantiate an object of this class. This will load the JDBC // database
			// driver
			server = new SkillsServer();

		} catch (ClassNotFoundException e) {
			System.out.println("unable to load JDBC driver");
			e.printStackTrace();
			System.exit(1);
		}

		// call this function, which will start it all...
		server.acceptConnections();

	}
	// Internal class
	class ServerThread implements Runnable {

		private Socket socket;
		private ObjectInputStream datain;
		private DataOutputStream dataout;
		String clientID;
		String Answer;

		public ServerThread(Socket socket) {
			// Inside the constructor: store the passed object in the data member
			this.socket = socket;
		}

//This is where you place the code you want to run in a thread
//Every instance of a ServerThread will handle one client (TCP connection)

		public void run() {
			try {

//Input and output streams, obtained from the member socket object
				datain = new ObjectInputStream(socket.getInputStream());
				dataout = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			} catch (IOException e) {
				return;
			}
 // byte[] ba = new byte[100];
			boolean conversationActive = true;

			while (conversationActive) {

		//		myList.clear(); // initiating
				try {
//read from the input stream buffer (read a message from client)
					myList.removeAll(myList); 
					myList = (ArrayList<String>) datain.readObject();
					System.out.println(myList.toString());

					x1 = myList.get(0);  
					
			//		x2 = myList.get(1);//common for all functions
				
					
/////////////////////////////////////Recieved input from client/////////////////////////////////////////////
					
					
					// Exit when a "Q" is received from a client
					if (x1.toUpperCase().charAt(0) == 'Q'
							) {
						conversationActive = false;
					} else {
						System.out.println(x1);
						if (x1.equalsIgnoreCase("Getname")) {

							System.out.println("Checking if entry Username  = " + x2 + " & Password " + x3
									+ " are already registered");
							Answer =	getNames(x3);
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);

						}

						else if (x1.equalsIgnoreCase("Signup")) {
							x2 = myList.get(1);
							x3 = myList.get(2);
							x4 = myList.get(3);
							x5 = myList.get(4);
							x6 = myList.get(5);
							x7 = myList.get(6);
							
						Answer =	Signup( x2, x3, x4, x5, x6, x7);
						Answer = Answer; //so that jtable knows where the ending is
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
						}
						else if (x1.equalsIgnoreCase("ValidLogin")) {
							x2 = myList.get(1);
							x3 = myList.get(2);
							x4= myList.get(3);
						Answer=	ValidLogin(x2, x3,x4);
						 //so that jtable knows where the ending is
								PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
						}

						else if (x1.equalsIgnoreCase("GetCategory")) {
							x2 = myList.get(1);
							x3=myList.get(2);
							Answer= Displaycategory(x2,x3);
							Answer = Answer +"FINISH_Answer#"; //so that jtable knows where the ending is
							System.out.println(Answer);//2
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer); //where are u sending to client
							System.out.println(Answer);//3
						}
						else if (x1.equalsIgnoreCase("Reserve")) {
							x2 = myList.get(1);
							x3 = myList.get(2);
							x4 = myList.get(3);
							Answer = Reserve(x2,x3,x4);
							Answer = Answer; //so that jtable knows where the ending is
						PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
						}
						
						else if (x1.equalsIgnoreCase("SearchbyTitle")) {
							x2 = myList.get(1);
							x3 = myList.get(2);
							Answer = SearchbyTitle(x2,x3);
							Answer = Answer +"FINISH_Answer"; // so that jtable knows where the ending is
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
							}
						else if (x1.equalsIgnoreCase("SearchbyAuthor")) {
							x2 = myList.get(1);
							x3 = myList.get(2);
							Answer = SearchbyAuthor(x2,x3);
							Answer = Answer +"FINISH_Answer";//so that jtable knows where the ending is
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
						}
						else if (x1.equalsIgnoreCase("ViewBook2")) {
						
							Answer = vBooks2();
							Answer = Answer +"FINISH_Answer";//so that jtable knows where the ending is
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
						}
						else if (x1.equalsIgnoreCase("request")) {
							x2 = myList.get(1);
							x3 = myList.get(2);
							//x4 = myList.get(3);
							Answer = RequestBook(x2,x3);
							
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
							
							
						}
						
						else if (x1.equalsIgnoreCase("ViewHistory")) {
						//	x2 = myList.get(1);
							Answer = viewHistory();
							System.out.println(Answer);
							Answer = Answer +"FINISH_Answer";
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
							
							
							
						}
						else if (x1.equalsIgnoreCase("ViewReserves")) {
							x2 = myList.get(1);
						
							Answer = ViewReserves(x2);
							Answer = Answer +"FINISH_Answer";
							PrintWriter sendtoclient = new PrintWriter(socket.getOutputStream(), true);
							sendtoclient.println(Answer);
							
							
							
						}
	//////////////////////RETURN TO CLIENT THE RESULTS//////////////////////////////////////////////
						
						
						
	////////////////////////////////////////////////////////////////////////////////////////////////////					
						
						// dataout.write(names.getBytes(),0,names.length());
						// dataout.write("\\n".getBytes(),0,1);
						// dataout.flush(); 
					}
				} catch (IOException ioe) {
					conversationActive = false;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				System.out.println("closing socket");
				datain.close();
				dataout.close();
				// When the server receives a "Q", we arrive here
				socket.close();
			} catch (IOException e) {
			}
		}
/////////////////////////////////GETNAMES////////////////////////////////////////////////////
		private String getNames(String Password) {
			String result = "None available";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbURL);

				Statement statemet = conn.createStatement(); ///////
				String query = "SELECT LastNname, FirstName " + "FROM client " + "WHERE Password = " + "'"
						+ Password.trim() + "'" + " ORDER BY FN";
				System.out.println("query = " + query);
				ResultSet results = statemet.executeQuery(query);
				StringBuffer stringb = new StringBuffer();

				while (results.next()) {
					stringb.append(results.getString(1));
					stringb.append(", ");
					stringb.append(results.getString(2));
					stringb.append(',');
				}
				result = stringb.toString();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				result = "server error";
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
			return result;
		}
		//////////////////////////////LOGIN OFFICIALLY DONNEEEEEE//////////////////////////////////////////////////
		private String ValidLogin(String x2, String x3,String x4) { // to check if pass is correct
			String userr_name = x2;
			String Pass = x3;
			String CorrectPassword=null;
			String IssueDate= x4;

			String result = "None available";

			Connection conn = null;
			try {

				conn = DriverManager.getConnection(dbURL);

				Statement statemet = conn.createStatement(); ///////
				String query = "SELECT Password,UserID " + "FROM client " + "WHERE Username = " + "'" + userr_name + "'"
						+ "ORDER BY Password";

				System.out.println("query = " + query);
				ResultSet results = statemet.executeQuery(query);
				// results have the password of the username given

				StringBuffer stringb = new StringBuffer();

				while (results.next()) {
					CorrectPassword=results.getString(1);
					stringb.append(results.getString(1));
					stringb.append(", ");

					clientID = results.getString(2);
					System.out.println(clientID);
					stringb.append(results.getString(2));
					stringb.append('$');

				}
				if (!(clientID==null) && CorrectPassword.contentEquals(Pass)) {
				
				System.out.println(clientID);

				String ACT = "Logged In";
				String query2 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + ACT + "'" + "," + "'" + IssueDate + "'" + ")";
				statemet.executeUpdate(query2);
				System.out.println(query2);}
			
				

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				result = "server error";
			} finally {

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
			if (clientID==null)
				return "not a user";
			System.out.println(Pass);
			if (CorrectPassword.equals(Pass)) {
				return "Succesfull login";
			} else {
				return "Invalid Username or Password";
			}

		}
///////////////////////////////////////SIGNUP OFFICIALLY     DONE////////////////////////////////////////
		private String Signup(String x2,String x3,String x4,String x5,String x6,String x7) {
			// String userID=x2;
			String FirstName = x2;
			String LastName = x3;
			String User = x4;
			String DOB = x5;
			String Pass = x6;
			String result = "None available";
			String ACT = "First Became A Member";
			String IssueDate =x7;
			

			Connection conn = null;
			try {

				conn = DriverManager.getConnection(dbURL);

				Statement statemet = conn.createStatement(); ///////

				String query = "INSERT INTO client VALUES (NULL, " + "'" + FirstName + "'" + "," + "'" + LastName + "'"
						+ "," + "'" + User + "'" + "," + "'" + DOB + "'" + "," + "'" + Pass + "'" + ")";
				// adding into table
				statemet.executeUpdate(query);
				System.out.println("Table has been updated");
				result= "Table has been updated";
				
				String query1 = "SELECT UserID " + "FROM client " + "WHERE Username = " + "'" + User + "'" ;
				System.out.println(query1);
				ResultSet results = statemet.executeQuery(query1);
				// results have the password of the username given

				StringBuffer stringb = new StringBuffer();

				while (results.next()) {
					stringb.append(results.getString(1));
					clientID=results.getString(1);
					stringb.append(", ");

				}
				
						
				String query2 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + ACT + "'" + "," + "'" + IssueDate + "'" + ")";
				statemet.executeUpdate(query2);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				result = "server error";
				
			} finally {

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
return result;
		}
		
		
		//////////////////////////////Category Officially DONE///////////////////////////////////////////////

		private String Displaycategory(String Category,String x3) {
		
			String Category1 = x2;
		//String clientID = "2";
			String result = "None Available";
			String IssueDate =x3;

			Connection conn = null;
			try {

				conn = DriverManager.getConnection(dbURL);

				Statement statemet = conn.createStatement(); ///////

				String query = "SELECT bookTitle, Authorsname, publisher, status, bookprice " + "FROM books " + "INNER JOIN" +" " +"categories "
						+ "USING " + "(categorieID) " + "WHERE categorieName = " + "'" + Category + "'"
						+ " ORDER BY bookTitle";
				
				System.out.println("query = " + query);
				System.out.println(clientID);

				ResultSet results = statemet.executeQuery(query);
			

				StringBuffer stringb = new StringBuffer();

				while (results.next()) {
					stringb.append(results.getString(1)); // get bookTitle
					stringb.append(',');
					stringb.append(results.getString(2));// Get authrosname
					stringb.append(',');
					stringb.append(results.getString(3));// get publisher
					stringb.append(',');
					stringb.append(results.getString(4)); // get status
					stringb.append(',');
					stringb.append(results.getString(5)); // get bookprice
					stringb.append(',');
					stringb.append('#');

				} 
				
				result = stringb.toString(); // change to string
				System.out.println(result);
				String Act = "Searched for books with Category:" + Category;
			String query4 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + Act + "'" + "," + "'" + IssueDate + "'" + ")";
			 statemet.executeUpdate(query4);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				result = "server error";
			} finally {

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
			return result;

		}
		
		
		/////////////////////////////////////Reserve OFFICIALLY DONEEEE///////////////////////////////////////////

		private String Reserve(String x2,String x3, String x4) {
		//	clientID="8";
			String bookTitle = x2;
			String bookID = null;
			String IssueDate = x3;
			String returnDate = x4;
		String Act = "Reserved : ";
			String result = "None Available";
			Connection conn = null;
			String Status = null;
			
			try {

				conn = DriverManager.getConnection(dbURL);

				Statement statemet = conn.createStatement(); ///////
				System.out.println(bookTitle);
				
				String query3 = "SELECT status from books where bookTitle= '" + bookTitle +"'"; 
				
				
				ResultSet results2 = statemet.executeQuery(query3);
				 
				 StringBuffer stringb2 = new StringBuffer();
				 
					while (results2.next()) {
						stringb2.append(results2.getString(1));
						 Status = results2.getString(1);			// get status
						stringb2.append(", ");}
					
					
					System.out.println(Status); //debugging
					
				
				
				String query1 = "SELECT bookID from books where bookTitle= '" + bookTitle+"'";//to search by book title
				
				 ResultSet results = statemet.executeQuery(query1);//got book iD from booktable
				 
				 StringBuffer stringb = new StringBuffer();
				 
					while (results.next()) {
						stringb.append(results.getString(1));
						bookID = results.getString(1);			// get bookID
						stringb.append(", ");}
					
					
					System.out.println(bookID);//debugging
					
					if ( !Status.equals("Reserved")) {
					
				
				 
				String query = "INSERT INTO reserves VALUES (" + "'" + bookID+ "'" + "," + "'" + clientID + "'" + "," + "'" + IssueDate + "'"
						+ "," + "'" + returnDate + "'" + ")";	
				System.out.println("query = " + query);
			
				 statemet.executeUpdate(query);
				 
				 
				 
				 
				String query2 = "UPDATE books SET status = 'Reserved' WHERE bookID = " + bookID;
				System.out.println("query = " + query2);
					
				 statemet.executeUpdate(query2);
					 
					 
				 result ="Success";
				 
				 }
					
					else {
						
						result = "Already reserved";
						
					}
			
				
				
System.out.println(result);
			
			Act = Act + bookTitle;
			String query4 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + Act + "'" + "," + "'" + IssueDate + "'" + ")";
			 statemet.executeUpdate(query4);
			 
				
					

			//		System.out.println("Table has been updated");
					
				
					
					} catch (SQLException e) {
				System.out.println(e.getMessage());
				result = "server error";
			} finally {

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
return result;
		}
			

	
	
	
	
	
	
	//////////////////////////////////SEARCH    by title Officially    DONE/////////////////////////////////////////////////////
	
	private String SearchbyTitle(String x2,String x3) {
		
		String bookTitle = x2;
	//	String clientID = "7";
	String IssueDate = x3;
		String Act = "Searched For : "+ bookTitle;
		String result = "None Available";
		Connection conn = null;
		
		
		try {

			conn = DriverManager.getConnection(dbURL);

			Statement statemet = conn.createStatement(); ///////


			String query = "SELECT bookTitle, Authorsname, publisher, status, bookprice, categorieName " + "FROM books " + "INNER JOIN" +" " +"categories "
					+ "USING " + "(categorieID)  WHERE bookTitle LIKE "  + "'%"+ bookTitle +"%" + "'"
					+ "ORDER BY bookTitle";
			
			ResultSet results = statemet.executeQuery(query);
		
		
			

			StringBuffer stringb = new StringBuffer();

			while (results.next()) {
				stringb.append(results.getString(1)); // get bookTitle
stringb.append(',');
stringb.append(results.getString(2));// Get authrosname
stringb.append(',');
stringb.append(results.getString(3));// get publisher
stringb.append(',');
stringb.append(results.getString(4)); // get status
stringb.append(',');
stringb.append(results.getString(5)); // get bookprice
stringb.append(',');
stringb.append(results.getString(6)); // categorieName
stringb.append(',');
stringb.append('#');


			}
			result = stringb.toString(); // change to string 
			
		
			String query2 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + Act + "'" + "," + "'" + IssueDate + "'" + ")";
			 statemet.executeUpdate(query2);
			
			System.out.println("Table has been updated");
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			result = "server error";
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;

	}
	
	/////////////////////////////////Search BY Author Officialy DONE///////////////////////////////////////////

private String SearchbyAuthor(String x2,String x3) {
	String Authorname = x2;
	//String clientID="5";
	String IssueDate=x3;
	String Act = "searched For Books By: "+ Authorname;


String result = "None Available";
Connection conn = null;

try {

conn = DriverManager.getConnection(dbURL);

Statement statemet = conn.createStatement(); ///////

String query = "SELECT bookTitle, Authorsname, publisher, status, bookprice, categorieName " + "FROM books " + "INNER JOIN" +" " +"categories "
		+ "USING " + "(categorieID)  WHERE Authorsname LIKE "  + "'%"+ Authorname +"%" + "'"
		+ "ORDER BY bookTitle";

System.out.println("query = " + query);

ResultSet results = statemet.executeQuery(query);



StringBuffer stringb = new StringBuffer();

	while (results.next()) {
stringb.append(results.getString(1)); // get bookTitle
stringb.append(',');
stringb.append(results.getString(2));// Get authrosname
stringb.append(',');
stringb.append(results.getString(3));// get publisher
stringb.append(',');
stringb.append(results.getString(4)); // get status
stringb.append(',');
stringb.append(results.getString(5)); // get bookprice
stringb.append(',');
stringb.append(results.getString(6)); // categorieName
stringb.append(',');
stringb.append('#');



}
result = stringb.toString(); // change to string */


String query2 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + Act + "'" + "," + "'" + IssueDate + "'" + ")";
 statemet.executeUpdate(query2);

System.out.println("Table has been updated");
//result= "Table has been updated";

} catch (SQLException e) {
System.out.println(e.getMessage());
result = "server error";
} finally {
	

if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
}
}
}
return result;
}


//////////////////////////////////REQUEST OFFICIALLY DONEEEEEE///////////////////////////////

private String RequestBook(String x2, String x3) {

String Act = "Requested : ";
String RequestDate = x3;
String bookTitle = x2;
//String clientID="3";
String Book2ID=null;

//String bookTitle=x5;
 String result = "None Available";
Connection conn = null;

try {

conn = DriverManager.getConnection(dbURL);

Statement statemet = conn.createStatement(); ///////


String query1 = "SELECT bookID_2 FROM library_2 WHERE bookTitle_2 = "+ "'" + bookTitle + "'";




ResultSet results = statemet.executeQuery(query1);

StringBuffer stringb = new StringBuffer();

while (results.next()) {
	Book2ID= results.getString(1);
	stringb.append(results.getString(1)); // get bookID2
	stringb.append(',');
}



String query = "INSERT INTO requests VALUES (NULL," + "'" + RequestDate + "'" + "," + "'" + Book2ID + "'" + "," + "'" + clientID +
	 "'" + ")";
System.out.println("query = " + query);

statemet.executeUpdate(query);




Act = "Requested : " + bookTitle + " from another library";

String query2 = "INSERT INTO history VALUES (" + "'" + clientID + "'" + "," + "'" + Act + "'" + "," + "'" + RequestDate + "'" + ")";
 statemet.executeUpdate(query2);

System.out.println("Table has been updated");
result= "Table has been updated";


} catch (SQLException e) {
System.out.println(e.getMessage());
result = "server error";
} finally {

if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
}
}
}
return result;
}


	///////////////////////////////////////////////VIEW HISTORY DONEEEEEEE////////////////////////////////////////////////////////////////////////
	
	
	//String query = "SELECT Password,UserID " + "FROM client " + "WHERE Username = " + "'" + userr_name + "'"
	//		+ "ORDER BY Password";
	private String viewHistory() {
		System.out.println("test");

	//String clientID = x2;
		String result = "None Available";

		Connection conn = null;
		try {

			conn = DriverManager.getConnection(dbURL);

			Statement statemet = conn.createStatement(); ///////

			String query = "SELECT Act, Date " + "FROM history " +  "WHERE UserID = " + "'" + clientID + "'"
					;
			
			System.out.println("query = " + query);

			ResultSet results = statemet.executeQuery(query);

			StringBuffer stringb = new StringBuffer();

			while (results.next()) {
				stringb.append(results.getString(1)); // get Act
				stringb.append(',');
				stringb.append(results.getString(2));// Get date
				stringb.append(',');
				stringb.append('#');
			
			}
			
			result = stringb.toString(); // change to string
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			result = "server error";
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;

	}
	//////////////////////////////////////////DisplayLibrary2Books/////////////////////////////////////////////
	private String vBooks2() {
		

	//String clientID = x2;
		String result = "None Available";

		Connection conn = null;
		try {

			conn = DriverManager.getConnection(dbURL);

			Statement statemet = conn.createStatement(); ///////

			String query = "SELECT * FROM library_2";
			
			System.out.println("query = " + query);

			ResultSet results = statemet.executeQuery(query);

			StringBuffer stringb = new StringBuffer();

			while (results.next()) {
				stringb.append(results.getString(2)); // get Title
				stringb.append(',');
				stringb.append(results.getString(3));// Get Author
				stringb.append(',');
				stringb.append(results.getString(4));// Get Publisher
				stringb.append(',');
				stringb.append('#');
			
			}
			
			result = stringb.toString(); // change to string
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			result = "server error";
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;

	}
	
	
	
	//////////////////////////////////////////////VIEW Officaly done RESERVES/////////////////////////////////////////////////////////////
	private String ViewReserves(String x2) {


	//	String clientID = x2;
		String result = "None Available";
		String ACT = "Viewed his/her reservations";
		String IssueDate = x2;

		Connection conn = null;
		try {

			conn = DriverManager.getConnection(dbURL);

			Statement statemet = conn.createStatement(); ///////

			String query = "SELECT b.bookTitle,b.AuthorsName,b.publisher,b.bookPrice,c.categorieName from reserves r,books b,categories c where r.UserID= " + clientID +" and r.bookID=b.bookID and c.categorieID=b.categorieID";
			
			System.out.println("query = " + query);

			ResultSet results = statemet.executeQuery(query);

			StringBuffer stringb = new StringBuffer();

			while (results.next()) {
				stringb.append(results.getString(1)); // get bookTitle
				stringb.append(',');
				stringb.append(results.getString(2));// Get authrosname
				stringb.append(',');
				stringb.append(results.getString(3));// get publisher
				stringb.append(',');
				stringb.append(results.getString(4)); // get status
				stringb.append(',');
				stringb.append(results.getString(5)); // get bookprice
				stringb.append(',');
				stringb.append('#');

			}
			
			result = stringb.toString(); // change to string
			System.out.println(result);
		
		
		String query2 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + ACT + "'" + "," + "'" + IssueDate + "'" + ")";
			 statemet.executeUpdate(query2);
			
			System.out.println("Table has been updated");
		//	result= "Table has been updated";
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			result = "server error";
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;

	}
	}
	
	
	
	
	
	
	

}


//////////////////////////////////////////////////////////////

/*private String ADDBook(String x2, String x3, String x4,String x5, String x6) {//if we have time,do login as admin

//String Act = "added : ";
String bookTitle = x2;
String AuthorName = x3;
String categorieName =x4;
String publisher = x5;
String Price = x6;
String Status="Available";
 String result = "None Available";
Connection conn = null;

try {

conn = DriverManager.getConnection(dbURL);

Statement statemet = conn.createStatement(); ///////

String query = 

String query1 = "INSERT INTO books VALUES (NULL," + "'" +bookTitle + "'" + "," + "'" + AuthorName + "'" + "," + "'" + publisher +"'"+ "," + "'" + Status+"'"+ "," + "'" +categorieID+"'"+ "," + "'" +Price)";
System.out.println("query = " + query);

statemet.executeUpdate(query);



StringBuffer stringb = new StringBuffer();

/*	while (results.next()) {
stringb.append(results.getString(1)); // get bookTitle
bookTitle= results.getString(1);// get bookTitle
stringb.append(", ");
stringb.append(results.getString(2));// Get authrosname
stringb.append(',');
stringb.append(results.getString(3));// get publisher
stringb.append(',');
stringb.append(results.getString(4)); // get status
stringb.append(',');
stringb.append(results.getString(5)); // get bookprice
stringb.append(',');
stringb.append(results.getString(6)); // categorieName
stringb.append(',');





//Act = Act
//String query2 = "INSERT INTO history VALUES (" + "'" + clientID+ "'" + "," + "'" + Act + "'" + "," + "'" + IssueDate + "'" + ")";
 //statemet.executeUpdate(query2);

System.out.println("Table has been updated");
result= "Table has been updated";


} catch (SQLException e) {
System.out.println(e.getMessage());
result = "server error";
} finally {

if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
}
}
}
return result;
}

}
	
*/


























