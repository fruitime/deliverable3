//User story: As a customer, I wan to login my amazon account, so that I can keep a track of all my purchases and other information.
//Scenario 1: Given the sign in page opened, when I input “yufankaren@gmail.com” as email and “helloamazon” as password, then I can login my account. 
//Scenario 2: Given the sign in page opened, when I input “yufankaren@gmail.com” as email and “hello” as password, then the system will show an error message to show that there is something wrong with the email or password.
package deliverable3;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//Test if user can log in or not with valid and invalid user information
public class LogInTest {

	static WebDriver driver = new FirefoxDriver();	

	@Before
	public void setUp() throws Exception{
		driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_signin");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Test if user can log in successfully when providing valid user information
	@Test	
	public void testValidLoginIn(){
		driver.findElement(By.name("email")).sendKeys("yufankaren@gmail.com");
		driver.findElement(By.name("password")).sendKeys("helloamazon");

		WebElement loginDiv = driver.findElement(By.id("ap_signin1a_signin_button_row"));

		WebElement submitButton = loginDiv.findElement(By.id("signInSubmit-input"));
		submitButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			WebElement yourAccount = driver.findElement(By.id("nav-link-yourAccount"));
			assertTrue(yourAccount.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// Test if user cannot log in when providing invalid user information
	@Test	
	public void testInValidLoginIn(){
		driver.findElement(By.name("email")).sendKeys("yufankaren@gmail.com");
		driver.findElement(By.name("password")).sendKeys("hello");

		WebElement loginDiv = driver.findElement(By.id("ap_signin1a_signin_button_row"));

		WebElement submitButton = loginDiv.findElement(By.id("signInSubmit-input"));
		submitButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		try {
			WebElement yourAccount = driver.findElement(By.id("message_error"));
			assertTrue(yourAccount.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}

