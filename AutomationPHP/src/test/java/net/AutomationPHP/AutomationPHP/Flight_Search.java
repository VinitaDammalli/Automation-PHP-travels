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

public class Flight_Search 
{
	Logger log = Logger.getLogger(Flight_Search.class);
    @Test
	public  void FlightSearch() throws IOException, InterruptedException  
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
	    
	    //Flight Button
	    driver.findElement(By.xpath("//a[contains(@class,'text-center flights')]")).click();
	    
	    //Enter Source
	    driver.findElement(By.xpath("(//a[@class='select2-choice'])[2]")).click();
	    driver.findElement(By.xpath("(//a[@class='select2-choice'])[2]")).sendKeys(p.getProperty("Source"));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//a[@class='select2-choice'])[2]")).sendKeys(Keys.ENTER);
	    
	   //Enter Destination
	    driver.findElement(By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']")).click();
	    driver.findElement(By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']")).sendKeys(p.getProperty("Destination"));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']")).sendKeys(Keys.ENTER);
	    
	 
	    //Departure 
	    driver.findElement(By.xpath("//input[@id='FlightsDateStart']")).click();
	    Thread.sleep(1000);
	    String s1=driver.findElement(By.xpath("//div[1]//nav[1]//div[2]")).getText();//month
	    do
	    {
	        driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[1]/nav[1]/div[3]/*[1]")).click();//next
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
	                                      
	   //Round Trip
	   driver.findElement(By.xpath("//div[contains(@class,'col-xs-2 col-md-3')]//div[2]")).click();
	    

	   /*//arrival
	   driver.findElement(By.xpath("//input[@id='FlightsDateEnd']")).click();
       Thread.sleep(1000);
       String s2=driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]")).getText();//month
       do
       {
          driver.findElement(By.xpath("//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[2]/nav[1]/div[3]/*[1]")).click();//next_button
          s1=driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]")).getText();//month   
       }
       while(s1.equalsIgnoreCase(p.getProperty("ret_date")));
       List<WebElement> dates1=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
       int count1=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
       System.out.println("count1"+count1);
       for(int i=0;i<count;i++)
       {
          String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div")).get(i).getText();
          if(date.equals(p.getProperty("Return_date")))
          {
             driver.findElement(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div[contains(text(),"+p.getProperty("outdate")+")]")).click();
          }
       }  */
       
       //Adult
       driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//input[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//span[3]//button[1]")).sendKeys(p.getProperty("Adult"));
       
       //Child
       driver.findElement(By.xpath("//div[@id='flights']//div[contains(@class,'col-md-3 col-xs-12')]//div[2]//div[1]//div[1]//div[1]//input[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'row gap-10 mb-15 align-items-end')]//div[2]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'row gap-10 mb-15 align-items-end')]//div[2]//div[1]//div[1]//div[1]//span[3]//button[1]")).sendKeys(p.getProperty("Child"));
	   
       //Infant
       driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//input[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//span[3]//button[1]")).sendKeys(p.getProperty("Infant"));
	 
	   //Search_button
       driver.findElement(By.xpath("//div[contains(@class,'col-xs-12 col-md-1')]//button[contains(@class,'btn-primary btn btn-block')][contains(text(),'Search')]")).click();
       
       log.info("Search for Flight");
	
	
	}
}

