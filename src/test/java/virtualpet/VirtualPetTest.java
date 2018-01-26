package virtualpet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	/**
	 * In addition explicitly asserted conditions, some things are implicitly
	 * tested. The only explicit assertion this test makes is that the hunger value
	 * is changed, but it implicitly verifies that:
	 *
	 * - an initial hunger can be passed to the constructor
	 * 
	 * - a feed() method exists
	 * 
	 * - a getHunger() (accessor) method is implemented to return the hunger value
	 * 
	 * I have decided that feeding is going to reduce hunger by 5, so to make this
	 * test pass, I don't need to do anything more than have getHunger() return 15.
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
