//User story: As a customer, I want to edit my shopping cart, for example, adding one item into the cart or deleting one item from the card, so that I can prepare for purchasing.
//Scenario 1: Given the cat food product page opened and I am a customer who wants to purchase it, when I click on “add to cart” button, then this product will be added to my shopping cart.
//Scenario 2: Given the cat food product page opened and I am a customer who wants to delete the cat food product from the shopping cart, when I click on “Cart” button, it will display the products in my shopping cart, and next when I click on “delete” button below the car food product, then this product will be deleted from my shopping cart.
package deliverable3;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//Test the shopping cart function, whether user can add items or delete items from shopping cart
public class CheckOutTest {

	static WebDriver driver = new FirefoxDriver();  

	@Before
	public void setUp() throws Exception{
		driver.get("http://www.amazon.com/Meow-Mix-Chicken-Oceanfish-16-Pound/dp/B000R4CJQ2/ref=sr_1_1?&s=pet-supplies&ie=UTF8&qid=1435972088&sr=1-1&keywords=cat+food");
	}

	//Test if user can add items into her shopping cart 
	@Test   
	public void testAddOneItem(){       

		WebElement addCartBtn = driver.findElement(By.id("add-to-cart-button"));

		addCartBtn.click();

		try {
			WebElement message = driver.findElement(By.className("a-text-bold"));

			assertTrue(message.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	//Test if user can delete items into her shopping cart 
	@Test
	public void deleteFromCart(){
		WebElement addCartBtn = driver.findElement(By.id("add-to-cart-button"));

		addCartBtn.click();

		WebElement cartBtn = driver.findElement(By.id("nav-cart"));

		cartBtn.click();

		WebElement deleteBtn = driver.findElement(By.name("submit.delete.C3GSZ6TFBDJIC"));
		deleteBtn.click();

		try {
			WebElement message = driver.findElement(By.className("a-size-base"));
			assertTrue(message.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}

