import java.sql.SQLException;


public class DataBase {
	
	public static void main(String[] args) throws SQLException {
		/*
		DataAccess data = new DataAccess("mysql");
		data.setServer("localhost");
		data.setDataBase("car_seller");
		data.setUser("root");
		data.setPassword("root");
		data.connect();
		
		ResultSet resultSet = data.getData("SELECT * FROM car");
		
		while( resultSet.next() ){
			
			System.out.print( resultSet.getInt( "id_car" ) + "\t" );
			System.out.print( resultSet.getString( "brand" ) + "\t" );
			System.out.print( resultSet.getString( "model" ) + "\t" );
			System.out.print( resultSet.getInt( "year" ) + "\t" );
			System.out.print( resultSet.getString( "colour" ) );
			System.out.println( );
			
		}*/
		
		FormFrame form = new FormFrame();
		
	}

}
