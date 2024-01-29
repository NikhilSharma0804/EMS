import java.sql.*;

public class Conn {
       Statement s;
	{

	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?createDatabaseIfNotExist=true","root",
				"mysql");

            s = c.createStatement();
          	
         
	}

	catch(
	Exception e)
	{
	}
}
	
}
