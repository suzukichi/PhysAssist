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
		System.out.println(CharFeed.ch);
		if (BinOp.isBinOperator(CharFeed.ch)) {
			BinOp op = new BinOp(CharFeed.ch);
			CharFeed.nextChar();
			Node left = buildTree();
			CharFeed.nextChar();
			Node right = buildTree();
			node = new Branch(op, left, right);
		}
		else if (Character.isDigit(CharFeed.ch)) {
			node = new Leaf(CharFeed.nextVariable());
		}
		else if (Character.isLetter(CharFeed.ch)) {
			node = new Leaf(CharFeed.nextConstant());
		}
		else {
			if (StringCharacterIterator.DONE != CharFeed.ch) {
				throw new Exception("AST invalid character");
			}
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
		
		public static void nextChar() {
			ch = iterator.next();
			if (ch == ' ') {
				ch = iterator.next();
			}
			while (ch == ')') {
				ch = iterator.next();
			}
		}
		
		public static Variable nextVariable()
		{
			String digit = ch.toString();
			while (Character.isDigit(ch = iterator.next()))
			{
				digit += ch.toString();
			}
			return new Variable(Double.parseDouble(digit));
		}
		
		public static Constant nextConstant() {
			String constant = ch.toString();
			while (Character.isLetter(ch = iterator.next())) {
				constant += ch.toString();
			}
			return new Constant(constant);
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
		public BinOp op; // originally was Operation. Ultimately will want to do non-binary ops, change back
		
		public Branch(BinOp op, Node left, Node right)
		{
			this.op = op;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return left.toString() + " " + op.getValue() + " " + right.toString();
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
