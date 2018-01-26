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
		VirtualPet underTest = new VirtualPet(initialHunger, 0);

		// act
		underTest.feed();

		// assert
		int currentHunger = underTest.getHunger();
		Assert.assertEquals(15, currentHunger);
	}

	/**
	 * Adding this test forces me to create an instance variable to hold hunger as
	 * well as implementing getHunger(), feed(), and tick().
	 * 
	 * I decided that my tick() method would increase hunger by two.
	 */
	@Test
	public void shouldBeMoreHungryAfterTick() {
		VirtualPet underTest = new VirtualPet(15, 0);

		underTest.tick();

		int currentHunger = underTest.getHunger();
		Assert.assertEquals(17, currentHunger);
	}

	/**
	 * Now I want to add an initial thirst argument to my constructor. That means
	 * I'll need to add this to the constructor calls in my other tests, too. I'll
	 * just use zeroes in my other tests since its value doesn't matter in those
	 * tests. Again, to make this test pass, I just need to return a constant value
	 * of 25 from getThirst().
	 */
	@Test
	public void shouldBeLessThirstyAfterWatering() {
		int initialThirst = 30;
		VirtualPet underTest = new VirtualPet(0, initialThirst);

		// act
		underTest.water();

		// assert
		int currentThirst = underTest.getThirst();
		Assert.assertEquals("Thirst should have been reduced by 5", 25, currentThirst);
	}

	/**
	 * This will force me to implement support for keeping track of thirst. I'm
	 * going to increase thirst by two each tick.
	 */
	@Test
	public void shouldBeMoreThirstyAfterTick() {
		VirtualPet underTest = new VirtualPet(0, 30);

		underTest.tick();

		int currentThirst = underTest.getThirst();
		// the assertEquals methods are overloaded so that we can include a failure
		// message
		// this is functionally equivalent to Assert.assertEquals(32, currentThirst);
		Assert.assertEquals("Thirst should have increased by 2", 32, currentThirst);
	}
}
