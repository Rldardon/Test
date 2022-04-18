package com.example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {

	private WebDriver driver;
	private String url;

	@Test
	public void f() throws InterruptedException {

		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Me");
		driver.findElement(By.xpath("//div[text()='Mexico']")).click();
		
		
		driver.findElement(By.xpath("//*[@name='dropdown-class-example']//descendant::option[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='dropdown-class-example']//descendant::option[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='dropdown-class-example']//descendant::option[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='dropdown-class-example']//descendant::option[4]")).click();
		
		driver.findElement(By.id("openwindow")).click();
		
		List<String> listaVentanas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(listaVentanas.get(1));
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ejemplo@");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		Thread.sleep(3000);
	
				
		
		WebElement testSelf  = driver.findElement(By.xpath("//h3[text()='30 day Money Back Guarantee']"));
		String textoTitulo = testSelf.getText();
		System.out.println(textoTitulo);
		Thread.sleep(3000);	
		Assert.assertEquals("30 DAY MONEY BACK GUARANTEE", textoTitulo);
		Thread.sleep(3000);		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,1800);");
				
		Thread.sleep(3000);
		takeScreenshot("./resources/screen/screen-1.png");
		Thread.sleep(3000);		
		driver.close();
		
		driver.switchTo().window(listaVentanas.get(0));
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#name")).sendKeys("Stori Card");
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		Thread.sleep(3000);
		
		Alert alert1=driver.switchTo().alert();
		Thread.sleep(3000);
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(3000);
		alert1.accept();
		Thread.sleep(3000);
		
		
		driver.findElement(By.cssSelector("#name")).sendKeys("Stori Card");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		Thread.sleep(3000);
		
		Alert alert2=driver.switchTo().alert();
		Thread.sleep(3000);
		String alertMessage2=driver.switchTo().alert().getText();
		System.out.println(alertMessage2);
		Thread.sleep(3000);
		alert2.accept();
		Thread.sleep(3000);
		System.out.println(":):):):):)");  
		
		List<WebElement> table= driver.findElements(By.id("product"));
		
	
		for(WebElement objCurrentLink : table) {				
					
			String elements= objCurrentLink.getText();	
			System.out.println(elements);				
				
				
			}
		 
		
		/*
		driver.findElement(By.xpath("(//th[text()])[1]"));
		driver.findElement(By.xpath("(//th[text()])[2]"));
		driver.findElement(By.xpath("(//th[text()])[3]"));
		
		driver.findElement(By.xpath("(//td[text()])[4]"));
		driver.findElement(By.xpath("(//td[text()])[5]"));
		driver.findElement(By.xpath("(//td[text()])[6]"));
		
		driver.findElement(By.xpath("(//td[text()])[13]"));
		driver.findElement(By.xpath("(//td[text()])[14]"));
		driver.findElement(By.xpath("(//td[text()])[15]"));
		
		driver.findElement(By.xpath("(//td[text()])[19]"));
		driver.findElement(By.xpath("(//td[text()])[20]"));
		driver.findElement(By.xpath("(//td[text()])[21]"));
		
		driver.findElement(By.xpath("(//td[text()])[22]"));
		driver.findElement(By.xpath("(//td[text()])[23]"));
		driver.findElement(By.xpath("(//td[text()])[24]"));
		
		
		driver.findElement(By.xpath("(//th[text()])[4]"));
		driver.findElement(By.xpath("(//th[text()])[5]"));
		driver.findElement(By.xpath("(//th[text()])[6]"));
		
		driver.findElement(By.xpath("(//td[text()])[31]"));
		driver.findElement(By.xpath("(//td[text()])[32]"));
		driver.findElement(By.xpath("(//td[text()])[33]"));
		driver.findElement(By.xpath("(//td[text()])[34]"));
		
		driver.findElement(By.xpath("(//td[text()])[51]"));
		driver.findElement(By.xpath("(//td[text()])[52]"));
		driver.findElement(By.xpath("(//td[text()])[53]"));
		driver.findElement(By.xpath("(//td[text()])[54]"));*/
		
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
	// Metodo para tomar Screenshots
		
		private void takeScreenshot(String imgURL) {
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(imgURL));
			} catch (Exception e) {
				System.out.println("Error al crear el archivo");
				e.printStackTrace();
			}
		}

}
