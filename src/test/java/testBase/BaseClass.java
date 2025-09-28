package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;   ///log4j
import org.apache.logging.log4j.Logger;        ///log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public  static WebDriver driver;
	public Logger logger;  //log4j
	public Properties p; ///property file
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		
		//LOADING CONFIG.PROPERTIES FILE
		FileInputStream file=new FileInputStream(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		logger=LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver(); break;
		
		default:System.out.println("invalid browser");return;
		}
		
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
		///lunch url using property file
		driver.get(p.getProperty("appURL"));//Reading url from property file
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	 public void tearDown()
	 {
		driver.quit();
	 }
	
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return generatednumber;
	}
	
	public String randomeAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return(generatedstring+generatednumber);
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("use.dir")+"\\screenshots\\"+tname+"" +timeStamp +".png";
	    File targetFile=new File(targetFilePath);
	    sourceFile.renameTo(targetFile);
	    return targetFilePath; 
	}

}
