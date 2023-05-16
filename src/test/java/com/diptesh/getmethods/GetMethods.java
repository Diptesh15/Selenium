package com.diptesh.getmethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
//		driver.get("https://www.google.com");
//		
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
//		
//		driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("Java Questions");

		System.out.println("Title of the page: " + driver.getTitle());
		System.out.println("Current URL: " + driver.getCurrentUrl());
//		System.out.println("Current page source: " + driver.getPageSource());
		
//		System.out.println(driver.getWindowHandle());
		Thread.sleep(3000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windows =  driver.getWindowHandles(); 
		
		for(String w : windows) {
			System.out.println(w);
		}
		
//		driver.close();
	}
}
