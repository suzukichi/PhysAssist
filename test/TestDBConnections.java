package test;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import logic.DB;

public class TestDBConnections {
   /**
    * Tests in this file use the mysql_test db, which is not really part of the
    * PhysAssist program, but useful to check that we can connect to the db, and 
    * test failures elsewhere are because of db connectivitiy issues and not bad object code.
    */
   private String testText;

   @Test 
   public void testPrepareStatementGeneral() {
      DB db = new DB();
      db.connect();

      String text = "My cool test text";
      
      String query = "INSERT INTO `mysql_test` SET `text` = ";
      String[] params = new String[1];
      params[0] = text; 
      
      PreparedStatement stmnt;
      try {
         stmnt = db.createPreparedStatement(query + "'?'", params);
         assertEquals(query + "'" + text + "'", stmnt.toString());
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Test 
   public void testPrepareStatementParametersMissing() {
      DB db = new DB();
      db.connect();
      
      String query = "INSERT INTO `mysql_test` SET `text` = 'This is a parameter test'";
      String[] params = new String[0];
      
      PreparedStatement stmnt;
      try {
         stmnt = db.createPreparedStatement(query + "'?'", params);
         assertEquals(query, stmnt.toString());
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   @Test
   public void testInsertGeneric() {
      DB db = new DB();
      this.testText = "Text inserted by TestDBConnections.testInsertGeneric at " +
       System.currentTimeMillis() / 1000L;
      String[] params = new String[1];
      params[0] = testText;
      int rowsUpdated = db.execute("INSERT INTO `mysql_test` SET `text` = '?'", params);
      assertEquals(1, rowsUpdated);
   }

   @Test
   public void testSelectNoRows() {
      DB db = new DB();
      String q_getTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `id` = ?";
      String[] p_getTestRow = {"-1"};
      ArrayList<HashMap<String, String>>rows = db.query(q_getTestRow, p_getTestRow);

      assertEquals(0, rows.size());
   }

   @Test
   public void testSelectOneRow() {
      DB db = new DB();
      String q_getTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `text` = ?";
      String[] p_getTestRow = {this.testText};
      ArrayList<HashMap<String, String>>rows = db.query(q_getTestRow, p_getTestRow);

      assertEquals(1, rows.size());
   }
   
   @Test
   public void testUpdateOne() {
      DB db = new DB();
      String editedText = "Text inserted by TestDBConnections.testUpdateOne at " +
       System.currentTimeMillis() / 1000L;
      String[] params = new String[2];
      params[0] = editedText;
      params[1] = this.testText;
      int rowsUpdated = db.execute("UPDATE `mysql_test` SET `text` = '?' WHERE `text` = ?", params);
      assertEquals(1, rowsUpdated);
      this.testText = editedText; 
   }
   
   @Test
   public void testSelectMultipleRows() {
      DB db = new DB();
      String q_getTestRow = "SELECT `id`, `text` FROM `mysql_test` WHERE `id` > 0 LIMIT 2";
      String[] p_getTestRow = {};
      ArrayList<HashMap<String, String>>rows = db.query(q_getTestRow, p_getTestRow);

      assertEquals(2, rows.size());
   }
}
