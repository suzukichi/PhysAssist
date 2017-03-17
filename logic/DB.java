package logic;
/*
 * @author diana
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import test.TestAST;

public class DB {
	private static final Logger LOGGER = Logger.getLogger(DB.class.getName());
    private static DB instance = null;
    
	private Connection connection;
	
	public static final String T_I = "int";
	public static final String T_D = "decimal";
	public static final String T_S = "string";
	
	static final String DB_NAME = "physassist";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://unix3.csc.calpoly.edu:4444/" + DB_NAME;

	static final String USER = "physassist_dev";
	static final String PASS = "G2ugktexSk9WSWan";
	
	static final boolean DEBUG_MODE = true;

	/*
	 * Singleton Design Pattern: Constructor is private. Use getInstance() method when you need this object.
	 */
	private DB() {
	  instance = this;
	}
	
	/*
	 * Method to retrieve the Singleton instance of this class.
	 */
	public static DB getInstance() {
	  if (instance == null) {
	    return new DB();
	  }
	  
	  return instance;
	}
	
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

		   PreparedStatement statement = this.createPreparedStatement(query, params);
         rowsUpdated = statement.executeUpdate();

         this.getConnection().close();
		} catch (SQLException e) {
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		
		return rowsUpdated;
	}
	
	
	/**
	 * Executes a select and returns the results. 
	 * 
	 * @param query
	 * @return Hashmap of column name, (string)value
	 */
	public List<HashMap<String, String>> query(String query, String[] params) {
	   ArrayList<HashMap<String, String>> results = new ArrayList<>();

	   try {
         this.connect();
         ResultSet rs = this.createPreparedStatement(query, params).executeQuery();
         ResultSetMetaData md = rs.getMetaData();

         String selectedData;
         int colCount = md.getColumnCount();

         // Loop tested in test/TestDBConnections.java
         while (rs.next()) {
            HashMap<String, String> row = new HashMap<>();

            for (int ndx = 1; ndx <= colCount; ndx++) {
               switch (md.getColumnType(ndx)) {
                  case Types.TINYINT:
                  case Types.BIT:
                	  selectedData = String.valueOf(rs.getLong(ndx));
                	  break;
                  case Types.INTEGER:
                  case Types.BIGINT:
                     selectedData = String.valueOf(rs.getLong(ndx));
                     break;
                  case Types.VARCHAR:
                  case Types.CHAR:
                     selectedData = rs.getString(ndx);
                     break;
                  default:
                     throw new IllegalArgumentException("Invalid column type '" + md.getColumnTypeName(ndx) +  "' being selected");
               }

               row.put(md.getColumnName(ndx), selectedData);
            }
            
            results.add(row);
         }
      } catch (SQLException e) {
    	  LOGGER.log(Level.FINE, e.toString(), e);
      }
	   
	   return results;
	}
	
	public PreparedStatement createPreparedStatement(String query, String[] params) throws SQLException {
      PreparedStatement preparedStmt = this.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      if (params == null) {
         return preparedStmt;
      }

      int ndx = 1;
      // Loop tested in test/TestDBConnections.java
      for (int i = 0; i < params.length; i += 2) {
         parseParam(params, preparedStmt, i, ndx++);
      }
      

      return preparedStmt;
	}
	
	private void parseParam(String[] params, PreparedStatement preparedStmt, int i, int ndx) throws SQLException {
      switch (params[i]) {
         case T_I:
            if (params[i + 1] == null) {
               preparedStmt.setNull(ndx, Types.FLOAT);
            } else {
               preparedStmt.setInt(ndx, Integer.valueOf(params[i + 1])); 
            } break;
         case T_D:
            if (params[i + 1] == null) {
               preparedStmt.setNull(ndx, Types.FLOAT);
            } else {
               preparedStmt.setFloat(ndx, Float.valueOf(params[i + 1])); 
            } break;
         case T_S:
            if (params[i + 1] == null) {
               preparedStmt.setNull(ndx, Types.VARCHAR);
            } else {
               preparedStmt.setString(ndx, params[i + 1]);
            } break;
         default:
            throw new ArrayIndexOutOfBoundsException("Missing or invalid parameter type");
      }
	}

	public void connect() throws SQLException {
      if (this.connection == null || this.connection.isClosed()) {
         try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
         } catch (SQLException | ClassNotFoundException e) {
        	 e.printStackTrace();//LOGGER.log(Level.FINE, e.toString(), e);
         }
      }
	}
	
	public Connection getConnection() {
	   try {
         this.connect();
      } catch (SQLException e) {
    	  LOGGER.log(Level.FINE, e.toString(), e);
      }
	   return this.connection;
	}
}
