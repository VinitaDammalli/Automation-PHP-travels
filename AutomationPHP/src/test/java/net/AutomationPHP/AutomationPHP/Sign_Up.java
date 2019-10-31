package net.AutomationPHP.AutomationPHP;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sign_Up 
{
	Logger log = Logger.getLogger(Sign_Up.class);
	@Test
	public void SignUp() throws IOException
	{
		Properties p = new Properties();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Desktop\\Vinita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Maven\\AutomationPHP\\target\\data.properties");
	    p.load(fis);
	    PropertyConfigurator.configure("C:\\Maven\\AutomationPHP\\Resources\\log4jPHP.properties");
	    driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-item tr']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(p.getProperty("First_Name"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(p.getProperty("Last_Name"));
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(p.getProperty("Mobile_no"));
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(p.getProperty("Email"));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(p.getProperty("Password"));
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(p.getProperty("Confirm_Password"));
	    driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']")).click(); //Signup
	    log.info("Registration for signup page");
    }
}
