package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePDF {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Automation\\testing-automation\\RF_Common_Code_LIVE\\src\\test\\resources\\properties\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String chromeIgnito = prop.getProperty("chromeIncognito");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome"))
		{
		//Chrome browser invocation
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// if (chromeIgnito.equalsIgnoreCase("true"))
		// options.addArguments("incognito");
		Map<String, Object> prefs = new HashMap<String, Object>();
		// Set default download directory (make sure to provide the complete path)
		prefs.put("download.default_directory", "C:\\RFCCC Project\\RF_Common_Code_LIVE\\PDF-Downloads"); // Change to your preferred folder

		// Disable PDF viewer and download PDF files directly
		prefs.put("plugins.always_open_pdf_externally", true);

		// Set Chrome options
		// ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize(); 
		}
		else if(browserName.equals("firefox"))
		{
		//Firefox browser invocation
		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		}
		else if(browserName.equals("edge"))
		{
		//Edge browser invocation
		System.setProperty("webdriver.edge.driver", "C:\\BrowserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;


		}
	
	
	public void clickBeforePDF() throws InterruptedException
	{
		Thread.sleep (7000);
		Set<String>id=driver.getWindowHandles();
		Iterator<String> ids=id.iterator();
		String Parent=ids.next();
		String Child=ids.next();
		driver.switchTo().window(Child);
		Thread.sleep(7000);
		System.out.println("Files download successfully"); 
		Thread.sleep(1000); 
		driver.close() ;
		driver.switchTo().window(Parent);
		Thread.sleep (1000);

	}
	}
	

