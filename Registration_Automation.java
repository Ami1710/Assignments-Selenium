package com.org.learningMaven.myMavenProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration_Automation {

	public static void main(String[] args) throws InterruptedException {
		
//		WebDriverManager.edgedriver().setup();
		 
// TC001: Opened the webpage		
		System.setProperty("webdriver.gecko.driver","./Drivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().window().maximize();
		
		String exptitle="Login Page";
		String acttitle=driver.getTitle();
		
		if(exptitle.equals(acttitle))
		{
			System.out.println("TC001: Opened the webpage - Passed");
		}
		else
		{
			System.out.println("TC001: Opened the webpage - Failed");
		}
		
// TC002: Login
		
		driver.findElement(By.name("email")).sendKeys("amipthakkar@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("qa123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		String login=driver.getCurrentUrl();
		if(login.contains("success"))
		{
			System.out.println("TC002: Login - Passed");
		}
		else
		{
			System.out.println("TC002: Login - Failed");
		}
		
// TC003: Navigate through New Tours and Register Link
		
		WebElement mouseNT = driver.findElement(By.linkText("New Tours"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseNT);
		actions.click().build().perform();
		
		TimeUnit.SECONDS.sleep(5);
		
		driver.findElement(By.xpath("//a[@href='register.php']")).click();
		
		String tourtitle=driver.getCurrentUrl();
		if(tourtitle.contains("register"))
		{
			System.out.println("TC003: Navigate through New Tours and Register Link - Passed");
		}
		else
		{
			System.out.println("TC003: Navigate through New Tours and Register Link - Failed");
		}
		
// TC004: Verification of Registration Form

		driver.findElement(By.name("firstName")).sendKeys("Ami"); 
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Thakkar");
		driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("4374882355");
		driver.findElement(By.cssSelector("input#userName")).sendKeys("amipthakkar@yahoo.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Trumpet Valley Blvd");
		driver.findElement(By.name("city")).sendKeys("Brampton");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("ON");
		driver.findElement(By.name("postalCode")).sendKeys("L7A3N8");
		new Select(driver.findElement(By.xpath("//select[@name='country']"))).selectByVisibleText("CANADA");
		driver.findElement(By.id("email")).sendKeys("amipthakkar@yahoo.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("qa123");
		driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("qa123");
		driver.findElement(By.name("submit")).click();
		
		String submit=driver.getCurrentUrl();
		if(submit.contains("register_sucess"))
		{
			System.out.println("TC004: Verification of Registration Form: Passed");
		}
		else
		{
			System.out.println("TC004: Verification of Registration Form: Failed");
			
		}
	
		driver.close();
		
	}

}
