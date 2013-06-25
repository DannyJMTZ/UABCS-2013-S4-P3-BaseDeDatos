import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	
	public static void main(String[] args) {
		
		try { Class.forName( "com.mysql.jdbc.Driver" ).newInstance(); }
		catch ( Exception e) {}
		
		try {
			
			Connection connector = DriverManager.getConnection( "jdbc:mysql://localhost/car_seller" , "root" , "root" ); 
			Statement statement = connector.createStatement();
			ResultSet resultSet = statement.executeQuery( "SELECT * FROM client" );
			
			System.out.println("Client Table");
			while( resultSet.next() ){
				
				System.out.print( resultSet.getInt( "id_client" ) + "\t" );
				System.out.print( resultSet.getString( "name" ) + "\t" );
				System.out.print( resultSet.getString( "phone" ) );
				System.out.println( );
				
			}
			
			resultSet = statement.executeQuery( "SELECT * FROM car" );
			System.out.println("*********************************");
			System.out.println("Car Table");
			while( resultSet.next() ){
				
				System.out.print( resultSet.getInt( "id_car" ) + "\t" );
				System.out.print( resultSet.getString( "brand" ) + "\t" );
				System.out.print( resultSet.getString( "model" ) + "\t" );
				System.out.print( resultSet.getInt( "year" ) + "\t" );
				System.out.print( resultSet.getString( "colour" ) );
				System.out.println( );
				
			}
			
			resultSet = statement.executeQuery( 
					"SELECT client.id_client , client.name, client.phone , car.brand , car.model , car.year " +
					"FROM car " +
					"INNER JOIN client " +
					"ON car.id_client = client.id_client;" );
		}
		catch (SQLException e) { }
		
		
		
	}

}
