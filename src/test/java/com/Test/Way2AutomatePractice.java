package com.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Way2AutomatePractice {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.way2automation.com/demo.html");
	}
	
	@Test
	public void test1() throws InterruptedException{
		driver.findElement(By.xpath("//img[@src='demo/images/draggable.jpg']")).click();
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> itr = allwindow.iterator();
		while(itr.hasNext()){
			String parentwindow = itr.next();
			String childwindow = itr.next();
			driver.switchTo().window(childwindow);
		}
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "http://way2automation.com/way2auto_jquery/index.php");
		
		WebElement nameelement = driver.findElement(By.name("name"));
		
		Dimension namesize = nameelement.getSize();
		int nameheight = nameelement.getSize().getHeight();
		int namewidth = nameelement.getSize().getWidth();
		System.out.println("Size :" + namesize);
		System.out.println("Height :" + nameheight);
		System.out.println("Width :" + namewidth);
		
		Point point = nameelement.getLocation();
		double xCord = point.getX();
		double yCord = point.getY();
		System.out.println("X Cord :" + xCord);
		System.out.println("Y Cord :" + yCord);
		
		driver.findElement(By.xpath("//a[text()='Signin']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/fieldset[1]/input")).sendKeys("shobhit1anand");
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/fieldset[2]/input")).sendKeys("shobhit321");
		
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).submit();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='images/draggable.jpg']")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@id='draggable'])[1]")), 200, 150).build().perform();
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
