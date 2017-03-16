//loop test for calculator

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestLoopCalculatorOther {
	@Test
	public void LoopNever(){
		String[] names = {};
		Calculator C = new Calculator();
		C.setButtonNames(names);
		int i = C.anyOtherButton("");
		assertEquals(0,i,0);
	}
	
	@Test
	public void LoopOnce(){
		String[] names = {"1","2"};
		Calculator C = new Calculator();
		C.setButtonNames(names);
		int i = C.anyOtherButton("2");
		assertEquals(1,i,0);
	}
	@Test
	public void LoopOnceMore(){
		String[] names = {"1","2"};
		Calculator C = new Calculator();
		C.setButtonNames(names);
		int i = C.anyOtherButton("2");
		assertEquals(1,i,0);
	}
	@Test
	public void LoopEntireArray(){
		String[] names = {"1","2","3"};
		Calculator C = new Calculator();
		C.setButtonNames(names);
		int i = C.anyOtherButton("3");
		assertEquals(2,i,0);
	}
	@Test
	public void LoopNotInArray(){
		String[] names = {"1","2","3","4"};
		Calculator C = new Calculator();
		C.setButtonNames(names);
		int i = C.anyOtherButton("");
		assertEquals(4,i,0);
	}
}
