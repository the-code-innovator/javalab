import java.sql.*;

public class JDBC{
	public static void main(String args[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root","123456");
			Statement statement = connection.createStatement();
			// statement.execute("insert into student values(5,"Raja");");
			ResultSet resultset = statement.executeQuery("select * from student;");
			while(resultset.next()){
				System.out.println(resultset.getInt(1) + "  " + resultset.getString(2));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
