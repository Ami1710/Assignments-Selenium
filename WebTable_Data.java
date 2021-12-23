package com.org.learningMaven.myMavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTable_Data {

	public static void main(String[] args){
 
	System.setProperty("webdriver.gecko.driver","./Drivers\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	driver.get("http://demo.guru99.com/test/table.html");
	driver.manage().window().maximize();
	
             
	WebElement table=driver.findElement(By.tagName("table"));
	List<WebElement> rowList=table.findElements(By.tagName("tr"));
	List<WebElement> colList=null;
	
	for(WebElement rows:rowList)
	{
		System.out.println();
		colList=rows.findElements(By.tagName("td"));
		for (WebElement cols:colList)
		{
			System.out.print(cols.getText() + ", ");
		}
	}
	System.out.println();
	 driver.close();
	}
}
























