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
	 * test pass, I don't need to do anything more than have
	 * <code>getHunger()</code> return 15.
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

	/**
	 * <p>
	 * Adding this test forces me to create an instance variable to hold hunger as
	 * well as implementing <code>getHunger()</code>, <code>feed()</code>, and
	 * <code>tick()</code>.
	 * </p>
	 * 
	 * <p>
	 * I decided that my <code>tick()</code> method would increase hunger by two.
	 * </p>
	 */
	@Test
	public void shouldBeMoreHungryAfterTick() {
		VirtualPet underTest = new VirtualPet(15);

		underTest.tick();

		int currentHunger = underTest.getHunger();
		Assert.assertEquals(17, currentHunger);
	}
}
