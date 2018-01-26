package virtualpet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	/**
	 * <p>
	 * In addition explicitly asserted conditions, some things are implicitly
	 * tested. The only explicit assertion this test makes is that the hunger value
	 * is changed, but it implicitly verifies that:
	 * </p>
	 * 
	 * <ul>
	 * <li>an initial hunger can be passed to the constructor</li>
	 * <li>a <code>feed()</code> method exists</li>
	 * <li>a <code>getHunger()</code> (accessor) method is implemented to return the
	 * hunger value</li>
	 * </ul>
	 * 
	 * <p>
	 * I have decided that feeding is going to reduce hunger by 5, so to make this
	 * test pass, I don't need to do anything more than have <code>getHunger()</code>
	 * return 15.
	 * </p>
	 */
	@Test
	public void shouldBeLessHungryAfterFeeding() {
		// arrange
		int initialHunger = 20;
		VirtualPet underTest = new VirtualPet(initialHunger);
		
		// act
		underTest.feed();
		
		// assert
		int currentHunger = underTest.getHunger();
		Assert.assertEquals(15, currentHunger);
	}
}
