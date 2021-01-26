import org.junit.Assert;
import org.junit.Test;

public class MovingAverageListTest {

	private MovingAverageList list;
	private int windowSize = 5;
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeWindow(){
		list = new MovingAverageList(-windowSize);
		Assert.assertEquals(0.0, list.getMovingAverage(), 0.0);
	}

	@Test
	public void testMovingAverageNoElements(){
		list = new MovingAverageList(windowSize);
		Assert.assertEquals(0.0, list.getMovingAverage(), 0.0);
	}
	
	@Test
	public void testMovingAverageOneElement(){
		list = new MovingAverageList(windowSize);
		list.addElement(1.0);
		Assert.assertEquals(1.0, list.getMovingAverage(), 0.0);
	}
	
	@Test
	public void testMovingAverageFullQueue(){
		list = new MovingAverageList(windowSize);
		list.addElement(1.0);
		list.addElement(2.0);
		list.addElement(3.0);
		list.addElement(4.0);
		list.addElement(5.0);
		Assert.assertEquals(3.0, list.getMovingAverage(), 0.0);
	}
	
	@Test
	public void testMovingAverageOverFullQueue(){
		list = new MovingAverageList(windowSize);
		list.addElement(1.0);
		list.addElement(2.0);
		list.addElement(3.0);
		list.addElement(4.0);
		list.addElement(5.0);
		list.addElement(6.0);
		list.addElement(7.0);
		Assert.assertEquals(5.0, list.getMovingAverage(), 0.0);
	}
	
	@Test
	public void testGetElements(){
		list = new MovingAverageList(windowSize);
		Double[] expected = {1.0, 2.0, 3.0, 4.0, 5.0};
		for (Double d : expected){
			list.addElement(d);
		}
		Double[] actual = list.getElements();
		Assert.assertArrayEquals(expected, actual);
	}
}
