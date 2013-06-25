import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataAccess {
	
	private String server;
	private String dataBase;
	private String user;
	private String password;
	private String DBEngine;
	
	private Connection connector;
	private Statement statement;
	
	public DataAccess( String DBEngine ){
		
		this.DBEngine = DBEngine;
		
		try{
			
			if( DBEngine.equalsIgnoreCase( "mysql" ) )
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			else if( DBEngine.equalsIgnoreCase( "oracle" ) )
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			
		}
		catch( Exception e ){}
		
	}

	public Connection connect(){
		
		try {
			
			if( this.DBEngine.equalsIgnoreCase( "mysql" ))
				return this.connector = DriverManager.getConnection( "jdbc:mysql://" + this.server + "/" + this.dataBase , this.user , this.password );
			else if( this.DBEngine.equalsIgnoreCase("oracle"))
				return this.connector = DriverManager.getConnection( "jdbc:oracle:oci:@" + this.dataBase , this.user , this.password );
		
		}
		catch (SQLException e) { }
		
		return null;  
	
	}
	
	public void disconnect() throws SQLException{ this.connector.close(); }
	
	public ResultSet getData( String query ){
		
		Statement statement;
		ResultSet resultSet = null;
		
		try {
			statement = connector.createStatement(); 
			resultSet = statement.executeQuery( query );
		}
		catch ( Exception e) { }
		
		return resultSet;
		
	}
	
	public void setData( String query ) throws SQLException{
		statement.executeUpdate( query );
	}
	
	public void setServer(String server) { this.server = server; }
	public void setDataBase(String dataBase) { this.dataBase = dataBase; }
	public void setUser(String user) { this.user = user; }
	public void setPassword(String password) { this.password = password; }
	

}
