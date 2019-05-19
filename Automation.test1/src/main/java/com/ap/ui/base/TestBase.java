package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListner;

public class TestBase {
	//set the property
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;
	public static WebEventListner eventlistener;
	//constructor
	public TestBase(){
		try{
			propt = new Properties();
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+ "/Automation.test1/src/main/java/com/ap/ui/config/config.properties");
			propt.load(ipa);
		}catch (FileSystemNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	//set the driver property to open
	public static void initialization(){
		String browserName = propt.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources");
		//}
		//else if(browserName.equalsIgnoreCase("FF")){
			//System.setProperty("webdriver.gecko.driver", "provide file path of the driver");
			//driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "");//need to provide file path
			driver = new InternetExplorerDriver();
		}
		//instead of calling the driver multiple time  we are calling the object
		//creating object for action that's occuring and sharing with driver
		en_driver = new EventFiringWebDriver(driver);
		//create object of webeventlistenerto register it witheventFiringWebdriver
		eventlistener = new WebEventListner();
		//event can be captured based on the method we create WebeventListener class
		en_driver.register(eventlistener);
		//since we know object is for browser and en_driver is for event.we declaring with
		//we declaring that they are equal to each when they  are exchanging the info
		driver = en_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load,TimeUnit.SECONDS);
		
		driver.get(propt.getProperty("url"));
		
		
		
		
	}

}
