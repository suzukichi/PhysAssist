package logic;
/*
 * @author diana
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DB {
	private Connection connection;
	
	
	// TODO: move to config file
	static final String DB_NAME = "physassist";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://unix3.csc.calpoly.edu:4444/" + DB_NAME;

	static final String USER = "physassist_dev";
	static final String PASS = "G2ugktexSk9WSWan";

	/**
	 * Executes update statement. 
	 * 
	 * @param query
	 * @param params
	 */
	public int execute(String query, String[] params) {
	   int rowsUpdated = 0;
		try {
		   this.connect();

         rowsUpdated = this.createPreparedStatement(query, params).executeUpdate();

         this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}
	
	public PreparedStatement createPreparedStatement(String query, String[] params) throws SQLException {
         PreparedStatement preparedStmt = this.connection.prepareStatement(query);
         //int ndx = 0;
         for (int i = 0; i < params.length; i += 2) {
            /*
             * TODO: rquire types when db is tested.
           if (i % 2 == 1) {
              switch (params[i]) {
                  case Types.INTEGER:
                    preparedStmt.setInt(ndx, params[i + 1]); 
                    break;
                  case Types.STRING:
                     preparedStmt.setString(ndx, params[i]);
                  break;
                  default:
                     throw new OutOfBoundsException("Missing or invalid parameter type");
              }
           }
              */
            preparedStmt.setString(i, params[i]);
         }
         return preparedStmt;
	}
	
	/**
	 * Executes a select and returns the results. 
	 * 
	 * @param query
	 * @return Hashmap of column name, (string)value
	 */
	// NOTE: this is not quite reight yet...
	public ArrayList<HashMap<String, String>> query(String query, String[] params) {
	   ArrayList<HashMap<String, String>> results = new ArrayList<HashMap<String, String>>();

	   this.connect();

	   try {
         ResultSet rs = this.createPreparedStatement(query, params).executeQuery(query);
         ResultSetMetaData md = rs.getMetaData();

         String selectedData;
         int ndx;
         while (rs.next()) {
            HashMap<String, String> row = new HashMap<String, String>();

            for (ndx = 0; ndx < rs.getFetchSize(); ndx++) {
               /*
                * TODO: Types
               // This all needs to be in an inner loop somehow. TODO: see how results work.
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
               */ 

               selectedData = rs.getString(ndx);
               row.put(md.getColumnName(ndx), selectedData);
            }
            
            results.add(row);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
	   
	   return results;
	}
	
	public void connect() {
		if (this.connection == null) {
			try {
		      Class.forName(JDBC_DRIVER);
				this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
		}
	}
}
