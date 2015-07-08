//User story: As a customer, I want to redirect the webpage from Amazon.com to Your Amazon.com page so that I can view my activities and information.
//Scenario 1: Given Amazon.com opened and I am a customer who wants to redirect the web page from Amazon.com to Your Amazon.com page, when I clicked “Your Amazon.com” without logged in, it will direct to the SignIn page.
//Scenario 2: Given Amazon.com opened and I am a customer who wants to redirect the web page from Amazon.com to Your Amazon.com page, when I clicked “Your Amazon.com” with logged in, it will direct to Your Amazon.com page.
package deliverable3;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//Test if the Amazon redirect to the correct page given some condition
public class RedirectTest {

	static WebDriver driver = new FirefoxDriver();	

	@Before
	public void setUp() throws Exception{
		driver.get("https://www.amazon.com/");
	}

	//When user doesn't log in and he or she clicks the navigation button, it should redirect to the log in page
	@Test	
	public void testRedirectWitoutLogIn(){
		WebElement navBtn = driver.findElement(By.id("nav-your-amazon"));

		navBtn.click();

		String newPageTitle = driver.getTitle();

		assertTrue(newPageTitle.contains("Sign In"));

	}

	//When user logs in and he or she clicks the navigation button, it should his or her homepage in amazon
	@Test	
	public void testRedirectWithLoginIn(){

		WebElement navBtn = driver.findElement(By.id("nav-your-amazon"));	
		navBtn.click();

		driver.findElement(By.name("email")).sendKeys("yufankaren@gmail.com");
		driver.findElement(By.name("password")).sendKeys("helloamazon");
		WebElement loginDiv = driver.findElement(By.id("ap_signin1a_signin_button_row"));		
		WebElement submitButton = loginDiv.findElement(By.id("signInSubmit-input"));
		submitButton.click();

		WebElement navBtn2 = driver.findElement(By.id("nav-your-amazon"));		
		navBtn2.click();

		String newPageTitle = driver.getTitle();

		assertTrue(newPageTitle.contains("Amazon.com"));

	}

}

