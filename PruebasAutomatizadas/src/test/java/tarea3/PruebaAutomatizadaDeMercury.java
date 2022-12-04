package tarea3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaAutomatizadaDeMercury {
	
	private WebDriver driver;
	
	
	
	By RegisterLinkLocator = By.linkText("REGISTER"); 
	By RegisterPageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
	
	By UsernameLocator = By.id("email");
	By PasswordLocator = By.name("password");
	By ConfirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	
	By SubmitBtnLocator = By.name("submit");

	By UserLocator = By.name("userName");
	By PassLocator = By.name("password");
	By SignInBtnLocator = By.name("submit");
	
	By SuccessPageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font");
	
	
	By SingOnLinkLocator = By.linkText("SIGN-ON");
	By SingOnPageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
	By SingOnUserLocator = By.name("userName");
	By SingOnPassLocator = By.name("password");
	By SingOnBtnSubmit = By.name("submit");
	
	By SupportLinkLocator = By.linkText("SUPPORT");
	By SuppLinkLocator = By.linkText("SUPPORT");
	By SupportPageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/img");
	By BackHomeLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a");
	By HomeLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[5]/td[2]/img");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/driver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}
	
	

	@Test
	public void Register() throws InterruptedException {
		
		driver.findElement(RegisterLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(RegisterPageLocator).isDisplayed()) {
			
			driver.findElement(UsernameLocator).sendKeys("Kevin");
			driver.findElement(PasswordLocator).sendKeys("20210347");
			driver.findElement(ConfirmPasswordLocator).sendKeys("20210347");
			
			driver.findElement(SubmitBtnLocator).click();
		}
		else {
			System.out.print("La pagina de registro no se encontro");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is Kevin.",fonts.get(5).getText());
	}


	@Test
	
	public void FindAFlight() throws InterruptedException {
		
		if(driver.findElement(UserLocator).isDisplayed()) {
			
			driver.findElement(UserLocator).sendKeys("Kevin");
			driver.findElement(PassLocator).sendKeys("20210347");
			driver.findElement(SignInBtnLocator).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(SuccessPageLocator).isDisplayed());
			
		}
		
		else {
			System.out.print("No está en la pagina correcta");
		}
		
		
	}
	
	
	@Test 
	public void SingOn() throws InterruptedException {
	    
		driver.findElement(SingOnLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(SingOnPageLocator).isDisplayed()) {
			driver.findElement(SingOnUserLocator).sendKeys("Kevin");
			driver.findElement(SingOnPassLocator).sendKeys("20210347");
			driver.findElement(SingOnBtnSubmit).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(SuccessPageLocator).isDisplayed());
			
		}
		
		else {
			System.out.print("No está en la pagina correcta");
		}
			
		
		
	}
	
	
	@Test
	public void GoSupport() {
		driver.findElement(SupportLinkLocator).click();
		assertTrue(driver.findElement(SupportPageLocator).isDisplayed());
	
		
	}
	
	
	@Test
	public void GoSupportAndBack() {
		driver.findElement(SuppLinkLocator).click();
		driver.findElement(BackHomeLocator).click();
		assertTrue(driver.findElement(HomeLocator).isDisplayed());
		
		
	}
	
	
	
	
	@After
	public void tearDown() throws Exception {
	
		driver.quit();
	}

	
	
}


