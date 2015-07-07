package deliverable3;
import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class RedirectTest {
	
	static WebDriver driver = new FirefoxDriver();	
	
	@Before
	public void setUp() throws Exception{
		driver.get("https://www.amazon.com/");
	}
	
	@Test	
	public void testRedirectWitoutLogIn(){
		WebElement navBtn = driver.findElement(By.id("nav-your-amazon"));
	
		navBtn.click();
		
		String newPageTitle = driver.getTitle();
		
		assertTrue(newPageTitle.contains("Sign In"));
		
	}
	
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
