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

public class Log_In 
{
	Logger log = Logger.getLogger(Log_In.class);
    @Test
	public  void LogIn() throws IOException 
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
        driver.findElement(By.xpath("//a[@class='dropdown-item active tr']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(p.getProperty("Email"));
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(p.getProperty("Password"));
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']")).click();  //Login
        log.info("Registration for login page ");
	}
}
