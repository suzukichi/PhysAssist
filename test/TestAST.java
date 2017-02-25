package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.AST;

public class TestAST {
	private AST ast;
	
	public TestAST()
	{
		ast = new AST();
	}
	
	@Test public void testASTCreation()
	{
		Node a = new Node(new BinOp("/"));
		Node b = new Node(new Term(6.0));
		Node c = new Node(new Term(2.0));
		ast.newNode(null, a);
		ast.newNode(a, b);
		ast.newNode(a, c);
		Term result = ast.compute();
		assertEquals(3.0, result.getValue());
	}
}