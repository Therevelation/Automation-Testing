//Copied and pasted this from "Create account" test script- Enhanced version for parameterizing data

package demos;
  
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount {

	public static void main(String[] args) { 
		String name = "Mary Smith";
		String email = "ms@testemail.com";
		String password = "mspass";
		String phoneNumber = "1231231234";
		String country = "Germany";	
		String browserType = "chrome";
		String gender = "female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = true;
		boolean occassionalEmail = true;
		
						
		// Define Web Driver
		//System.out.println("Start...");
		
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType); //calling driver factory in utilities
		//System.out.println("Browser Toggled");
		
			
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//System.out.println("Website Open...");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click(); //logical xpath
		
		//Define Web elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement occasionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		
		
		//How to locate elements
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//System.out.print("Ready to send keys...");
		//System.out.print("  ");
				
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber); // rel XPath
		passwordElement.sendKeys(password); //Attribute used = id
		verifyPasswordElement.sendKeys(password); // Retype pass- Attribute used = id
		new Select (countryElement).selectByVisibleText(country); // New Library called Select

				
		//Gender Radio button algorithm
				
		if (gender.equalsIgnoreCase("Male")) {maleRadio.click(); }
		else { femaleRadio.click(); }
				
		
		////////////////////// Weekly Email////////////////////////////////
		
		
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				  weeklyCheckbox.click();
			}
			
		}
		else {
			if (!weeklyCheckbox.isSelected()) {
		       weeklyCheckbox.click();
			}
		}
		
		////////////////////// Monthly Email////////////////////////////////
						
		
		if (monthlyEmail) {
			if (!monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
			
		}
		else {
			if (monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
				
		
		
		////////////////Occasional email /////////////////////////////
		if (occassionalEmail) {
			if (occasionalCheckbox.isSelected()) {
				  occasionalCheckbox.click();
			}
			
		}
		else {
			if (!occasionalCheckbox.isSelected()) {
		       occasionalCheckbox.click();
			}
		}
		
		
		// 4. Get confirmation  & Close browser.

		submitButton.click();
	
		//WebDriverWait wait = new WebDriverWait(driver, 10); // After 3 hours of waiting and asking on stack overflow , adding these 2 lines of code saved the day!
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MainContent_lblTransactionResult")));
		
				
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.equals(expected)) {
			System.out.println("CONFIRMATION: " + conf);

		}
		
		else {
			System.out.println("TEST FAILED");
		}
		
		
		driver.close();

	}

}
