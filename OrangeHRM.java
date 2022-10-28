package orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class OrangeHRM extends SeleniumUtility {
	WebDriver driver;
	@BeforeSuite
	public void before() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		WebElement usernameInputField = driver.findElement(By.name("username"));
		usernameInputField.sendKeys("Admin");
		WebElement passwordInputField = driver.findElement(By.name("password"));
		passwordInputField.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.cssSelector("html>body>div>div>div>div>div>div>div>form>div>button,class"));
		loginButton.click();
	}
	@Test(priority=2)
	public void addmember() throws InterruptedException {
		WebElement newuser=driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		newuser.click();
		Thread.sleep(2000);
		WebElement Firstname = driver.findElement(By.xpath("//div[input[@name=\"firstName\"]]/input"));
		Firstname.clear();
		Firstname.sendKeys("aavan");
		WebElement lastname= driver.findElement(By.xpath("//div[input[@name=\"lastName\"]]/input"));
		lastname.clear();
		lastname.sendKeys("ashanan");
//		WebElement empid = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
//		Thread.sleep(3000);
//		empid.clear();
//		empid.sendKeys("0264");
		WebElement save = driver.findElement(By.xpath("//div[button[text()=\" Save \"]]/button[2]"));
		save.click();
		Thread.sleep(5000);
		
				
	}
	@Test(priority=3)
	public void Pim() {
		WebElement pim = driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']"));
		pim.click();
	}
	@Test(priority=4)
	public void pencil() {
	WebElement checkbox=driver.findElement(By.xpath("//div[@class=\"oxd-table-body\"]//following::div[text()='ashanan']//following::button[i[@class=\"oxd-icon bi-pencil-fill\"]]"));
	checkbox.click();
	}
	
	@Test(priority=5)
	public void job() {
		WebElement job=driver.findElement(By.xpath("//div[a[text()=\"Job\"]]"));
		job.click();
	}
	
	@Test(priority=1)
	
	public void Del() {
		List<WebElement>Alllist=driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]"));
		for (int i = 0; i < Alllist.size(); i++) 
		{
			if(Alllist.get(i).getText().contains("aavan"))
			{
			
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[9]/div/button[1]")).click();
				WebElement alert=driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
				alert.click();
				System.out.println("Elememt Deleted Successfully" );	
			}
		else {
			System.out.println("NO ELEMENT FOUND");
		}
		}
	}
//		@AfterSuite
//		public void logout() {
//		WebElement logout=driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
//		logout.click();
//		WebElement buttonlogout=driver.findElement(By.xpath("//a[text()=\"Logout\"]"));
//		buttonlogout.click();
//		}
			
	
//		WebElement delete = driver.findElement(By.xpath("//div[div[contains(text(),\"aavan\")]]"));
//		delete.click();
//		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
//		confirm.click();
	}


