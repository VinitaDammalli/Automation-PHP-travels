package net.AutomationPHP.AutomationPHP;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tours_Search 
{
	Logger log = Logger.getLogger(Tours_Search.class);
	@Test
	public void ToursSearch() throws IOException, InterruptedException 
	{
		Properties p = new Properties();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Desktop\\Vinita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Maven\\PHPtravels\\src\\main\\java\\data.properties");
	    p.load(fis);
	    PropertyConfigurator.configure("C:\\Maven\\AutomationPHP\\Resources\\log4jPHP.properties");
	    driver.get(p.getProperty("url"));
	    driver.manage().window().maximize();
	    
	    //Tour button
	    driver.findElement(By.xpath("//a[contains(text(),'Tours')]")).click();
	    
	    //City name
	    driver.findElement(By.xpath("//div[@id='s2id_autogen8']")).click();
	    driver.findElement(By.xpath("//div[@id='select2-drop']//input[contains(@class,'select2-input')]")).sendKeys(p.getProperty("City_name"));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='select2-drop']//input[contains(@class,'select2-input')]")).sendKeys(Keys.ENTER);
	    
	    //Tour_type
	    driver.findElement(By.xpath("//div[@id='tourtype_chosen']//a[contains(@class,'chosen-single')]")).click();
	    driver.findElement(By.xpath("//li[contains(text(),'Holidays')]")).click();
	    
	    //Check in
	    driver.findElement(By.xpath("//input[@id='DateTours']")).click(); //check in
	    Thread.sleep(1000);
	    String s1=driver.findElement(By.xpath("//div[6]//nav[1]//div[2]")).getText();//month
	    do
	    {
	        driver.findElement(By.xpath("//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[6]/nav[1]/div[3]/*[1]")).click();//next
	        s1=driver.findElement(By.xpath("//div[1]//nav[1]//div[2]")).getText();//month      
	    }
	        while(s1.equalsIgnoreCase(p.getProperty("check_in")));
	        List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
	        int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
	        System.out.println("count"+count);
	        for(int i=0;i<count;i++)
	        {
	             String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).get(i).getText();
	             if(date.equals(p.getProperty("indate")))
	             {
	                 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[contains(text(),"+p.getProperty("indate")+")]")).click();
	             }
	        }
	    
	    //Guest
	    driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
	    
	    
	    //Search button
	    driver.findElement(By.xpath("//div[@class='col-md-2 col-xs-12']//button[@class='btn btn-primary btn-block'][contains(text(),'Search')]")).click();
	    
	    log.info("Search for Tour");
	}

}

