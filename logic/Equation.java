package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equation {
   private String name;
   public long topicID;
   public long equationID;
   private String view;
   private String description;
   private String history;

   public Equation(long equationID) {
      getEquation(equationID);
   }

   private void getEquation(long equationID) {
      String qGetEquation = "SELECT `name`, `view`, `description`, `history`, `topicid` " + 
                            " FROM `equations`" + 
                            " WHERE `equationid` = ? " + 
                            " LIMIT 1";
      String[] pGetEquation = {DB.T_I, String.valueOf(equationID)};
      ArrayList<HashMap<String, String>> rows = DB.getInstance().query(qGetEquation, pGetEquation);

      this.equationID = equationID;

      HashMap<String, String> row = rows.get(0);
      this.name = row.get("name");
      this.view = row.get("view");
      this.description = row.get("description");
      this.history = row.get("history");
      this.topicID = Long.parseLong(row.get("topicid"));
   }

   public String getView() {
      return this.view;
   }

   public String getDescription() {
      return this.description;
   }

   public String getHistory() {
      return this.history;
   }

   public Term solve(Term target, List<Term> terms) throws Exception {
      String ast = getAST(target);
      for (int i = 0; i < terms.size(); i++) {
         String[] halves = ast.split((terms.get(i)).getName());
         if (halves.length == 2) {
            ast = halves[0] + (terms.get(i)).getValue() + halves[1];
         } else {
            throw new IllegalArgumentException("Invalid ast string.");
         }
      }
      AST equation = new AST(ast);
      return equation.compute();
   }

   private String getAST(Term term) {
      String ast = "";
      String[] pGetAST = { DB.T_I, String.valueOf(equationID), DB.T_S, term.getName() };

      String qGetAST = "SELECT `ast` FROM `ast` WHERE `eqid` = ?, `term` = ?";
      ArrayList<HashMap<String, String>> rows = DB.getInstance().query(qGetAST, pGetAST);

      for (HashMap<String, String> row : rows) {
         ast = row.get("view");
      }

      if ("".equals(ast)) {
         throw new IllegalArgumentException("Invalid ast string.");
      }

      return ast;
   }
}
