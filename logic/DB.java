package logic;
/*
 * @author diana
 */
import java.sql.*;
import java.util.HashMap;

public class DB {
	private Connection connection;
	private Statement stmt;

	public DB() {
		
	}

	/**
	 * Executes update statement. 
	 * 
	 * @param query
	 */
	public void execute(String query) {
		try {
		   this.connect();
         stmt.executeUpdate(query);
         stmt.close();
         this.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a select and returns the results. 
	 * 
	 * @param query
	 * @return Hashmap of column name, (string)value
	 */
	public HashMap<String, String> query(String query) {
	   this.connect();
	   HashMap<String, String> results = new HashMap<String, String>();
	   try {
         ResultSet rs = stmt.executeQuery(query);
         ResultSetMetaData md = rs.getMetaData();
         String selectedData;
         int ndx;
         while (rs.next()) {
            ndx = rs.getRow() - 1;
            switch (md.getColumnType(ndx)) {
               case Types.INTEGER:
               case Types.BIGINT:
                  selectedData = String.valueOf(rs.getLong(ndx));
               break;
               case Types.VARCHAR:
               case Types.CHAR:
                  selectedData = rs.getString(ndx);
               break;
               default:
                  throw new IllegalArgumentException("Invalid column type '" + md.getColumnType(ndx) +  "' being selected");
            }
               
            results.put(md.getColumnName(ndx), selectedData);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	   
	   return results;
	}
	
	public Connection getConnection() {
		if (this.connection == null) {
			try {
				this.connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.connection;
	}
	
	public void connect() {
		try {
			this.stmt = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
