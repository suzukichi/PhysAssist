package logic;

import java.text.StringCharacterIterator;

public class AST {
	private Node root = null;
	
	public AST(String tree) throws IllegalArgumentException 
	{
		CharFeed.init(tree);
		root = buildTree();
	}

	private Node buildTree() throws IllegalArgumentException 
	{
		Node node = null;
		String value = CharFeed.nextWord();
		if (BinaryOperator.isBinaryOperator(value)) 
		{
			BinaryOperator op = new BinaryOperator(value);
			CharFeed.nextChar();
			Node left = buildTree();
			CharFeed.nextChar();
			Node right = buildTree();
			node = new BinaryBranch(op, left, right);
		} 
		else if (UnaryOperator.isUnaryOperator(value)) 
		{
			UnaryOperator op = new UnaryOperator(value);
			CharFeed.nextChar();
			Node left = buildTree();
			node = new UnaryBranch(op, left);
		} 
		else if (Character.isDigit(value.charAt(0))) 
		{
			node = new Leaf(new Variable(Double.parseDouble(value)));
		} 
		else if (Character.isLetter(value.charAt(0))) 
		{
			node = new Leaf(new Constant(value));
		} 
		else if ('-' == value.charAt(0)) 
		{
			node = new Leaf(new Variable(0 - Double.parseDouble(value.substring(1, value.length()))));
		} 
		else if (value.charAt(0) != StringCharacterIterator.DONE) 
		{
			throw new IllegalArgumentException("AST invalid character");
		}
		return node;
	}

	private static class CharFeed 
	{
		private static Character ch;
		private static StringCharacterIterator iterator;

		private CharFeed()
		{
			
		}
		
		public static void init(String tree) 
		{
			iterator = new StringCharacterIterator(tree.trim());
			ch = iterator.current();
		}

		public static String nextWord() 
		{
			String word = ch.toString();
			// Loop tested in test/TestLoopASTBuildTree.java
			while (' ' != (ch = iterator.next()) && StringCharacterIterator.DONE != ch) 
			{
				word += ch.toString();
			}
			return word;
		}

		public static void nextChar() 
		{
			ch = iterator.next();
		}
	}

	private interface Node 
	{
		@Override
		public String toString();
	}

	private class UnaryBranch implements Node 
	{
		private Node left;
		private UnaryOperator op;

		public UnaryBranch(UnaryOperator op, Node left) 
		{
			this.op = op;
			this.left = left;
		}

		@Override
		public String toString() 
		{
			return op.toString() + " " + left.toString();
		}
	}

	private class BinaryBranch implements Node 
	{
		private Node left;
		private Node right;
		private BinaryOperator op;

		public BinaryBranch(BinaryOperator op, Node left, Node right) 
		{
			this.op = op;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() 
		{
			return left.toString() + " " + op.toString() + " " + right.toString();
		}
	}

	private class Leaf implements Node 
	{
		private Term value;

		public Leaf(Term value) 
		{
			this.value = value;
		}

		@Override
		public String toString() 
		{
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
		Term ret;
		if (n instanceof Leaf) 
		{
			ret = ((Leaf) n).value;
		} 
		else if (n instanceof BinaryBranch) 
		{
			ret = ((BinaryBranch) n).op.perform(computeValue(((BinaryBranch) n).left),
					computeValue(((BinaryBranch) n).right));
		} 
		else 
		{
			ret = ((UnaryBranch) n).op.perform(computeValue(((UnaryBranch) n).left));
		}
		return ret;
	}

	@Override
	public String toString() 
	{
		if (root == null) 
		{
			return "";
		}
		return root.toString();
	}
}
