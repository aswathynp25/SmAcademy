package com.v1.sm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.configuration.Config;
import com.v1.sm.ExtentListeners.ExtentListeners;
import com.v1.sm.utilities.DriverFactory;
import com.v1.sm.utilities.DriverManager;

public class BaseTest {
	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	public boolean grid=false;
    private String defaultUserName;
    private String defaultPassword;
    
	@BeforeSuite
	public void setUpFramework() {
		configureLogging();
		DriverFactory.setGridpath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFile(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

		if (System.getProperty("os.name").contains("mac")) {
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver");

		} else {

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		}

		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			config.load(fis);
			log.info("Configuration file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getDefaultUserName() {
		return defaultUserName;
	}

	public void setDefaultUserName(String defaultUserName) {
		this.defaultUserName = defaultUserName;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	public void logInfo(String Message) {
		ExtentListeners.testReport.get().info(Message);
	}
	

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\properties\\log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);

	}

	public void openBrowser(String browser) {
if(System.getenv("ExecutionType")!=null && System.getenv("ExecutionType").equals("Grid")) {
			
			grid=true;
		}
		
		DriverFactory.setRemote(grid);

		if (DriverFactory.isRemote()) {
			
			DesiredCapabilities cap = null;
			if (browser.equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("ie")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplore");
				cap.setPlatform(Platform.WIN10);
			}

			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				log.info("Starting the session on Grid");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			if (browser.equals("chrome")) {
				System.out.println("Launching:" + browser);
				System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());
				driver=new ChromeDriver();
				log.info("Chrome Browser launched !!!");

			} else if (browser.equals("firefox")) {
				System.out.println("Launching:" + browser);
				System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckoDriverExePath());
				driver = new FirefoxDriver();
				log.info("Firefox Browser launched !!!");
			}
		}
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//DriverManager.getDriver().get("https://www.zoho.com/");
       setDefaultUserName(config.getProperty("defaultUserName"));
       setDefaultPassword(config.getProperty("defaultPassword"));
	
	}	

	public void quit() {
		DriverManager.getDriver().quit();
	}
}
