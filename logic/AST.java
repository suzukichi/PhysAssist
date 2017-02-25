package logic;

public class AST
{
	private Node root;
	
	public AST()
	{
		root = null;
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
		
		public Branch(BinOp op)
		{
			this.op = op;
		}
		
		public String toString() {
			return left.toString() + op.getValue() + right.toString();
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
	
	public void addNode(Node parent, Node n)
	{
		
	}
}
