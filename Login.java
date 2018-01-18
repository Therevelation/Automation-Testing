package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1.Set the property
		System.setProperty("webdriver.chrome.driver", "D:\\Google Drive\\CAREER\\AUTOMATION\\SDET University -Selenium with Java- Universal\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
			
		// 2.Navigate to the web application
		// Navigate to http://sdettraining.com/trguitransactions/AccountManagement.aspx
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
				
		//Find Elements: Locate the element, Determine the action, Pass any parameters
		
		// 3. Enter email address
		
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		
		// 4. Enter password
		
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		
	
		// 5. Click Login
		
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		
		// 6. Get confirmation
		
		String message = driver.findElement(By.id("conf_message")).getText();
		
		System.out.println("CONFIRMATION:" + message);

				
		// 7. Close browser
		
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE TEST PASSED: " + pageTitle);
		
		}
	
	}


