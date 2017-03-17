package test;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import logic.DB;

public class TestDBConnections {
private static final Logger LOGGER = Logger.getLogger(TestAST.class.getName());
   private String testText;
   /**
    * Tests in this file use the mysql_test db, which is not really part of the
    * PhysAssist program, but useful to check that we can connect to the db, and 
    * test failures elsewhere are because of db connectivitiy issues and not bad object code.
    */
   @Before
   public void setUp() {
      this.testText = "Text inserted by TestDBConnections at " +
       System.currentTimeMillis() / 1000L;
   }

   @Test 
   public void testPrepareStatementGeneral() {
      DB db = DB.getInstance();
      try {
         db.connect();

         String text = "My cool test text";
         
         String query = "INSERT INTO `mysql_test` SET `text` = ";
         String[] params = {DB.T_S, text}; 
         
         PreparedStatement stmnt = db.createPreparedStatement(query + "?", params);
         String statementString = stmnt.toString();
         assertEquals(query + "'" + text + "'", statementString.substring(statementString.indexOf(": ") + 2));
      } catch (SQLException e) {
    	 LOGGER.log(Level.FINE, e.toString(), e);
      }
   }

   @Test 
   public void testPrepareStatementParametersMissing() {
      DB db = DB.getInstance();
      try {
         db.connect();
         
         String query = "INSERT INTO `mysql_test` SET `text` = 'This is a parameter test'";
         String[] params = new String[0];
         
         PreparedStatement stmnt;
         stmnt = db.createPreparedStatement(query, params);
         String statementString = stmnt.toString();
         assertEquals(query, statementString.substring(statementString.indexOf(": ") + 2));
      } catch (SQLException e) {
    	 LOGGER.log(Level.FINE, e.toString(), e);
      }
   }
   
   @Test
   public void testInsertGeneric() {
      DB db = DB.getInstance();
      String[] params = {DB.T_S, this.testText + " made by testInsertGeneric"};
      int rowsUpdated = db.execute("INSERT INTO `mysql_test` SET `text` = ?", params);
      assertEquals(1, rowsUpdated);
   }

   @Test
   public void testSelectNoRows() {
      DB db = DB.getInstance();
      String q_getTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `id` < 0";
      List<HashMap<String, String>>rows = db.query(q_getTestRow, null);

      assertEquals(0, rows.size());
   }

   @Test
   public void testSelectOneRow() {
      DB db = DB.getInstance();
      String[] params = {DB.T_S, this.testText};
      db.execute("INSERT INTO `mysql_test` SET `text` = ?", params);
      String q_getTestRow = "SELECT `id`, `text` FROM `mysql_test` LIMIT 1";
      String[] p_getTestRow = {};
      List<HashMap<String, String>>rows = db.query(q_getTestRow, p_getTestRow);

      assertEquals(1, rows.size());
   }
   
   
   @Test
   public void testUpdateOne() {
      DB db = DB.getInstance();
      String[] p_insert = {DB.T_S, this.testText};
      db.execute("INSERT INTO `mysql_test` SET `text` = ?", p_insert);

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
   
   @Test
   public void testSelectMultipleRows() {
      DB db = DB.getInstance();
      String q_getTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `id` > 0 LIMIT 2";
      String[] p_getTestRow = {};
      List<HashMap<String, String>>rows = db.query(q_getTestRow, p_getTestRow);

      assertEquals(2, rows.size());
   }
}
