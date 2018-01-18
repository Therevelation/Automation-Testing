//Section 3 Lecture 19, 20

package demos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver
		System.setProperty("webdriver.gecko.driver", "D:\\Automation with Java- DESKTOP ONLY\\SDET University -Selenium with Java\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
		// 2. Open browser to Account Management Page >> Click on create account.
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click();
		
		// 3. Fill out the form
		//How to locate elements
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
		driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("1231231234"); // rel XPath
		//driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/div[5]/div[2]/input")).sendKeys("1231231234"); // abs XPath
		
	

		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass"); //Attribute used = id
		//driver.findElement(By.cssSelector("input[type='password']")).sendKeys("mspass"); // Attribute used = type
		driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']")).sendKeys("mspass"); // Retype pass- Attribute used = id

		//driver.findElement(By.id("MainContent_Female")).click();
		//driver.findElement(By.cssSelector("input[id='MainContent_Female']")).click(); //Using CSS Selector- ID
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click(); //Using CSS Selector - name
		// The above code actually worked without the ] bracket after female- Surprising.
		
		new Select (driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany"); // New Library called Select
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click(); //Teacher found element by name
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
	
	// 4. Get confirmation  
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10); // After 3 hours of waiting and asking on stack overflow , adding these 2 lines of code saved the day!
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MainContent_lblTransactionResult")));
		
		
	String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
	//WebElement we = driver.findElement(By.id("MainContent_lblTransactionResult")); //code from a guy at Stack overflow to check if element is found.
	//System.out.println("test: -   " + we);
	
	//WebElement we = driver.findElement(By.id("MainContent_lblTransactionResult")‌​); 

	System.out.println("CONFIRMATION: " + conf);
		
		 
		// 5. Close the browser
		
		driver.close();
	}

}
