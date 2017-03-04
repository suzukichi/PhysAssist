package logic;

import java.text.StringCharacterIterator;

public class AST {
	private Node root = null;

	public AST(String tree) throws Exception {
		CharFeed.init(tree);
		root = buildTree();
	}

	private Node buildTree() throws Exception {
		Node node = null;
		String value = CharFeed.nextWord();
		if (BinaryOperator.isBinaryOperator(value)) {
			BinaryOperator op = new BinaryOperator(value);
			CharFeed.nextChar();
			Node left = buildTree();
			CharFeed.nextChar();
			Node right = buildTree();
			node = new BinaryBranch(op, left, right);
		} else if (UnaryOperator.isUnaryOperator(value)) {
			UnaryOperator op = new UnaryOperator(value);
			CharFeed.nextChar();
			Node left = buildTree();
			node = new UnaryBranch(op, left);
		} else if (Character.isDigit(value.charAt(0))) {
			node = new Leaf(new Variable(Double.parseDouble(value)));
		} else if (Character.isLetter(value.charAt(0))) {
			node = new Leaf(new Constant(value));
		} else if ('-' == value.charAt(0)) {
			node = new Leaf(new Variable(0 - Double.parseDouble(value.substring(1, value.length()))));
		} else if (value.charAt(0) != StringCharacterIterator.DONE) {
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
		}
	}

	private interface Node {
		public String toString();
	}

	private class UnaryBranch implements Node {
		public Node left;
		public UnaryOperator op;

		public UnaryBranch(UnaryOperator op, Node left) {
			this.op = op;
			this.left = left;
		}

		public String toString() {
			return op.toString() + " " + left.toString();
		}
	}

	private class BinaryBranch implements Node {
		public Node left;
		public Node right;
		public BinaryOperator op;

		public BinaryBranch(BinaryOperator op, Node left, Node right) {
			this.op = op;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return left.toString() + " " + op.toString() + " " + right.toString();
		}
	}

	private class Leaf implements Node {
		public Term value;

		public Leaf(Term value) {
			this.value = value;
		}

		public String toString() {
			return value.toString();
		}
	}

	public Term compute() throws Exception {
		if (root == null) {
			return null;
		}
		return computeValue(root);
	}

	private Term computeValue(Node n) throws Exception {
		Term ret = null;
		if (n instanceof Leaf) {
			ret = ((Leaf) n).value;
		} else if (n instanceof BinaryBranch) {
			ret = ((BinaryBranch) n).op.perform(computeValue(((BinaryBranch) n).left),
					computeValue(((BinaryBranch) n).right));
		} else {
			System.out.println("LEFT IS " + ((UnaryBranch) n).left.toString());
			ret = ((UnaryBranch) n).op.perform(computeValue(((UnaryBranch) n).left));
			System.out.println("RET IS " + ret.toString());
		}
		return ret;

	}

	public String toString() {
		if (root == null) {
			return "";
		}
		return root.toString();
	}

}
