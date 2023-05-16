package com.diptesh.testCaseDay1;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {
	public static void main(String[] args) throws InterruptedException {
		
		
		//System.setProperty("webDriver.chrome.driver", "C:\\New folder\\chromedriver_win32\\chromedriver");
		//1. Launch chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//2. Open the URL
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//3. Provide username
//		WebElement txtUsername = driver.findElement(By.name("username"));
//		txtUsername.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		//4. Provide password
		driver.findElement(By.name("password")).sendKeys("admin23");
		
		//5. Click on login
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		Thread.sleep(5000);
		//6. Verify title of dashboard
		/*String act = driver.getTitle(); // capture title of current web page
		String exp = "OrangeHRM";
		if(act.equals(exp)) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		
		//Failing the test case as the title of two websites is same.
		
		//Hence, we need to find another point of validations
		*/
		
		//Validations based on label---Capturing the label of webpage and then comparing it to the actual name
		
		//After giving invalid credentials login will fail so the above element will not be present(It will try to find the element in login page itself)
		//So it will throw NoSuchElement error
		String act_lbl = null;	//Or you can initialize it to "" which is empty string
		
		try {
			act_lbl = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
//			act_lbl = act_lbl_ele.getText();
		}catch(NoSuchElementException c) {
			act_lbl = "";	//If initialized to empty string then no need to add this statement
		}
		
		
		String exp_lbl = "Dashboard";
		
		if(act_lbl.equals(exp_lbl)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
		//7. Close the driver
	//	driver.close();		Throws socket exception else use quit()
		//driver.quit();
	}
}
