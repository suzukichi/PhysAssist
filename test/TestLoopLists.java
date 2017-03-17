package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import logic.Equation;
import logic.Category;
import logic.Lists;
import logic.Topic;

public class TestLoopLists {

   @Test
   public void testEquationListNone() {
      long equationlessTopicid = 0;
      List<Equation> e = Lists.getEquationList(equationlessTopicid);
      assertEquals(0, e.size());
   }

   @Test
   public void testEquationListMultiple() {
      List<Equation> e = Lists.getEquationList(1);
      assertTrue(!e.isEmpty());
   }

   /**
    * It is not possible to get 0 topics in the category list.
    * So we will test getCategoryList and getTopicList together.
    */
   @Test
   public void testTopicsListMultiple() {
      long rootTopicid = 0;
      List<Category> c = Lists.getCategoryList();
      List<Topic> t = Lists.getTopicList(rootTopicid);
      assertEquals(c.size(), t.size());
   }

   @Test
   public void testTopicsListNone() {
      long parentTopicid = -1;
      List<Topic> t = Lists.getTopicList(parentTopicid);
      assertEquals(0, t.size());
   }
}
