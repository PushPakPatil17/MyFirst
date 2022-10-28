package eXcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.SeleniumUtility;

public class OrangeHRM extends SeleniumUtility{
	String URL,username,password,Login;
	@BeforeTest
	public void Sheet() {
		URL=ExcelUtility.getCellValue(".\\src\\test\\resources\\ExcelFiles\\excelFile.xlsx", "Sheet1", 1,0);
		username=ExcelUtility.getCellValue(".\\src\\test\\resources\\ExcelFiles\\excelFile.xlsx", "Sheet1", 1,1);
		password=ExcelUtility.getCellValue(".\\src\\test\\resources\\ExcelFiles\\excelFile.xlsx", "Sheet1", 1,2);
	}
	@Test
	public void browser() {
		WebDriver driver=setUp("chrome", URL);
				driver.get(URL);
	}
	@Test
	public void login() {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//div[button[text()=\" Login \"]]")).click();
	}
	@Test
	public void newuser() {
		driver.findElement(By.xpath("//div[button[text()=\" Add \"]]")).click();
	}
}
