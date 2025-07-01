package com.main.testCases;

import java.util.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class Main {
	private String baseUrl = "https://www.district.in/";
	public WebDriver driver;
	public HashMap<String,String> list=new HashMap<String,String>();
	
	public WebDriver createDriver(){
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		return driver;
	}
	
	public void getTopValues(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".dds-w-8.dds-h-8.dds-flex.dds-items-center.dds-justify-center")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[3]/div/div/div/div/div[2]/div[1]/div/div[10]/img")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Activities']")).click();
		System.out.println("clicked activities");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		do{
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(3000);
			i++;
		}while(i<10);
		System.out.println("scrolling");
		
		List<WebElement> activities= driver.findElements(By.cssSelector("a.dds-h-full"));
		System.out.println("collect elements");
		
		for (WebElement act :activities) {
			String text = act.getText();
			System.out.println(text);
		}
		
		

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main ui = new Main();
		WebDriver driver = ui.createDriver();
		try {
			ui.getTopValues(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

