package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePage {
	
	public WebDriver driver;
	
	@Test
	public void homepagetest(){
		driver.findElement(By.xpath("//img[@src='images/draggable.jpg']")).click();
	}

}
