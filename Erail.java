package com.org.learningMaven.myMavenProject;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		TimeUnit.SECONDS.sleep(2);
	
		Actions actions = new Actions(driver);
		WebElement mouse = driver.findElement(By.id("txtStationFrom"));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Ahmedabad");
		actions.moveToElement(mouse);
		actions.moveToElement(driver.findElement(By.xpath("//div[@title='Ahmedabad Jn']")));
		actions.click().build().perform();
		
		driver.findElement(By.id("txtStationTo")).clear();
		mouse = driver.findElement(By.id("txtStationTo"));
		driver.findElement(By.id("txtStationTo")).sendKeys("Chennai");
		actions.moveToElement(mouse);
		actions.moveToElement(driver.findElement(By.xpath("//div[@title='Chennai Beach Jn']")));
		actions.click().build().perform();
		
		mouse = driver.findElement(By.xpath("//input[@title='Select Departure date for availability']"));
		actions.moveToElement(mouse);
		actions.click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("((//table[@class='Month'])[2])")));
		actions.moveToElement(driver.findElement(By.xpath("//td[@onclick='DoDateSelect(1640980800000)']")));
		actions.click().build().perform();
		
		driver.findElement(By.xpath("//select[@id='cmbQuota']"));
		new Select(driver.findElement(By.xpath("//select[@id='cmbQuota']"))).selectByVisibleText("Foreign");
		
		new Select(driver.findElement(By.id("selectTrainType"))).selectByVisibleText("Super Fast - 2");
		new Select(driver.findElement(By.id("selectClassFilter"))).selectByVisibleText("3A - 3Tier AC");
		
		driver.findElement(By.id("buttonFromTo")).click();
		driver.findElement(By.xpath("//a[@title='Click on train number to View fare and schedule']")).click();
		
		new Select(driver.findElement(By.xpath("//select[@id='selectAdult']"))).selectByVisibleText("2 Adult");
		WebElement fare = driver.findElement(By.xpath("//td[@id='tdFareGN3']"));
		System.out.println("Fare = "+fare.getText());
		
		driver.close();
	}
}
