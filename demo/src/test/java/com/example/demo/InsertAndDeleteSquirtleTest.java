// Generated by Selenium IDE
package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertAndDeleteSquirtleTest {


	@Test
	public void insertAndDeleteSquirtleTest() {
		// given
		driver.get("http://localhost:8080/");
		driver.manage().window().maximize();

		// when
		driver.findElement(By.id("id")).sendKeys("1");
		driver.findElement(By.id("nombre")).sendKeys("Squirtl");
		driver.findElement(By.id("apellido")).sendKeys("blastoise");
		driver.findElement(By.xpath("//input[@value=\'Enviar datos\']")).click();


		// then
		assertEquals(driver.findElement(By.xpath("//td[contains(.,'Squirtl')]")).getText(), "Squirtl");
		assertEquals(driver.findElement(By.xpath("//td[contains(.,\'blastoise\')]")).getText(), "blastoise");

		// CleanUp
		driver.findElement(By.id("deleteBtnSquirtl")).click();
	}

	private static WebDriver driver;
	private static Map<String, Object> vars;
	static JavascriptExecutor js;

	@BeforeAll
	public static void setUp() {
		//System.setProperty("webdriver.chrome.driver", "/Users/alberto/Downloads/chromedriver-mac-arm64/chromedriver");
		System.setProperty("webdriver.chrome.driver", "/home/alberto/Descargas/chromedriver-linux64/chromedriver");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}
