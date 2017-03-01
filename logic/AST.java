package logic;

import java.text.StringCharacterIterator;

public class AST
{
	private Node root;
	
	public AST()
	{
		root = null;
	}
	
	public AST(String tree) throws Exception
	{
		CharFeed.init(tree);
		root = buildTree();
	}
	
	private Node buildTree() throws Exception
	{
		Node node = null;
		//System.out.println(CharFeed.ch);
		String value = CharFeed.nextWord();
		if (BinaryOperator.isBinaryOperator(value)) {
		  BinaryOperator op = new BinaryOperator(value);
		  CharFeed.nextChar();
		  Node left = buildTree();
		  CharFeed.nextChar();
		  Node right = buildTree();
		  node = new Branch(op, left, right);
		}
		else if (Character.isDigit(value.charAt(0))) {
		  node = new Leaf(new Variable(Double.parseDouble(value)));
		}
		else if (Character.isLetter(value.charAt(0))) {
		  node = new Leaf(new Constant(value));
		}
		else {
		  throw new Exception("AST invalid character");
		}
		return node;
	}
	
	private static class CharFeed {
		public static Character ch;
		public static StringCharacterIterator iterator;
		
		public static void init(String tree) {
			iterator = new StringCharacterIterator(tree.trim());
			ch = iterator.current();
		}
		
		public static String nextWord() {
          String word = ch.toString();
          while (' ' != (ch = iterator.next()) && StringCharacterIterator.DONE != ch) {
              word += ch.toString();
          }
          return word;
		}
		
		public static void nextChar() {
			ch = iterator.next();
			if (ch == ' ') {
				ch = iterator.next();
			}
		}
	}
	
	private interface Node
	{
		public String toString();
	}
	
	private class Branch implements Node 
	{
		public Node left;
		public Node right;
		public BinaryOperator op; // originally was Operation. Ultimately will want to do non-binary ops, change back
		
		public Branch(BinaryOperator op, Node left, Node right)
		{
			this.op = op;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return left.toString() + " " + op.toString() + " " + right.toString();
		}
	}
	
	private class Leaf implements Node
	{
		public Term value;
		
		public Leaf(Term value)
		{
			this.value = value;
		}
		
		public String toString() {
			return value.toString();
		}
	}
	
	public Term compute() throws Exception
	{
		if (root == null)
		{
			return null;
		}
		return computeValue(root);
	}
	
	private Term computeValue(Node n) throws Exception
	{
		if (n instanceof Leaf)
		{
			return ((Leaf)n).value;
		}
		return ((Branch)n).op.perform(computeValue(((Branch)n).left), computeValue(((Branch)n).right));
	}
	
	public String toString()
	{
		if (root == null)
		{
			return "";
		}
		return root.toString();
	}

}
