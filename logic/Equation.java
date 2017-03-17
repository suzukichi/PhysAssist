package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equation {
   private String name;
   private long topicID;
   private long equationID;
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
      List<HashMap<String, String>> rows = DB.getInstance().query(qGetEquation, pGetEquation);

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
    	 ast = ast.replace(terms.get(i).getName(), Double.toString(terms.get(i).getValue()));
      }
      AST equation = new AST(ast);
      
      return equation.compute();
   }

   private String getAST(Term term) {
      String ast = "";
      String[] pGetAST = { DB.T_I, String.valueOf(equationID), DB.T_S, term.getName() };

      String qGetAST = "SELECT `ast` FROM `ast` WHERE `equationid` = ? AND `term` = ? LIMIT 1";
      List<HashMap<String, String>> rows = DB.getInstance().query(qGetAST, pGetAST);

      HashMap<String, String> row = rows.get(0);
      ast = row.get("ast");

      if (ast.equals("")) {
         throw new IllegalArgumentException("Invalid ast string.");
      }
      return ast;
   }
}
