import java.sql.SQLException;


public class Client extends DataAccess{

	public Client(String DBEngine) {
		super(DBEngine);
		
		this.setServer("localhost");
		this.setDataBase("car_seller");
		this.setUser("root");
		this.setPassword("root");
		this.connect();
		
	}
	
	public void insertCLient( String name ) throws SQLException{
		this.setData( "INSERT INTO client(name) VALUES(" + name + ")" );
	}
	
}
