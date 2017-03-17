package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import logic.DB;

public class TestDBConnections {
   private String testText;
   private static final Logger LOGGER = Logger.getLogger(TestDBConnections.class.getName());
   private static final String GENERIC_QUERY = "INSERT INTO `mysql_test` SET `text` = ?";
   /**
    * Tests in this file use the mysql_test db, which is not really part of the
    * PhysAssist program, but useful to check that we can connect to the db, and 
    * test failures elsewhere are because of db connectivitiy issues and not bad object code.
    * 
    * Any test with statements also tests the loop logic.
    */
   @Before
   public void setUp() {
      this.testText = "Text inserted by TestDBConnections at " +
       System.currentTimeMillis() / 1000L;
   }
   
   /**
    * Tests prepare statement loop with valid parameters.
    */
   @Test 
   public void testPrepareStatementGeneral() throws SQLException {
      DB db = DB.getInstance();
      db.connect();

      String text = "My cool test text";

      String query = "INSERT INTO `mysql_test` SET `text` = ";
      String[] params = {DB.T_S, text}; 

      PreparedStatement stmnt = db.createPreparedStatement(query + "?", params);
      String statementString = stmnt.toString();
      assertEquals(query + "'" + text + "'", statementString.substring(statementString.indexOf(": ") + 2));
   }

   /**
    * Tests prepare statement loop with no parameters.
    */
   @Test 
   public void testPrepareStatementParametersMissing() throws SQLException {
      DB db = DB.getInstance();
      db.connect();

      String query = "INSERT INTO `mysql_test` SET `text` = 'This is a parameter test'";
      String[] params = new String[0];

      PreparedStatement stmnt;
      stmnt = db.createPreparedStatement(query, params);
      String statementString = stmnt.toString();
      assertEquals(query, statementString.substring(statementString.indexOf(": ") + 2));
   }

   /**
    * Tests prepare statement loop with null.
    */
   @Test 
   public void testPrepareStatementParametersNull() throws SQLException {
      DB db = DB.getInstance();
      db.connect();

      String query = "INSERT INTO `mysql_test` SET `text` = ?";
      String[] params = {DB.T_D, null};

      PreparedStatement stmnt;
      stmnt = db.createPreparedStatement(query, params);
      String statementString = stmnt.toString();
      assertEquals(query, statementString.substring(statementString.indexOf(": ") + 2));
   }

   /**
    * Tests prepare statement loop with invalid number of parameters.
    */
   @Test
   public void testPrepareStatementParametersInvalid() throws SQLException {
      DB db = DB.getInstance();
      db.connect();
      Boolean thrown = false;

      String query = "INSERT INTO `mysql_test` SET `text` = ?";
      String[] params = {DB.T_D};
      try {
         db.createPreparedStatement(query, params);
      } catch (ArrayIndexOutOfBoundsException e) {
         LOGGER.log(Level.FINE, e.toString(), e);
         thrown = true;
      }
      assertTrue(thrown);
   }
   
   /**
    * Diana's unit test
    */
   @Test
   public void testInsertGeneric() {
      DB db = DB.getInstance();
      String[] params = {DB.T_S, this.testText + " made by testInsertGeneric"};
      int rowsUpdated = db.execute(GENERIC_QUERY, params);
      assertEquals(1, rowsUpdated);
   }

   /**
    * Tests loop in DB.query with no runs.
    */
   @Test
   public void testSelectNoRows() {
      DB db = DB.getInstance();
      String qGetTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `id` < 0";
      List<HashMap<String, String>>rows = db.query(qGetTestRow, null);

      assertEquals(0, rows.size());
   }

   /**
    * Tests loop in DB.query with one run.
    */
   @Test
   public void testSelectOneRow() {
      DB db = DB.getInstance();
      String[] params = {DB.T_S, this.testText};
      db.execute(GENERIC_QUERY, params);
      String qGetTestRow = "SELECT `id`, `text` FROM `mysql_test` LIMIT 1";
      String[] pGetTestRow = {};
      List<HashMap<String, String>>rows = db.query(qGetTestRow, pGetTestRow);

      assertEquals(1, rows.size());
   }
   
   /**
    * Tests loop in DB.query with multiple runs.
    */
   @Test
   public void testSelectMultipleRows() {
      DB db = DB.getInstance();
      String qGetTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `id` > 0 LIMIT 2";
      String[] pGetTestRow = {};
      List<HashMap<String, String>>rows = db.query(qGetTestRow, pGetTestRow);

      assertEquals(2, rows.size());
   }
   
   /**
    * Diana's unit test
    */
   @Test
   public void testUpdateOne() {
      DB db = DB.getInstance();
      String[] pInsert = {DB.T_S, this.testText};
      db.execute(GENERIC_QUERY, pInsert);

      String editedText = "Text inserted by TestDBConnections.testUpdateOne at " +
       System.currentTimeMillis() / 1000L;
      String[] p_updateText = {
          DB.T_S, editedText,
          DB.T_S, this.testText
      };

      int rowsUpdated = db.execute("UPDATE `mysql_test` SET `text` = ? WHERE `text` = ?", p_updateText);

      assertTrue(rowsUpdated >= 1);
      this.testText = editedText; 
   }
}