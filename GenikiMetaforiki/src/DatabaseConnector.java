import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	
	private Connection connection =  null;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String dbName = "javadb";
	private final String dbPath = "jdbc:mysql://localhost/"+dbName;
	private final String username = "root";
	private final String password = "";
	
	private Statement statement = null;
	
	public DatabaseConnector(){
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(dbPath, username, password);
			statement = connection.createStatement();
			createMaterialTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void createMaterialTable(){
		
		DatabaseMetaData md;
		boolean tableExists = false;
		try {
			md = connection.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {   
				System.out.println(rs.getString(3)); 
				if(rs.getString(3).equals("materials"))
					tableExists = true;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 

		if(!tableExists){
			try {
				statement.executeUpdate("CREATE TABLE CLIENTS (ID INTEGER AUTO_INCREMENT," +
										"MATERIALCODE VARCHAR(10) NOT NULL," +
										"DISTANCE VARCHAR(5) NOT NULL," +
										"WEIGHT VARCHAR(5) NOT NULL," +
										"FOOD BOOL NOT NULL," +
										"ISISLAND BOOL NOT NULL," +
										"PRIMARY KEY(ID) )");
				
				System.out.println("Table created successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Table Materials already exists");
		}
	}
	
	public void addMaterialToDatabase(String code, String kilomet, String klg, Boolean f, Boolean destin){
		try {
			statement.executeUpdate("INSERT INTO MATERIALS (NAME, ADDRESS, PHONE) VALUES" +
									"( '"+code+"','"+kilomet+"', '"+klg+"', '"+f+"', '"+destin+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
